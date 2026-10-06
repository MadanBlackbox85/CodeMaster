package Collections;

import java.util.*;

public class MapProto {
    public static void main(String[] args) {
        //HashMap
        HashMap<Integer,String> m = new HashMap<>();
        m.put(3,"Raju");
        m.put(4, "John");
        m.put(1,"costa");
        m.put(2,"Rosta");
        System.out.println(m);
        //linkedHashmap
        LinkedHashMap k = new LinkedHashMap();

        k.put(3,"Raju");
        k.put(4, "John");
        k.put(1,"costa");
        k.put(2,"Rosta");
        System.out.println(k);
        //TreeMap
        TreeMap t = new TreeMap();
        t.put(3,"Raju");
        t.put(4, "John");
        t.put(1,"costa");
        t.put(2,"Rosta");
        System.out.println(t);
        System.out.println(t.descendingMap());
        HashMap j = new LinkedHashMap();
        j.put(12,"VG");
        System.out.println(j);

    }
}
