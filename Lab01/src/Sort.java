// 6.5
import java.util.Scanner;
public class Sort {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        double[] str = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++){
            System.out.println("Enter each element: ");
            str[i] = sc.nextDouble();
            sum += str[i];
        }
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i; j++){
                if (str[j] > str[j+1]){
                    double temp = str[j];
                    str[j] = str[j+1];
                    str[j+1] = temp;
                }
            }
        }
        System.out.println("Sorted array: ");
        for (double val : str){
            System.out.println(val + " ");
        }
        System.out.println();

        double average = sum / n;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);

        sc.close();
    }
}
