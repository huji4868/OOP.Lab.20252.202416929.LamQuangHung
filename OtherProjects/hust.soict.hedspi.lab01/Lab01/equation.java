package Lab01;// 2.2.6
import javax.swing.JOptionPane;
public class equation {
    public static void main(String [] args){
        String Degree = JOptionPane.showInputDialog(null,"Please input the degree of equation: ","Input the degree of equation",JOptionPane.INFORMATION_MESSAGE);

        int DegreeChosen = Integer.parseInt(Degree);

        if (DegreeChosen == 1){
            String Type = JOptionPane.showInputDialog(null,"Please select the type:\n1. Linear equation with one variable\n2. Linear system with two variables","Select the type",JOptionPane.INFORMATION_MESSAGE);
            int TypeChosen = Integer.parseInt(Type);

            if (TypeChosen == 1){
                String a,b;
                a = JOptionPane.showInputDialog(null,"Please input a: ","Type: ax + b = 0",JOptionPane.INFORMATION_MESSAGE);
                b = JOptionPane.showInputDialog(null,"Please input b: ","Type: ax + b = 0",JOptionPane.INFORMATION_MESSAGE);

                Double aChosen = Double.parseDouble(a);
                Double bChosen = Double.parseDouble(b);

                if (aChosen == 0){
                    if (bChosen == 0){
                        JOptionPane.showMessageDialog(null,"Infinite solutions");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No solutions");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"The solution is x = " + (-1 * bChosen)/aChosen);

                }
            }
            else if (TypeChosen == 2){
                JOptionPane.showMessageDialog(null,"Type: a11*x + a12*y = b1\na21*x + a22*y = b2");

                double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11: "));
                double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12: "));
                double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1: "));
                double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21: "));
                double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22: "));
                double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2: "));

                double D = a11 * a22 - a21 * a12;
                double Dx = b1 * a22 - b2 * a12;
                double Dy = a11 * b2 - a21 * b1;

                if (D != 0){
                    JOptionPane.showMessageDialog(null,"x1 = " + Dx/D + "\nx2 =" + Dy/D);
                }
                else{
                    if (Dx != 0 || Dy != 0){
                        JOptionPane.showMessageDialog(null,"No solutions");
                    }
                    else if (Dx == 0 && Dy == 0){
                        JOptionPane.showMessageDialog(null,"Infinite solutions");
                    }
                }
            }
        }

        else if (DegreeChosen == 2){
            JOptionPane.showMessageDialog(null,"Type: ax² + bx + c = 0");

            double a = Double.parseDouble(JOptionPane.showInputDialog(null,"Please input a: "));
            double b = Double.parseDouble(JOptionPane.showInputDialog(null,"Please input b: "));
            double c = Double.parseDouble(JOptionPane.showInputDialog(null,"Please input c: "));

            if (a == 0){
                if (b == 0){
                    JOptionPane.showMessageDialog(null,(c == 0) ? "Infinite solutions" : "No solutions");
                }
                else{
                    JOptionPane.showMessageDialog(null,"x = " + -c/b);
                }
            }
            else{
                double denta = b * b - 4 * a * c;
                if (denta < 0){
                    JOptionPane.showMessageDialog(null,"No solutions");
                }
                else if (denta == 0){
                    JOptionPane.showMessageDialog(null,"x1 = x2 = " + -b/(2*a));
                }
                else{
                    JOptionPane.showMessageDialog(null,"x1 = " + (-b + Math.sqrt(denta))/(2*a) + "\nx2 = " + (-b - Math.sqrt(denta))/(2*a));
                }
            }
        }
        System.exit(0);
    }
}
