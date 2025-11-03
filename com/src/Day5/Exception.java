package com.Day5;
import java.util.Scanner;
public class Exception  {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int[] num={10,20,30,40,50};
        String s="apple";
        try {
//            System.out.println(num1 / num2);
           System.out.println(num[5]);
            //int nums=Integer.parseInt(s);
           // System.out.println(nums);
        }
        catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception Happened: "+e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index out of bound exception: "+e.getMessage());
        }

        finally {
            sc.close();
        }
        System.out.println("Last line of the program");
    }
}