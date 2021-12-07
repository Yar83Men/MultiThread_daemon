package MultiThreads;

public class DaemonEx {
    public static void main(String[] args) {
        System.out.println("Main starts");
        UserThread userThread = new UserThread();
        userThread.setName("userThread");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("daemonThread");
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
        System.out.println("Main end");
    }
}


class UserThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  " + isDaemon());
        for (char i = 'A'; i <  'Z'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  " + isDaemon());
        for (int i = 1; i <  1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}