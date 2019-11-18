package controller;

import rx.Observable;
import rx.Observer;
import service.FileHeper;
import service.WikiManager;

public class ProcessWikiLinksController {

    public void process() {

        Observer<String> observers = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("process completed");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onNext(String s) {
               Runnable runnable = () -> {
                   FileHeper.saveToFileListElementsApi("article.txt", WikiManager.getWikiNewsFromUrlApi(s));
               };
               Thread thread = new Thread(runnable);
               thread.start();
            }
        };

        Observable.from(WikiManager.urls).subscribe(observers);
    }

    public static void main(String[] args) {
        new ProcessWikiLinksController().process();
    }

}
