import java.util.Scanner;
/*
 *  The program should have the following capabilities:
 *  	Read a four digit number entered by the user.
 *  	Encrypt the number as follows:
 *  		Replace each digit with the result of adding seven
 *  		to the digit and getting the remainder of the new
 *  		number after dividing by 10.
 *  	Print out the encrypted integer.
 *  	Allow the user to enter a encrypted four-digit number.
 *  	Decrypt the number by reversing the encryption scheme.
 */

public class Application
{
	// Read four digit number from user
	// Encrypt number
	// Print out encrypted number
	// Decrypt number
	public static void main(String[] args)
	{
		// Read four digit number from user
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number to be encrypted: ");
		String numInput = input.next();
		
		// Encrypt number and print out the result
		String encryptedNum = Encrypter.encrypt(numInput);
		System.out.printf("The Encrypted number is %s.\n", encryptedNum);
		
		// Decrypt number and print out the result
		String decryptedNum = Decrypter.decrypt(encryptedNum);
		System.out.printf("The Decrypted number is %s\n.", decryptedNum);
		
		input.close();
	}

}
