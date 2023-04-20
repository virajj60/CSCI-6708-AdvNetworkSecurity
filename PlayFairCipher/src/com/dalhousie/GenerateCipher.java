package com.dalhousie;

public class GenerateCipher {
	public String filterSpecialChars(String plainText) {
		// remove all non A-Z characters from the plainText
		plainText = plainText.replaceAll("[^A-Z]", "");
		return plainText;
	}

	public String handleRepeatingChars(String plainText, int pairSize) {
		plainText = plainText.replace('J', 'I');
		for (int i = 0, index = 0; i < plainText.length() / 2; i++) {
			if (plainText.charAt(index) == plainText.charAt(index + 1)) {
				plainText = plainText.substring(0, index + 1) + 'X' + plainText.substring(index + 1);
			}
			index += 2;
		}
		return plainText;
	}

	public String createCipher(String plainText, char[][] key) {
		KeyMatrix keyMatrx = new KeyMatrix();
		StringBuilder cipherText = new StringBuilder();
		int row1,col1,row2,col2;
		for (int i = 0, index = 0; i < plainText.length() / 2; i++) {
			row1 = keyMatrx.getRow(key, plainText.charAt(index));
			col1 = keyMatrx.getColumn(key, plainText.charAt(index));
			
			row2 = keyMatrx.getRow(key, plainText.charAt(index+1));
			col2 = keyMatrx.getColumn(key, plainText.charAt(index+1));
			
			if(row1 == row2) {
				cipherText.append(key[row1][(col1+1)%5]);
				cipherText.append(key[row2][(col2+1)%5]);
			}else if(col1 == col2) {
				 cipherText.append(key[(row1+1)%5][col1]);
				 cipherText.append(key[(row2+1)%5][col2]);
			}else {
				cipherText.append(key[row1][col2]);
				cipherText.append(key[row2][col1]);
			}
			index+=2;
		}
		return cipherText.toString();
	}
}
