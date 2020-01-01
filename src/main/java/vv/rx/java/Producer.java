package vv.rx.java;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class Producer extends Thread {
    private ObservableEmitter observableEmitter;

    public Producer(ObservableEmitter observableEmitter) {
        this.observableEmitter = observableEmitter;
        // this.observableEmitter.onError(new Exception("ConnectionFailed"));
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if (!this.observableEmitter.isDisposed()) {
                this.observableEmitter.onNext("Msg " + i);
                System.out.println("Producer - " + "Msg " + i + " " + Thread.currentThread().getName() + " - " + Thread.currentThread().getId());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    this.observableEmitter.onError(e);
                }
            }
        }
        if (!this.observableEmitter.isDisposed()) {
            this.observableEmitter.onComplete();
        }
    }
}
