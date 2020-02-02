
public class Decrypter
{
	public static String decrypt(String input)
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
		
		// Begin decrypting by swapping specific digits.
		int temp;
		for (int i = 0; i < 2; i++)
		{
			temp = digits[i];
			digits[i] = digits[i+2];
			digits[i+2] = temp;
		}
		
		// Decrypt each digit.
		for (int i = 0; i < 4; i++)
		{
			if (digits[i] > 6)
			{
				digits[i] -= 7;
			}
			else
			{
				digits[i] = (digits[i] + 10) - 7;
			}
		}
		
		// Return the decrypted four digit number.
		StringBuffer decryptedNum = new StringBuffer();
		for (int i = 0; i < 4; i++)
		{
			decryptedNum.append(digits[i]);
		}
		return decryptedNum.toString();
	}
}
