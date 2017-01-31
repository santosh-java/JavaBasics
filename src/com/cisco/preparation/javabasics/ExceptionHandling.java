package com.cisco.preparation.javabasics;

import java.util.IllegalFormatException;

/**
 * Created by MSantoshGiriGovind on 12/13/2016.
 */
public class ExceptionHandling {
    public static void main(String args[]) {
        try{
            int x = 1, y=1;
            x = x++ + ++y;
            y = ++x + ++y;

            System.out.println("X = " + x + " : Y = " + y);

            int x1 = 99;
            int y1 = 24;

            int k = x1 ^ y1;
            System.out.println(" XOR ::"+k);
            System.out.println(" To get 99 :: "+(k^24));
            System.out.println(" To get 24 :: "+(k^99));
            System.out.println(" UnsignedRightShift of 99 by 2 is: " + (99>>>2));
            System.out.println(" UnsignedLeftShift of 24 by 2 is: " + (24<<2));
        }catch(Exception nfe)
        {
            nfe.printStackTrace();
        }finally
        {
            System.out.println("finally block");
        }

        System.out.println("After catch block");
    }
}
