package Example;

class Table {
    synchronized void PrintTable(int n){
        for (int i = 1; i <= 10; i++) {
            System.out.println(n+"*"+i+"="+(n*i));
        }
    }

}
class ta extends Thread{
    Table t;
    ta(Table t){
        this.t = t;
    }
    public void run(){
        t.PrintTable(5);

    }
}
class tb extends Thread{
    Table t ;
    tb(Table t){
        this.t = t;

    }
    public void  run(){
        t.PrintTable(6);
    }
}


public class SynchronizationProto {
    public static void main(String[] args) {
        Table t = new Table();
        ta t1 = new ta(t);
        t1.start();
        tb t2 = new tb(t);
        t2.start();
    }
}

