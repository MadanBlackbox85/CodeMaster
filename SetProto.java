package Collections;
//import java.util.*; // to add complete packages of util use (*)
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
//Set In Collections
public class SetProto {
    public static void main(String[] args) {
        //HashSet
        HashSet h = new HashSet();
        h.add("Key");
        h.add("Lock");
        h.add("Mock");
        h.add("Rock");
        System.out.println(h.add("Key"));//No Duplicate Element
        System.out.println(h);
        // LinkedHashSet
        LinkedHashSet<String> l = new LinkedHashSet<>();
        l.add("Key");
        l.add("Lock");
        l.add("Mock");
        l.add("Rock");
        System.out.println(l.add("Key"));//No Duplicate Element
        System.out.println(l);
        //TreeSet
        TreeSet<String> t = new TreeSet<>();
        t.add("Rock");
        t.add("Mock");
        t.add("Lock");
        t.add("Key");

        System.out.println(t.add("Key"));//No Duplicate Element
        System.out.println(t);
        System.out.println(t.descendingSet());
    }
}
