package ir.maktabsharif.thread;

public class ConsoleEraser extends Thread {
    private boolean running = true;

    public void run() {
        while (running) {
            System.out.print("\b*");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                running = false;
                break;
            }
        }
    }

    public void halt() {
        running = false;
    }
}