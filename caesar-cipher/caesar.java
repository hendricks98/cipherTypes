import java.util.Scanner;


/* The caesar cipher rotates the alphabet n times and swaps out each letter of the original message
using the rotated alphabet

implementation example:
input: abc
(three rotations)
output: xyz */
public class caesar {

	static final char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static char[] ciphAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static String msgList[];
	static String message;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a message to cipher: ");
		message = input.nextLine();
		System.out.println(encrypt(message));

	}

	// method - rotate(n rotations)
	// rotate the alphabet by one letter n times and return
	public static char[] rotate(int numRotations) {
		for (int i = 0; i < numRotations; i++){

			// hold the first and last element
			char alphaTemp = ciphAlphabet[25];
			char swap = ciphAlphabet[0];

			// rotate the alphabet by one space
			for (int j = 1; j < ciphAlphabet.length; j++) {

				char save = ciphAlphabet[j];
				ciphAlphabet[j] = swap;
				swap = save;

			}

			// swap the first letter with the original last letter
			// after swapping the rest of the alphabet
			ciphAlphabet[0] = alphaTemp;

		}

		return ciphAlphabet;
	}

	// method - splitMessage
	// return an array of encrypted words from an encrypted message string
	public static void splitMessage(String cryptMsg) {

		Scanner input = new Scanner(cryptMsg);

		msgList = cryptMsg.split(" ");

	}
	// method - encrypt
	// cipher an unciphered message
	public static String encrypt(String message) {
		String encryptMsg = "";
		int indexKey = 0;

		System.out.println("Enter number of rotations: ");
		Scanner keyIn = new Scanner(System.in);

		int rotationCt = keyIn.nextInt();
		ciphAlphabet = rotate(rotationCt);

		splitMessage(message);

		for (int i = 0; i < msgList.length; i++) {

			for (int j = 0; j < msgList[i].length(); j++) {

				char query = msgList[i].charAt(j);

				// search through alphabet for matching letter
				for (int k = 0; k < alphabet.length; k++) {

					if (alphabet[k] == query) {

						indexKey = k;
						encryptMsg = encryptMsg + ciphAlphabet[indexKey];

					}
				}

			}
			encryptMsg = encryptMsg + " ";
		}

		return "Ciphered message: " + encryptMsg;
	}

}
