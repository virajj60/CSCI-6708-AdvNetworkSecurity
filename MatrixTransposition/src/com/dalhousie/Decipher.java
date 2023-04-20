package com.dalhousie;

public class Decipher {

	public String generateDecipheredText(String cipherText, int[] key) {
		int cols = key.length;
		int rows = (int) Math.ceil(cipherText.length() / (double) cols);
		char[][] decipherTextMatrx = new char[rows][cols];
		StringBuilder plainText = new StringBuilder();

		for (int i = 0, index = 0; i < key.length; i++) {
			for (int j = 0; j < rows; j++) {
				decipherTextMatrx[j][key[i] - 1] = cipherText.charAt(index);
				index++;
			}
		
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if ((decipherTextMatrx[i][j] == '%')) {
					plainText.append(" ");
				}else {
					plainText.append(decipherTextMatrx[i][j]);
				}
			}
		}
		return plainText.toString();
	}
}
