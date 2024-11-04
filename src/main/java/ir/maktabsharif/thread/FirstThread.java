package ir.maktabsharif.thread;

public class FirstThread implements Runnable {


    @Override
    public void run() {
        Thread thread = new Thread(this);
        try {
            Thread.sleep(2222);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
    }

}
