package fyfrel.mylibrary.utility;

import java.util.concurrent.ThreadLocalRandom;

public class UMath {
    /**
     * Test if a String can be converted to an Integer
     * @param toTest the String to test
     * @return a Boolean if it can be converted
     */
    public static Boolean testStringToInt(String toTest) {
        try {
            Integer.parseInt(toTest);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Test if a String can be converted to an Long
     * @param toTest the String to test
     * @return a Boolean if it can be converted
     */
    public static Boolean testStringToLong(String toTest) {
        try {
            Long.parseLong(toTest);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Test if a String can be converted to an Float
     * @param toTest the String to test
     * @return a Boolean if it can be converted
     */
    public static Boolean testStringToFloat(String toTest) {
        try {
            Float.parseFloat(toTest);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Test if a String can be converted to an Double
     * @param toTest the String to test
     * @return a Boolean if it can be converted
     */
    public static Boolean testStringToDouble(String toTest) {
        try {
            Double.parseDouble(toTest);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Randomize a number between a certain range
     * @param min int start of the range
     * @param max int end of the range
     * @return a randomized number
     */
    public static int randomNumber(Integer min, Integer max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Search the factorial of a number
     * @param number to factorize
     * @return the factorial of the number
     */
    public static int factorial(int number) {
        if(number < 0) {
            return -1;
        }
        if (number==0) {
            return(1);
        }
        return(number*UMath.factorial(number-1));
    }

}
