package Lab01;// 6.6
import java.util.Scanner;
public class Matrixs {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Number of columns: ");
        int columns = sc.nextInt();

        double [][] matrix1 = new double [rows][columns];
        double [][] matrix2 = new double [rows][columns];
        double [][] sum = new double [rows][columns];

        System.out.println("Enter maxtrix1: ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print("Matrix1[" + i + "][" + j +"] ");
                matrix1[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Enter maxtrix2: ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print("Matrix2[" + i + "][" + j +"] ");
                matrix2[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Sum of 2 matrixs = ");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}
