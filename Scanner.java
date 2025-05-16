import java.util.Scanner;

public class Scanner{

public static void main(String[] args){

Scanner scanner = new Scanner (System.in);

System.out.println("The name of the user: ");
String name= scanner.nextLine();
 
System.out.println("welcome buddy: "+name);
}
}
