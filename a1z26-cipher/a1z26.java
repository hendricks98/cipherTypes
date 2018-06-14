import java.util.Scanner;

public class a1z26 {
	/*
	
	Key for the cipher A1Z26

	Each letter of the alphatbet is replaed by a number.
	

	example:

		input: hello
		output: 8-5-12-12-15

	Key:

		A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
		1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 

	*/

	static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};



	public static void main(String[] args) {

		Scanner keyIn = new Scanner(System.in);
	
		System.out.println("Enter a message to encrypt, letters only: ");
		String nonCypherMsg = keyIn.nextLine();


		System.out.println(encrypt(nonCypherMsg));
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
	// cipher the message

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

		return cipheredMessage;

	}
}
