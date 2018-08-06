import java.util.Scanner;

/* The caesar cipher rotates the alphabet n times and swaps out each letter of the original message
using the rotated alphabet

implementation example:
input: abc
(three rotations)
output: xyz */
public class caesar {

	static String option;
	static String message;
	static int rotations;
	static boolean encrypt;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 'E' for encrypt or 'D' for decrypt: ");
		option = input.nextLine();

		if (option.equals("E")){
			encrypt = true;
		} else if (option.equals("D")){
			encrypt = false;
		} else {
			System.out.println("Invalid input. Quitting the program.");
			System.exit(0);
		}

		System.out.println("Enter a message to cipher: ");
		message = input.nextLine();
		System.out.println("How many rotations: ");
		rotations = input.nextInt();
		System.out.println(encryptMessage(message, rotations, encrypt));

	}

	// handles encrypting and decrypting of message
	public static String encryptMessage(String uncipheredMessage, int numRotations, boolean encrypt){

		uncipheredMessage = uncipheredMessage.toLowerCase();
		int characterCount = uncipheredMessage.length();

		String cipheredMessage = "";
		// iterate character-by-character through the unciphered message
		for (int i = 0; i < characterCount; i++){

			char letter = uncipheredMessage.charAt(i);
			char cipherLetter = ' ';

			// rotate alphabet forward (+) for encrypt, backward (-) for decrypt
			// note: instead of using a new method repeating the logic for decrypt, add
			// a boolean (boolean encrypt) where true => encrypt, false => decrypt
			if (encrypt == true){
				cipherLetter = (char) (letter + numRotations);
			} else if (encrypt == false) {
				cipherLetter = (char) (letter - numRotations);
			}

			cipheredMessage = cipheredMessage + cipherLetter;

		}
		return cipheredMessage;
	}

}
