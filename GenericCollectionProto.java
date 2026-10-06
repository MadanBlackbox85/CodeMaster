package Collections;

import java.util.LinkedList;
//Generics are used to specify the data type that a collection can store.
//We use < > to specify the type.
//[String] means only String values can be stored.
//[Integer] means only String values can be stored.
//It prevents wrong data types from being added.
//Generics provide type safety at compile time.
//Generics reduce type casting, because Java already knows the data type.
//LinkedList comes from the java.util package, so we import it:
//Generics make collections safer, easier, and type-specific.
public class GenericCollectionProto {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        //l.add(10);
        l.add("link");
        l.add("List");
        l.add("ADE");
        System.out.println(l);
        for (String s:l){ // To access the single element at one time [foreach Loop]
            System.out.println(s);
        }
    }
}
