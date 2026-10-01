package Example;

class threadA extends Thread{

    public void run(){
        Thread t = Thread.currentThread();
        t.setName("ThreadA1....");
        for (int i = 80; i <=100 ; i++) {
            System.err.println(t.getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
class threadR implements Runnable{
    @Override // annotation - added in java 5 version
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+" ");
        }
    }
}
class threadB extends Thread{
    public void run(){
        Thread t = threadB.currentThread();
        t.setName("ThreadB1");
        for (int i = 100; i>=80; i--) {

            System.out.println(t.getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class MultiThreadProto {
    public static void main(String[] args) {
        threadA a = new threadA();
        a.start();
        threadB b = new threadB();
        b.start();
        threadR r = new threadR();
        Thread t = new Thread(r);
        t.start();

    }
}
