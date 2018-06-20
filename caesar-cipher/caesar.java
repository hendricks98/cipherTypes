import java.util.Scanner;

public class caesar {
	
	static final char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static char[] ciphAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};; 
	static char codeKey[];
	static String msgList[];
	static String message;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a message to cipher: ");
		message = input.nextLine();
		System.out.println(encrypt(message));

		/*
		// verify the ciphAlphabet is actually changing - check
		System.out.print("alphabet: ");
		for (int h = 0; h < alphabet.length; h++){
			System.out.print(alphabet[h]);
		}
		System.out.println("");
		System.out.print("codeKey: ");
		for (int i = 0; i < codeKey.length; i++){
			System.out.print(codeKey[i]);
		}
		*/


	}

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

	public static void deSpace(String cryptMsg) {

		Scanner input = new Scanner(cryptMsg);

		msgList = cryptMsg.split(" ");

	}

	public static String encrypt(String message) {
		String encryptMsg = "";
		int indexKey = 0;

		System.out.println("Enter number of rotations: ");
		Scanner keyIn = new Scanner(System.in);

		int rotationCt = keyIn.nextInt();
		ciphAlphabet = rotate(rotationCt);

		deSpace(message);

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