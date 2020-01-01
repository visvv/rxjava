package vv.rx.java;

import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Consumer implements Observer {
    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("Subscription started !!");
    }

    @Override
    public void onNext(Object o) {
        System.out.println( "Consumer - " + o + "  " + Thread.currentThread().getName() +" - " +Thread.currentThread().getId());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completed !!");
    }
}
