public class Main {

    public static void main(String[] args) {
        System.out.println("Tester tråder i Java...");

        ThreadMachine t1 = new ThreadMachine("En");
        t1.start();
        ThreadMachine t2 = new ThreadMachine("To");
        t2.start();
        ThreadMachine t3 = new ThreadMachine("Tre");
        t3.start();
        ThreadMachine t4 = new ThreadMachine("Fire");
        t4.start();
        ThreadMachine t5 = new ThreadMachine("Fem");
        t5.start();

    }
}

class ThreadMachine implements Runnable {

    private Thread t;
    private String threadName;

    ThreadMachine(String name) {
        threadName = name;
        System.out.println("Lager tråd: " + threadName);
    }
    @Override
    public void run() {
        System.out.println("Kjører tråd: " + threadName);

            for (int i = 1; i <= 5; i++) {
                System.out.println("Tråd " + threadName + " = " + i);

                // Gi fra oss kontrollen:
                Thread.yield();

                // Gjør noe "jobb"...
                if (false) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        System.out.println("Tråden ble avbrutt: " + threadName);
                    }
                }
            }
        System.out.println("Tråden avslutter: " + threadName);

    }

    public void start() {
        System.out.println("Starter tråd: " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}