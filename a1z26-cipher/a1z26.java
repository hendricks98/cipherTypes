import java.util.Scanner;

public class a1z26 {
	/*
	
	Key for the cipher A1Z26

	Each letter of the alphatbet is replaed by a number.

	implementation example:

		input: hello
		output: 8-5-12-12-15

	Key:

		A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
		1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 

	*/

	static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};



	public static void main(String[] args) {
		
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
			String[] message = deSpace(nonCypherMsg);
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

		// trim the message

		String uncipheredMessage;
		String cipheredMessage = "";


		uncipheredMessage = trimMessage(message);
		uncipheredMessage = uncipheredMessage.toLowerCase();
		int characterCount = uncipheredMessage.length();

		//	check each letter against the key and add the matching
		//	letter to the cipheredMessage variable, with "-" in
		//	between each number

		for (int i = 0; i < characterCount; i++){
			
			char letter = uncipheredMessage.charAt(i);

			for (int j = 0; j <= 25; j++){
				if (alphabet[j] == letter){

					cipheredMessage = (cipheredMessage + (j+1));

					// only print the "-" in between the numbers
					if (i < characterCount - 1 && uncipheredMessage.charAt(i+1) != ' ') {

						cipheredMessage = cipheredMessage + "-";
					}

					break;
				}

				// add spaces between words
				if (letter == ' ') {
					cipheredMessage = cipheredMessage + " ";
					break;
				}
			}
		}

		return "Encrypted Message: " + cipheredMessage;

	}

	// method - despace
	// seperate each word, delimited by spaces, into an array
	// containing the full message
	public static String[] deSpace(String cryptMsg) {

		Scanner input = new Scanner(cryptMsg);
		String numbers = "";

		String[] msgNumbers = cryptMsg.split(" ");


		return msgNumbers;
	}

	// method - deCrypt
	// fully decrypt the message using the method "translate"

	public static String decrypt(String[] msgNumbers) {

		String decryptMsg = "";
		String token = "";

		// cycle through each word of the message
		for ( int i = 0; i < msgNumbers.length; i++) {

			// reset token var
			token = "";

			// scan in each number, delimited by hypens
			Scanner input = new Scanner(msgNumbers[i]);
			input.useDelimiter("-");

			// add spaces between the words
			if ( i >= 1 ) {
				decryptMsg = decryptMsg + " ";
			}

			// scan in each word
			while ( input.hasNext() ){
			
				token = "";
				token = input.next();

				decryptMsg = decryptMsg + translate(token);

			}

		}

		return "Decrypted Message: " + decryptMsg;
	}

	// method - translate
	// swap each number with its representing letter
	public static String translate(String msg) {

		String msgHandle = "";
		
		int currentCharacter = Integer.parseInt(msg);
		msgHandle = msgHandle + alphabet[currentCharacter-1];	

		return msgHandle;
	}
}
