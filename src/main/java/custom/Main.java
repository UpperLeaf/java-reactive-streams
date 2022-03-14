package custom;

import java.util.concurrent.Flow.Publisher;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TempProcessor tempProcessor = new TempProcessor();
        tempProcessor.subscribe(new TempSubscriber());

        getTemperatures("New Work").subscribe(tempProcessor);

        Thread.sleep(10000);
    }

    private static Publisher<TempInfo> getTemperatures(String town) {
        return subscriber -> {
            subscriber.onSubscribe(new TempSubscription(subscriber, town));
        };
    }
}
