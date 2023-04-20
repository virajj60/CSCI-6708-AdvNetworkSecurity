package com.dalhousie;

public class Main {

	public static void main(String[] args) {
		FileRead fr = new FileRead();
		KeyMatrix keyMatrx = new KeyMatrix();
		GenerateCipher genCiph = new GenerateCipher();
		DecipherText decipher = new DecipherText();

		String secretKey;
		String plainText;
		String cipherText;
		String decipherText;
		char[][] k = new char[5][5];

		// read the key
		secretKey = fr.readFromFile("key.txt").toUpperCase();
		// Generate key matrix
		k = keyMatrx.generateKeyMatrix(secretKey);

		// read the plaintext
		plainText = fr.readFromFile("plainText.txt").toUpperCase();
		// filter the plaintext for space and punctuation.
		plainText = genCiph.filterSpecialChars(plainText);
		// pad repeating chars with 'X'
		plainText = genCiph.handleRepeatingChars(plainText, 2);
		// pad uneven string with 'Z' at the end
		if (plainText.length() % 2 != 0) {
			plainText = plainText.concat("Z");
		}

		// encrypt the 'plaintext' with key 'k' and generate cipher
		cipherText = genCiph.createCipher(plainText, k);

		System.out.println("Encypted Cipher Text is : ");
		System.out.println(cipherText);

		// decipher the ciphertext into plaintext
		decipherText = decipher.decipherText(cipherText, k);

		// decipher added padding 'Z'
		decipherText = decipher.removeAddedPadding(decipherText);

		// remove 'X' added for repeating characters
		decipherText = decipher.removeRepeatDellimiter(decipherText);

		System.out.println("The decrypted plain text is : ");
		System.out.println(decipherText);
	}
}