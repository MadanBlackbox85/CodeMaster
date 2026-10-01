package Example;

class MyThread extends Thread{

    public void run(){

        System.out.println(" NANO BOT running.......");
        System.out.println(" NANO BOT running.......");
        Thread t = Thread.currentThread();
        t.setName("BOT THREAD---0.255146678555AdgrtSSerFBGU");
        t.setPriority(1);
        System.out.println(t);
        System.err.println(t.getName());
   }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        MyThread t1 = new MyThread();
        t1.start();
    }
}
