package reactor;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class HotStream implements Runnable {
    @Override
    public void run() {
        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
                                                  while (true) {
                                                      fluxSink.next(System.currentTimeMillis());
                                                  }
                                              })
                                              .sample(Duration.of(2, ChronoUnit.SECONDS))
                                              .log()
                                              .subscribeOn(Schedulers.parallel())
                                              .publish();

        publish.subscribe(value -> System.out.println("첫번째 구독자 : " + value));
        publish.subscribe(value -> System.out.println("두번째 구독자 : " + value));

        publish.connect();
    }
}
