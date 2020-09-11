package fyfrel.mylibrary.utility;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class UConsole {
    /**
     * Print a String
     * @param toPrint String to show to the user
     */
    public static void print(String toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an int on a line for each one in the Array
     * @param toPrints Array of String converted to String to show to the user
     */
    public static void print(String[] toPrints) {
        for (String toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }

    /**
     * Print a char
     * @param toPrint char to show to the user
     */
    public static void print(char toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an char on a line for each one in the Array
     * @param toPrints Array of char converted to String to show to the user
     */
    public static void print(char[] toPrints) {
        for (char toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print a byte
     * @param toPrint byte to show to the user
     */
    public static void print(byte toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an byte on a line for each one in the Array
     * @param toPrints Array of byte converted to String to show to the user
     */
    public static void print(byte[] toPrints) {
        for (byte toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print a short
     * @param toPrint short to show to the user
     */
    public static void print(short toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an short on a line for each one in the Array
     * @param toPrints Array of short converted to String to show to the user
     */
    public static void print(short[] toPrints) {
        for (short toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print an Integer
     * @param toPrint Integer converted to string to show to the user
     */
    public static void print(int toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an int on a line for each one in the Array
     * @param toPrints Array of int converted to String to show to the user
     */
    public static void print(int[] toPrints) {
        for (int toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print a long
     * @param toPrint long converted to string to show to the user
     */
    public static void print(long toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an long on a line for each one in the Array
     * @param toPrints Array of long converted to String to show to the user
     */
    public static void print(long[] toPrints) {
        for (long toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print a float
     * @param toPrint float converted to string to show to the user
     */
    public static void print(float toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an float on a line for each one in the Array
     * @param toPrints Array of float converted to String to show to the user
     */
    public static void print(float[] toPrints) {
        for (float toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print a double
     * @param toPrint double converted to string to show to the user
     */
    public static void print(double toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an double on a line for each one in the Array
     * @param toPrints Array of double converted to String to show to the user
     */
    public static void print(double[] toPrints) {
        for (double toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print a BigDecimal
     * @param toPrint BigDecimal converted to string to show to the user
     */
    public static void print(BigDecimal toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an BigDecimal on a line for each one in the Array
     * @param toPrints Array of BigDecimal converted to String to show to the user
     */
    public static void print(BigDecimal[] toPrints) {
        for (BigDecimal toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print a BigInteger
     * @param toPrint BigInteger converted to string to show to the user
     */
    public static void print(BigInteger toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an BigInteger on a line for each one in the Array
     * @param toPrints Array of BigInteger converted to String to show to the user
     */
    public static void print(BigInteger[] toPrints) {
        for (BigInteger toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print a Boolean
     * @param toPrint Boolean converted to string to show to the user
     */
    public static void print(Boolean toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an Boolean on a line for each one in the Array
     * @param toPrints Array of Boolean converted to String to show to the user
     */
    public static void print(Boolean[] toPrints) {
        for (Boolean toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print an Object
     * @param toPrint Object converted to string to show to the user
     */
    public static void print(Object toPrint) {
        System.out.println(toPrint);
    }
    /**
     * Print an Object on a line for each one in the Array
     * @param toPrints Array of Object converted to String to show to the user
     */
    public static void print(Object[] toPrints) {
        for (Object toPrint : toPrints) {
            System.out.println(toPrint);
        }
    }



    /**
     * Print an unspecified element on a line for each one in the ArrayList
     * @param toPrints Array of unspecified elements converted to String to show to the user
     */
    public static void print(ArrayList toPrints) {
        Boolean testresult = true;
        try {
            ArrayList test = (ArrayList) toPrints.get(0);
        } catch (Exception e) {
            testresult = false;
        }

        for (Object toPrint : toPrints) {
            if(testresult) {
                UConsole.print((ArrayList) toPrint);
                return;
            }
            System.out.println(toPrint);
        }
    }











    /**
     * Print a String
     * @param toPrint String to show to the user
     */
    public static void error(String toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an int on a line for each one in the Array
     * @param toPrints Array of String converted to String to show to the user
     */
    public static void error(String[] toPrints) {
        for (String toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }

    /**
     * Print a char
     * @param toPrint char to show to the user
     */
    public static void error(char toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an char on a line for each one in the Array
     * @param toPrints Array of char converted to String to show to the user
     */
    public static void error(char[] toPrints) {
        for (char toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print a byte
     * @param toPrint byte to show to the user
     */
    public static void error(byte toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an byte on a line for each one in the Array
     * @param toPrints Array of byte converted to String to show to the user
     */
    public static void error(byte[] toPrints) {
        for (byte toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print a short
     * @param toPrint short to show to the user
     */
    public static void error(short toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an short on a line for each one in the Array
     * @param toPrints Array of short converted to String to show to the user
     */
    public static void error(short[] toPrints) {
        for (short toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print an Integer
     * @param toPrint Integer converted to string to show to the user
     */
    public static void error(int toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an int on a line for each one in the Array
     * @param toPrints Array of int converted to String to show to the user
     */
    public static void error(int[] toPrints) {
        for (int toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print a long
     * @param toPrint long converted to string to show to the user
     */
    public static void error(long toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an long on a line for each one in the Array
     * @param toPrints Array of long converted to String to show to the user
     */
    public static void error(long[] toPrints) {
        for (long toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print a float
     * @param toPrint float converted to string to show to the user
     */
    public static void error(float toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an float on a line for each one in the Array
     * @param toPrints Array of float converted to String to show to the user
     */
    public static void error(float[] toPrints) {
        for (float toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print a double
     * @param toPrint double converted to string to show to the user
     */
    public static void error(double toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an double on a line for each one in the Array
     * @param toPrints Array of double converted to String to show to the user
     */
    public static void error(double[] toPrints) {
        for (double toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print a BigDecimal
     * @param toPrint BigDecimal converted to string to show to the user
     */
    public static void error(BigDecimal toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an BigDecimal on a line for each one in the Array
     * @param toPrints Array of BigDecimal converted to String to show to the user
     */
    public static void error(BigDecimal[] toPrints) {
        for (BigDecimal toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print a BigInteger
     * @param toPrint BigInteger converted to string to show to the user
     */
    public static void error(BigInteger toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an BigInteger on a line for each one in the Array
     * @param toPrints Array of BigInteger converted to String to show to the user
     */
    public static void error(BigInteger[] toPrints) {
        for (BigInteger toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print a Boolean
     * @param toPrint Boolean converted to string to show to the user
     */
    public static void error(Boolean toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an Boolean on a line for each one in the Array
     * @param toPrints Array of Boolean converted to String to show to the user
     */
    public static void error(Boolean[] toPrints) {
        for (Boolean toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print an Object
     * @param toPrint Object converted to string to show to the user
     */
    public static void error(Object toPrint) {
        System.err.println(toPrint);
        new Exception().printStackTrace();
    }
    /**
     * Print an Object on a line for each one in the Array
     * @param toPrints Array of Object converted to String to show to the user
     */
    public static void error(Object[] toPrints) {
        for (Object toPrint : toPrints) {
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }



    /**
     * Print an unspecified element on a line for each one in the ArrayList
     * @param toPrints Array of unspecified elements converted to String to show to the user
     */
    public static void error(ArrayList toPrints) {
        Boolean testresult = true;
        try {
            ArrayList test = (ArrayList) toPrints.get(0);
        } catch (Exception e) {
            testresult = false;
        }

        for (Object toPrint : toPrints) {
            if(testresult) {
                UConsole.error((ArrayList) toPrint);
                return;
            }
            System.err.println(toPrint);
        }
        new Exception().printStackTrace();
    }









    /**
     * Basic scan that return a String
     * @return the value of the input of the user
     */
    public static String scan() {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        return sc.next();
    }
    /**
     * Scan that ask something and return a String
     * @param toAsk to show to the user before using an input
     * @return the value of the user input
     */
    public static String scan(String toAsk) {
        UConsole.print(toAsk);
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        return sc.next();
    }



    /**
     * Scan and convert to int
     * Re ask if the user didn't input an int
     * @param wantInt can be any int
     * @return the user input parsed to Int
     */
    public static int scan(int wantInt) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String userInput = sc.next();
        if(UMath.testStringToInt(userInput)) {
            return Integer.parseInt(userInput);
        }
        UConsole.print("Une erreur est survenue recommencez");
        return UConsole.scan(wantInt);
    }
    /**
     * Scan that ask something and convert to int
     * Re ask if the user didn't input an int
     * @param toAsk to show to the user before using an input
     * @param wantInt can be any int
     * @return the user input parsed to Int
     */
    public static int scan(String toAsk, int wantInt) {
        UConsole.print(toAsk);
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String userInput = sc.next();
        if(UMath.testStringToInt(userInput)) {
            return Integer.parseInt(userInput);
        }
        UConsole.print("Une erreur est survenue recommencez");
        return UConsole.scan(toAsk, wantInt);
    }



    /**
     * Scan and convert to float
     * Re ask if the user didn't input a float
     * @param wantFloat can be any float
     * @return the user input parsed to Float
     */
    public static float scan(float wantFloat) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String userInput = sc.next();
        if(UMath.testStringToFloat(userInput)) {
            return Float.parseFloat(userInput);
        }
        UConsole.print("Une erreur est survenue recommencez");
        return UConsole.scan(wantFloat);
    }
    /**
     * Scan that ask something and convert to float
     * Re ask if the user didn't input a float
     * @param toAsk to show to the user before using an input
     * @param wantFloat can be any float
     * @return the user input parsed to Float
     */
    public static float scan(String toAsk, float wantFloat) {
        UConsole.print(toAsk);
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String userInput = sc.next();
        if(UMath.testStringToFloat(userInput)) {
            return Float.parseFloat(userInput);
        }
        UConsole.print("Une erreur est survenue recommencez");
        return UConsole.scan(toAsk, wantFloat);
    }



    /**
     * Scan and convert to double
     * Re ask if the user didn't input a double
     * @param wantDouble can be any double
     * @return the user input parsed to double
     */
    public static double scan(double wantDouble) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String userInput = sc.next();
        if(UMath.testStringToDouble(userInput)) {
            return Double.parseDouble(userInput);
        }
        UConsole.print("Une erreur est survenue recommencez");
        return UConsole.scan(wantDouble);
    }
    /**
     * Scan that ask something and convert to double
     * Re ask if the user didn't input a double
     * @param toAsk to show to the user before using an input
     * @param wantDouble can be any double
     * @return the user input parsed to double
     */
    public static double scan(String toAsk, double wantDouble) {
        UConsole.print(toAsk);
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String userInput = sc.next();
        if(UMath.testStringToDouble(userInput)) {
            return Double.parseDouble(userInput);
        }
        UConsole.print("Une erreur est survenue recommencez");
        return UConsole.scan(toAsk, wantDouble);
    }



    /**
     * Scan and convert to long
     * Re ask if the user didn't input a long
     * @param wantLong can be any long
     * @return the user input parsed to long
     */
    public static long scan(long wantLong) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String userInput = sc.next();
        if(UMath.testStringToLong(userInput)) {
            return Long.parseLong(userInput);
        }
        UConsole.print("Une erreur est survenue recommencez");
        return UConsole.scan(wantLong);
    }
    /**
     * Scan that ask something and convert to long
     * Re ask if the user didn't input a long
     * @param toAsk to show to the user before using an input
     * @param wantLong can be any long
     * @return the user input parsed to long
     */
    public static long scan(String toAsk, long wantLong) {
        UConsole.print(toAsk);
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String userInput = sc.next();
        if(UMath.testStringToInt(userInput)) {
            return Long.parseLong(userInput);
        }
        UConsole.print("Une erreur est survenue recommencez");
        return UConsole.scan(toAsk, wantLong);
    }
}
