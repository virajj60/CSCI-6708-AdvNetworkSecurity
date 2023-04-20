package com.dalhousie;

public class Cipher {
	public String generateCipherText(String plainText, int[] key) {
		int cols = key.length;
		int rows = (int) Math.ceil(plainText.length() / (double) cols);
		plainText = plainText.replace(' ', '%');
		char[][] plainTextMatrx = new char[rows][cols];
		StringBuilder cipherText = new StringBuilder();

		for (int i = 0, index = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (index < plainText.length()) {
					plainTextMatrx[i][j] = plainText.charAt(index);
				} else {
					plainTextMatrx[i][j] = '%';
				}
				index++;
			}
		}

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < rows; j++) {
				cipherText.append(plainTextMatrx[j][key[i]-1]);
			}
		}

		return cipherText.toString();
	}
}
