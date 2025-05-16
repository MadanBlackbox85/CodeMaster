import javax.swing.JOptionPane;

public class GUI {

    public static void main(String[] args) {

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter the age please"));
String name = JOptionPane.showInputDialog(null , "enter name ");
if (age >= 18) {
    JOptionPane.showMessageDialog(null, "You are an adult." +name);
} else {
    JOptionPane.showMessageDialog(null, "You are a minor.");
}

         
                  }
}
/*String name = JOptionPane.showInputDialog("Enter the name");         
*        JOptionPane.showMessageDialog(null, "Hi:" + name);
*int age = Integer.parseInt(JOptionPane.showInputDialog("Enter the age please"));\\(The "parseInt" is used to convert the string into integer of the usser given data)
*JOptionPane.showMessageDialog(null, "your age is :" + age + "year old");
*
*float hight = Float.parseFloat(JOptionPane.showInputDialog("Enter the hight please"));
*JOptionPane.showMessageDialog(null, "your age is :" + hight + "");
*/
