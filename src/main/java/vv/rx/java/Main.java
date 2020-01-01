package vv.rx.java;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public class Main {
    public static void main(String[] args) {
        System.out.println( Thread.currentThread().getName() +" - " +Thread.currentThread().getId());
//        Flowable.fromArray(args).subscribe( s ->  System.out.println(s + " - " + Thread.currentThread()));

        Observable.create(observableEmitter -> {
           Producer producer = new Producer(observableEmitter);
           producer.start();
        }).subscribe(new Consumer());
        // observer and subscriber use the same thread.
    }
}
