package com.Day1;
import java.util.Scanner;
public class EvenOddNumber {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        
        if (num % 2 == 0) {
            System.out.println("The number is Even");
        } else {
            System.out.println("The number is Odd");
        }
        
        sc.close();
    }
}
