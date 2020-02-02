
public class Encrypter
{

	public static String encrypt(String input)
	{
		// Check for valid input.
		if (input.length() != 4)
		{
			System.out.println("Invalid number to decrypt.");
			return "";
		}
		
		// Create variables storing each digit.
		int[] digits = new int[4];
		
		for(int i = 0; i < 4; i++)
		{
			digits[i] = Character.getNumericValue(input.charAt(i));
		}
		
		// Encrypt each digit.
		for (int i = 0; i < 4; i++)
		{
			digits[i] = (digits[i] + 7) % 10;
		}
		
		// Finish the encryption by swapping specific digits.
		int temp;
		for (int i = 0; i < 2; i++)
		{
			temp = digits[i];
			digits[i] = digits[i+2];
			digits[i+2] = temp;
		}
		
		// Return the encrypted four digit number.
		StringBuffer encryptedNum = new StringBuffer();
		for (int i = 0; i < 4; i++)
		{
			encryptedNum.append(digits[i]);
		}
		return encryptedNum.toString();
	}
	
}
