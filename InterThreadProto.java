package Example;

class threadSum extends Thread{
    int sum = 0;
    public void run(){
        for (int i = 0; i <=100; i++) {

            sum = sum + i;
            synchronized (this) {
                notify();
            }
        }
    }
}
public class InterThreadProto {
    public static void main(String[] args) throws InterruptedException {
        threadSum s = new threadSum();
        s.start();
        synchronized (s) {
            s.wait();
        }
        System.out.println("sum ="+s.sum);
    }
}
