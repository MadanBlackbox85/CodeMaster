package Collections;
import java.util.*;

public class ListDemoProto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> l = new LinkedList<>(Arrays.asList(12, 23, 34, 45, 65, 78));

            System.out.println("1. Add element at last");
            System.out.println("2. Add element at first");
            System.out.println("3. Add element at the given index");
            System.out.println("4. Update element at the given index");
            System.out.println("5. Delete the first element");
            System.out.println("6. Delete the last element");
            System.out.println("7. Delete the given element");
            System.out.println("8. Delete the element at given index");
            System.out.println("9. Display the elements");
            System.out.println("10. Exit");
            System.out.println(l);
        while (true) {
            System.out.println("Enter The Option");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Element:");
                    int opr1 = sc.nextInt();
                    l.addLast(opr1);
                    break;
                case 2:
                    System.out.println("Enter Element:");
                    int opr2 = sc.nextInt();
                    l.addFirst(opr2);
                    break;
                case 3:
                    System.out.println("Enter Element:");
                    int opr3 = sc.nextInt();

                    System.out.println("Enter Index");
                    int ind = sc.nextInt();
                    l.add(ind, opr3);
                    break;
                case 4:
                    System.out.println("Enter Element To Update:");
                    int opr4 = sc.nextInt();

                    System.out.println("Enter Index");
                    int ind4 = sc.nextInt();
                    l.set(ind4, opr4);
                    break;
                case 5:
                    l.removeFirst();
                    break;
                case 6:
                    l.removeLast();
                    break;
                case 7:
                    System.out.println("Enter Element To Delete");
                    int ele7 = sc.nextInt();
                    l.remove(Integer.valueOf(ele7));
                    break;
                case 8:
                    System.out.println("Enter Index To Delete");
                    int ind8 = sc.nextInt();
                    l.remove(ind8);
                    break;
                case 9:
                    System.out.println("List of Elements" + ":" + l);
                    break;
                case 10:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice");System.exit(1);
            }
        }
    }
}
