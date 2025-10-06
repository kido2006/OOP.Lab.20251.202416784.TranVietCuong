package lab01;

import java.util.Scanner;
public class Bai64DaysOfMonth {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int year, month = 0;

        while (true) {
            System.out.print("Enter month (name, abbreviation, or number): ");
            String input = keyboard.next().trim();
            month = convertMonth(input);

            if (month == -1) {
                System.out.println("Invalid month. Please try again.\n");
                keyboard.nextLine(); 
                continue;
            }

            System.out.print("Enter year (non-negative integer): ");
            if (!keyboard.hasNextInt()) {
                System.out.println("Invalid year. Please enter a number.\n");
                keyboard.nextLine();
                continue;
            }

            year = keyboard.nextInt();
            if (year < 0) {
                System.out.println("Year must be non-negative.\n");
                continue;
            }

            break; 
        }

        int days = getDaysOfMonth(month, year);

        System.out.println("The month of year you entered has " + days + " days.");
        keyboard.close();
    }

    //func

    private static int convertMonth(String input) {
        switch (input.toLowerCase()) {
            case "1": case "january": case "jan.": case "jan": return 1;
            case "2": case "february": case "feb.": case "feb": return 2;
            case "3": case "march": case "mar.": case "mar": return 3;
            case "4": case "april": case "apr.": case "apr": return 4;
            case "5": case "may":  return 5;
            case "6": case "june": case "jun.": case "jun": return 6;
            case "7": case "july": case "jul.": case "jul": return 7;
            case "8": case "august": case "aug.": case "aug": return 8;
            case "9": case "september": case "sept.": case "sep.": case "sep": return 9;
            case "10": case "october": case "oct.": case "oct": return 10;
            case "11": case "november": case "nov.": case "nov": return 11;
            case "12": case "december": case "dec.": case "dec": return 12;
            default: return -1;
        }
    }

    private static int getDaysOfMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
