package com.dalhousie;

public class DecipherText {

	public String removeAddedPadding(String decipheredText) {
		if (decipheredText.charAt(decipheredText.length() - 1) == 'Z') {
			if (decipheredText.charAt(decipheredText.length() - 2) != 'Z'
					&& ((decipheredText.length() - 1)%2 != 0)) {
				decipheredText = decipheredText.substring(0, decipheredText.length() - 1);
			}
		}
		return decipheredText;
	}

	public String removeRepeatDellimiter(String decipheredText) {
		for (int i = 1; i < decipheredText.length() - 1; i++) {
			if ((decipheredText.charAt(i - 1) == decipheredText.charAt(i + 1)) && decipheredText.charAt(i) == 'X') {
				decipheredText = decipheredText.substring(0, i).concat(decipheredText.substring(i + 1));
			}
		}
		return decipheredText;
	}

	public String decipherText(String plainText, char[][] key) {
		KeyMatrix keyMatrx = new KeyMatrix();
		StringBuilder dicipherText = new StringBuilder();
		int row1, col1, row2, col2;
		for (int i = 0, index = 0; i < plainText.length() / 2; i++) {
			row1 = keyMatrx.getRow(key, plainText.charAt(index));
			col1 = keyMatrx.getColumn(key, plainText.charAt(index));

			row2 = keyMatrx.getRow(key, plainText.charAt(index + 1));
			col2 = keyMatrx.getColumn(key, plainText.charAt(index + 1));

			if (row1 == row2) {
				dicipherText.append(key[row1][(col1 + 4) % 5]);
				dicipherText.append(key[row2][(col2 + 4) % 5]);
			} else if (col1 == col2) {
				dicipherText.append(key[(row1 + 4) % 5][col1]);
				dicipherText.append(key[(row2 + 4) % 5][col2]);
			} else {
				dicipherText.append(key[row1][col2]);
				dicipherText.append(key[row2][col1]);
			}
			index += 2;
		}
		return dicipherText.toString();
	}
}
