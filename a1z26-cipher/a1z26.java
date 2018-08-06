import java.util.Scanner;
import java.util.Hashtable;

public class a1z26 {
	/* Key for the cipher A1Z26

	Each letter of the alphabet is replaced by a number.
	implementation example:
		input: hello
		output: 8-5-12-12-15
	Key:
		A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
		1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 */
	static Hashtable<Character, Integer> encryptTable = new Hashtable<>();
	static Hashtable<Integer, Character> decryptTable = new Hashtable<>();

	public static void main(String[] args) {

		// add keys and values to hashtables
		int value = 1;
		for (char i = 'a'; i <= 'z'; i++){
			encryptTable.put(i,value);
			decryptTable.put(value, i);
			value++;
		}

		// scanner obtain user input
		Scanner keyIn = new Scanner(System.in);

		// encrypt or decrypt
		System.out.println("Enter 'E' for encrypt and 'D' for decrypt: ");
		String option = keyIn.nextLine();

		if (option.equals("E")) {

			System.out.println("Enter a message to encrypt: ");

			// receive user message and encrypt, returning code
			String nonCypherMsg = keyIn.nextLine();
			System.out.println(encrypt(nonCypherMsg));

		} else if (option.equals("D")){

			System.out.println("Enter a message to decrypt: ");

			// receive user code format and decrypt, return original message
			String nonCypherMsg = keyIn.nextLine();
			String[] message = splitMessage(nonCypherMsg);

			String cryptMessage = decrypt(message);
			System.out.println(cryptMessage);

		} else {

			System.out.println("Invalid input. Quitting program.");
		}

	}

	// method - trimMessage
	// clear the message of any punctuation
	public static String trimMessage(String message) {

		String newMessage = message;

		// remove .
		newMessage = newMessage.replace(".","");

		// remove ?
		newMessage = newMessage.replace("?","");

		// remove !
		newMessage = newMessage.replace("!","");

		// add more keyboard inputs later

		return newMessage;
	}

	// method - encrypt
	// cipher an unciphered message
	public static String encrypt(String message) {

		String uncipheredMessage;
		String cipheredMessage = "";

		uncipheredMessage = trimMessage(message);
		uncipheredMessage = uncipheredMessage.toLowerCase();
		int characterCount = uncipheredMessage.length();

		//	encrypt one letter at a time, creating a hyphen delimited string
		for (int i = 0; i < characterCount; i++){

			char letter = uncipheredMessage.charAt(i);
			System.out.println("THE LETTER IM LOOKING FOR: " + letter);

			// if the next char is a letter, add the corresponding number to the cipheredMessage
			if (letter == ' '){
				cipheredMessage = cipheredMessage + " ";
			}else {
				// add a "-" between each letter, except when adding the first letter or a letter after a space
				if (i > 0 && (uncipheredMessage.charAt(i-1)) != ' '){
					cipheredMessage = cipheredMessage + "-";
				}
				cipheredMessage = cipheredMessage + Integer.toString(encryptTable.get(letter));
			}

		}
		return "Encrypted Message:" + cipheredMessage;
	}

	// method - splitMessage
	// return an array of encrypted words from an encrypted message string
	public static String[] splitMessage(String cryptMsg) {

		String[] encryptedWords = cryptMsg.split(" ");

		return encryptedWords;
	}

	// method - decrypt
	// return a decrypted message from an array of encrypted words
	public static String decrypt(String[] encryptedWords) {

		String decryptMsg = "";
		String token = "";

		// cycle through each word of the message
		for ( int i = 0; i < encryptedWords.length; i++) {

			// scan in each number, delimited by hypens
			Scanner input = new Scanner(encryptedWords[i]);
			input.useDelimiter("-");

			// add spaces between the words
			if ( i >= 1 ) {
				decryptMsg = decryptMsg + " ";
			}

			// scan in each word
			while ( input.hasNext() ){

				token = input.next();
				System.out.println("token = " + token);
				decryptMsg = decryptMsg + decryptLetter(token);

			}
		}

		return "Decrypted Message: " + decryptMsg;
	}

	// method - decryptLetter
	// swap each number with its representing letter
	public static String decryptLetter(String letter) {

		String decryptedLetter = "";

		int i = Integer.parseInt(letter);
		decryptedLetter = decryptedLetter + decryptTable.get(i);

		return decryptedLetter;
	}
}
