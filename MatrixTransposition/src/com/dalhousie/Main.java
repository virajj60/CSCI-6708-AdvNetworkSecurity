package com.dalhousie;

public class Main {

	public static void main(String[] args) {
		FileRead fr = new FileRead();
		Cipher cipher = new Cipher();
		Decipher decipher = new Decipher();

		String plainText;
		String cipherText;

		String[] sCurrentLine = fr.readFromFile("key.txt").split(" ");
		int[] key = new int[sCurrentLine.length];
		for (int i = 0; i < sCurrentLine.length; i++) {
			key[i] = (Integer.parseInt(sCurrentLine[i]));
		}
		
		plainText = fr.readFromFile("plainText.txt");
		cipherText = cipher.generateCipherText(plainText, key);
		System.out.println("Ciphered text is " + "\n" + cipherText);

		plainText = decipher.generateDecipheredText(cipherText, key);
		System.out.println("Deciphered text is " + "\n" + plainText);
	}
}