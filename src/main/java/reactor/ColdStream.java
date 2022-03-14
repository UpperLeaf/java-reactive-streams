package reactor;

import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ColdStream implements Runnable {
    @Override
    public void run() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        Mono<Integer> mono = Mono.just(1);

        List<Integer> list = new ArrayList<>();
        flux.log()
            .subscribe(new Subscriber<>() {
                private Subscription s;
                int onNextAmount;

                @Override
                public void onSubscribe(Subscription s) {
                    this.s = s;
                    s.request(2);
                }

                @Override
                public void onNext(Integer integer) {
                    list.add(integer);
                    onNextAmount++;
                    if (onNextAmount % 2 == 0) {
                        s.request(2);
                    }
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onComplete() {

                }
            });
    }
}
