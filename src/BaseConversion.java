/**
 * Convert a number from one base system to another
 * This class has a 3 argument constructor and 1 public method.
 *
 *
 */
public class BaseConversion {
    /**
     * Stores the original number.
     */
    private String originalNum;
    /**
     * Stores the new number
     */
    private String newNum;
    /**
     * Stores the original base
     */
    private int originalBase;
    /**
     * Stores the new base desired.
     */
    private int newBase;

    /**
     * BaseCoversion constructor that takes in all arguments to find the new num.
     * @param originalNum original number input
     * @param originalBase original base input
     * @param newBase new desired base
     */
    public BaseConversion(String originalNum, int originalBase, int newBase){
        newNum = Convert(originalNum,originalBase,newBase);
    }



    /**
     * Converts a number from 1 base to another.
     * @param originalNum original number inputed
     * @param originalBase original base inputed
     * @param newBase newBase of new number
     * @return returns the new number of the new base
     */
    public static String Convert(String originalNum, int originalBase, int newBase){
        //Variables
        double v = 0;
        char digit;
        double Decimal = 0;

        //Loop through number
        int length = originalNum.length();
        for(int y = 0; y < length; y++){
            //obtain digit
            digit = Character.toUpperCase(originalNum.charAt(length-1-y));

            //get decimal
            if(Character.isLetter(digit)){
                Decimal = digit - 'A' + 10;
            }else if(Character.isDigit(digit)){
                Decimal = digit - '0';
            }
            //add value to the total.
            v += Decimal * Math.pow(originalBase,y);
        }
        //determine digits in new base
        int det = 1;
        for(; Math.pow(newBase,det) <= v; det++){}

        //store new digits
        char[] newNum = new char[det];

        double power;

        for(int k = det-1; k >= 0; k--){
            //calculate digit
            power = Math.pow(newBase,k);
            Decimal = Math.floor(v/power);
            v -= Decimal*power;

            //store
            if(Decimal <= 9){
                newNum[det-1-k] = (char) ('0' + (int)Decimal);
            } else {
                newNum[det-1-k] = (char) ('A' + (int)(Decimal-10));
            }
        }

        return new String(newNum);

    }

    /**
     * Method to print out the newNum
     */
    public void print(){
        System.out.println("New Number: " + newNum);
    }
}
