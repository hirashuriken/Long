package com.example.LongInt;

public class Main {
        public static void main(String args[])
        {
            String StrR1 = "22";
            String StrR2 = "2";
            LongInt num1 = new LongInt(StrR1);
            LongInt num2 = new LongInt(StrR2);
            LongInt num3, num4, num5;

            System.out.println("a = " + StrR1);
            System.out.println("b = " + StrR2);

            System.out.print("a + b = ");
            num3 = num1.Plus(num2);
            num3.Show();
            System.out.print("a * b = ");
            num4 = num1.Multi(num2);
            num4.Show();
            System.out.print("a - b = ");
            num5 = num1.Subtraction(num2);
            num5.Show();
        }
 }
