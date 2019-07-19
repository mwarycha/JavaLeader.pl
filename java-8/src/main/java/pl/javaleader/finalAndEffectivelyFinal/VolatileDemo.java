package pl.javaleader.finalAndEffectivelyFinal;

import static java.lang.Thread.sleep;

interface Operation {
    void doOperation();
}

class MyRunnable implements Runnable {
    private volatile boolean active;
    public void run() {
        active = true;
        while (active) {

        }
        Operation operation = () -> System.out.println(active);
        operation.doOperation();
    }
    public void stop() {
        active = false;
    }
}
public class VolatileDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                try { sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myRunnable.stop();
            }
        }).start();
    }
}
