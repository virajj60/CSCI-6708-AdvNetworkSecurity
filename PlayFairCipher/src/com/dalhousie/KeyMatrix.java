package com.dalhousie;

import java.util.LinkedHashSet;
import java.util.Set;

public class KeyMatrix {

	public char[][] generateKeyMatrix(String key) {
		Set<Character> set = new LinkedHashSet<Character>();
		StringBuilder stringSet = new StringBuilder();
		char[][] keyMatrix = new char[5][5];

		for (int i = 0; i < key.length(); i++) {
			set.add(key.charAt(i));
		}

		for (int i = 0; set.size() < 25; i++) {
			if ((char) (i + 65) == 'J') {
				continue;
			}
			set.add((char) (i + 65));
		}

		for (char itr : set) {
			stringSet.append(itr);
		}

		int index = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				keyMatrix[i][j] = stringSet.charAt(index);
				index++;
			}
		}

		return keyMatrix;
	}

	public int getRow(char[][] matrix, char c) {
		int row = -1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (matrix[i][j] == c) {
					row = i;
					break;
				}
			}
			if (row != -1) {
				break;
			}
		}
		return row;
	}
	
	public int getColumn(char[][] matrix, char c) {
		int col = -1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (matrix[i][j] == c) {
					col = j;
					break;
				}
			}
			if (col != -1) {
				break;
			}
		}
		return col;
	}
}
