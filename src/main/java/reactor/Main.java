package reactor;

import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        HotStream hotStream = new HotStream();
        hotStream.run();

        Thread.sleep(10000);
    }
}
