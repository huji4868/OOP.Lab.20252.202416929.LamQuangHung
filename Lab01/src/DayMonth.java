// 6.4
import java.util.Scanner;
public class DayMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = -1;
        int year = -1;

        while (true) {
            System.out.print("Enter month: ");
            String mInput = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter year: ");
            String yInput = sc.nextLine().trim();

            try {
                year = Integer.parseInt(yInput);
                if (year < 0) {
                    System.out.println("Invalid year");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format");
                continue;
            }

            if (mInput.equals("january") || mInput.equals("jan.") || mInput.equals("jan") || mInput.equals("1")) month = 1;
            else if (mInput.equals("february") || mInput.equals("feb.") || mInput.equals("feb") || mInput.equals("2")) month = 2;
            else if (mInput.equals("march") || mInput.equals("mar.") || mInput.equals("mar") || mInput.equals("3")) month = 3;
            else if (mInput.equals("april") || mInput.equals("apr.") || mInput.equals("apr") || mInput.equals("4")) month = 4;
            else if (mInput.equals("may") || mInput.equals("5")) month = 5;
            else if (mInput.equals("june") || mInput.equals("jun.") || mInput.equals("jun") || mInput.equals("6")) month = 6;
            else if (mInput.equals("july") || mInput.equals("jul.") || mInput.equals("jul") || mInput.equals("7")) month = 7;
            else if (mInput.equals("august") || mInput.equals("aug.") || mInput.equals("aug") || mInput.equals("8")) month = 8;
            else if (mInput.equals("september") || mInput.equals("sept.") || mInput.equals("sep") || mInput.equals("9")) month = 9;
            else if (mInput.equals("october") || mInput.equals("oct.") || mInput.equals("oct") || mInput.equals("10")) month = 10;
            else if (mInput.equals("november") || mInput.equals("nov.") || mInput.equals("nov") || mInput.equals("11")) month = 11;
            else if (mInput.equals("december") || mInput.equals("dec.") || mInput.equals("dec") || mInput.equals("12")) month = 12;
            else {
                System.out.println("Invalid month. Please enter again!");
                continue;
            }

            break;
        }

        int days = 0;
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                days = 29;
            } else {
                days = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            days = 31;
        }

        System.out.println("Month " + month + " in Year " + year + " has " + days + " days.");

        sc.close();
    }
}