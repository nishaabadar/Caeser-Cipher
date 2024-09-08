/*
Name: Nishaa Badar
Date: 11/10/21
Description: This file in the program creates a class for 
the Cipher object which includes the encode method that 
encodes the users input and there is a helper method which 
formats the message in the correct manner. There are setters 
getters for the formal parameters of the Cipher object as well. 
*/

//Cipher object
public class Cipher {
    //Attributes
    private String message;
    private int shift;
    
    //Constructor
    public Cipher(String theMessage, int theShift) {
        this.message = theMessage;
        this.shift = theShift;
    }
    
    //Encode method to create the new encoded message
    public void encode() {
        String newMessage = ""; //Empty string for the new message
        message = message.toUpperCase(); //Capitalize all letters
        
        //Changes shifts to an equivalent simpler value
        if (shift > 26) { //When shift is greater than 26
            shift = shift % 26;
        } else if (shift < 0) { //When shift is less than 0
            shift = (shift % 26) + 26;
        }
        
        //Loop to traverse through the message
        for(int i = 0; i < message.length(); i++) {
            //Returns the character at a specific index of the 
            //string message
            char letter = message.charAt(i); 
            //Makes sure that only alphabets are shifted
            if (letter >= 65 && letter <= 90) {
                //New shifted character
                char newLetter = (char)(letter + shift);
                //Converts non-alphabet characters back to the 
                //correct alphabet
                if (newLetter > 'Z') {
                    newLetter = (char)(newLetter + 'A' - 'Z' - 1);
                }
                //Adds the shifted letter to the new message
                newMessage += newLetter; 
            //Ignores the non-alphabet characters by outputting nothing
            } else {
                newMessage += "";
            }
        }
        //Calls the helper method to format the encoded 
        //message correctly
        System.out.println(helper(newMessage));
    }    
    
    //Helper method to format the message correctly 
    public String helper(String newMessage) {
        //Empty string for correct formatted message
        String endMessage = "";
        //Counter to make sure each line has only 10 blocks of characters
        int counter = 0;
        //Loop to traverse through the newMessage 
        for(int i = 0; i < newMessage.length(); i++) {
            char letter = newMessage.charAt(i);
            //Creates a space after every five characters
            if ((i + 1) % 5 == 0) {
                endMessage += letter + " ";
                counter ++;
            } else { //Continues adding the letter if space is not needed
                endMessage += letter; 
                counter ++;
            }
            //Ignores every space in the new message
            if (letter == (' ')) {
                endMessage += "";
            }
            //Goes to the next line when there are 10 blocks of character
            if(counter == 50) {
                endMessage += "\n";
                counter = 0;
            }
        }
        //Returns the final correctly formatted message
        return endMessage;
    }
    
    //Getter for message
    public String getMessage() {
        return this.message;
    }
    
    //Getter for shift
    public int getShift() {
        return this.shift;
    }
    
    //Setter for message
    public void setMessage(String newMessage) {
        this.message = newMessage;
    }
    
    //Setter for shift
    public void setShift(int newShift) {
        this.shift = newShift;
    }
}