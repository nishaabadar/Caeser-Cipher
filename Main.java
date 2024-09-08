/*
Name: Nishaa B
Date: 11/10/21
Description: This file in the program uses the idea of a
Caesar Cipher which allows a user to input a message and 
asks how much they would like to shift it. The results 
that they get is the encoded version of the message that 
they typed.
*/

import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        // Your program goes here
        // Scanner object
        Scanner input = new Scanner(System.in);
        
        //Asks input for a message
        System.out.println("Enter a message: ");
        String message = input.nextLine();
        System.out.println();
        
        //Asks input for number of shifts
        System.out.println("How much would you like to shift your message: ");
        int shift = input.nextInt();
        System.out.println();
        
        //Printing out the encoded message
        Cipher encodedMessage = new Cipher(message, shift);
        //encodedMessage.setShift(2); //Example
        System.out.println("The encoded message is:");
        encodedMessage.encode();
        
        // Make a new file from the left panel for the caesar cipher class
    }
}