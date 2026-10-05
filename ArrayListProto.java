package Collections;

import java.util.*;

public class ArrayListProto {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.add(12);
        a.add(13);
        a.add("aaa");
        a.add("bbb");
        System.out.println(a);
        a.add(2,"ccc");//Updating with new element
        System.out.println(a);
        a.set(2,"ade"); // Replacing the index 2 element with "ade"
        System.out.println(a);
        a.remove("ade");
        System.out.println(a);
        a.remove(2);
        System.out.println(a);
        String  s = a.get(2).toString();
        System.out.println(s);
        System.out.println(a.size());
    }
}
