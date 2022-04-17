import java.util.Locale;
import java.util.Scanner;
public class BaseConversionDriver {
    /**
     * BaseConversion Driver Class
     * Driver class to test  BaseConversion.java
     * @author James Ostrowski
     */
    public static void main(String[] args){
        //Initialize
        Scanner sc = new Scanner(System.in);
        String originalNum;
        int originalBase;
        int newBase = 0;
        String counter;

        int x = 1;
        while (x == 1) {
            //Get original data
            System.out.println("Enter original Number: ");
            originalNum = sc.nextLine();
            System.out.print("Enter original Base: ");
            originalBase = sc.nextInt();

            //Validate original
            if(CheckBase(originalBase) == false) {
                x = 0;
            }else if(CheckNum(originalNum, originalBase) == false){
                x = 0;
            }else {
                //Get new base
                System.out.println("Enter new base: ");
                newBase = sc.nextInt();
            }

            if(CheckBase(newBase) == false){
                x = 0;
            }
            BaseConversion b = new BaseConversion(originalNum, originalBase, newBase);

            b.print();
            sc.nextLine();

            System.out.println("Would you like to convert another number, enter 'yes' or 'no'");
            counter = sc.nextLine();

            if(counter.equals("no")){
                x = 0;
            }

        }

    }


    /**
     * Check that a valid base was entered
     * @param base base value entered
     * @return true or false for valid
     */
    public static boolean CheckBase(int base){
        if (base < 2 || base >32){
            System.out.println("Error: Not a valid base value");
            return false;
        }else {
            return true;
        }
    }

    /**
     * Check that the number is valid in that base.
     * @param num string representation of the number
     * @param base base value
     * @return true or false for valid
     */
    public static boolean CheckNum(String num, int base){
        boolean valid = true;
        char digit;
        for(int x = 0; x < num.length(); x ++){
            digit  = num.toUpperCase().charAt(x);
            if(Character.isDigit(digit) && (digit - '0') >= base){
                System.out.println("Digit cannot be in this base");
                valid = false;
            } else if(Character.isLetter(digit) && (digit - 'A')+10 >= base){
                System.out.println("Digit cannot be in this base");
                valid = false;
            } else if(!Character.isDigit(digit) && !Character.isLetter(digit)){
                System.out.println("Invalid input");
                valid =  false;
            }else
                valid = true;
        }
        return valid;
    }
}
