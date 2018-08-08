import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

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

	public static void main(String[] args) {

		JFrame frame = new JFrame();

		JLabel desc = new JLabel("Enter number of rotations and message to encrypt/decrypt, then push corresponding button:");
		desc.setBounds(30,25,600,80);

		JLabel rotLabel = new JLabel("Rotations:");
		rotLabel.setBounds(30,55,100,80);

		JTextField rotField = new JTextField();
		rotField.setBounds(100,85,30,20);

		JLabel msgLabel = new JLabel("Message:");
		msgLabel.setBounds(135,55,100,80);

		JTextField msgField = new JTextField();
		msgField.setBounds(195,85,430,20);

		JTextField finalMessage = new JTextField();
		finalMessage.setBounds(25,145,650,20);

		// add action listener for each button to initiate cipher/decipher process
		JButton encryptBT = new JButton("Encrypt");
		encryptBT.setBounds(25,110,80,30);
		encryptBT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rotations = ( Integer.parseInt(rotField.getText()));
				message = msgField.getText();
				finalMessage.setText(encryptMessage(message,rotations, true));
			}
		});

		JButton decryptBT = new JButton("Decrypt");
		decryptBT.setBounds(100,110,80,30);
		decryptBT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rotations = ( Integer.parseInt(rotField.getText()));
				message = msgField.getText();
				finalMessage.setText(encryptMessage(message,rotations, false));
			}
		});

		frame.add(desc);
		frame.add(rotLabel);
		frame.add(rotField);
		frame.add(msgLabel);
		frame.add(msgField);
		frame.add(encryptBT);
		frame.add(decryptBT);
		frame.add(finalMessage);

		frame.setSize(700,250);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

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

			// if char is a space, add a space without rotation
			if (letter == ' '){
				cipheredMessage = cipheredMessage + " ";
				continue;
			}

			// rotate alphabet forward (+) for encrypt, backward (-) for decrypt
			// note: instead of using a new method repeating the logic for decrypt, add
			// a boolean (boolean encrypt) where true => encrypt, false => decrypt
			if (encrypt == true){
				cipherLetter = (char) (letter + numRotations);

				// ascii letter codes are only codes 97-122
				if (cipherLetter > 122){
					char swap = (char) (cipherLetter - 122);
					System.out.println("Cipher letter: " + cipherLetter);
					System.out.println("Swap: " + swap);
					cipherLetter = (char) (96 + swap);
				}
			} else if (encrypt == false) {
				cipherLetter = (char) (letter - numRotations);

				// ascii letter codes are only codes 97-122
				if (cipherLetter < 97){
					char swap = (char) (97 - cipherLetter);
					System.out.println("Cipher letter: " + cipherLetter);
					System.out.println("Swap: " + swap);
					cipherLetter = (char) (123 - swap);
				}
			}

			cipheredMessage = cipheredMessage + cipherLetter;

		}
		return cipheredMessage;
	}

}
