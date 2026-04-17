package Lab01;// 2.2.5
import javax.swing.JOptionPane;
public class CalculateTwoNumbers{
    public static void main(String [] args){
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null,"Please input the first number: ","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second number: ","Input the second number",JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double subtraction = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        JOptionPane.showMessageDialog(null,"The sum of two numbers: " + sum);
        JOptionPane.showMessageDialog(null,"The subtraction of two numbers: " + subtraction);
        JOptionPane.showMessageDialog(null,"The product of two numbers: " + product);
        JOptionPane.showMessageDialog(null,"The divide of two numbers: " + quotient);

        System.exit(0);
    }
}

