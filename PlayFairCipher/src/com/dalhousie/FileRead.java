package com.dalhousie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
	public String readFromFile(String filePath) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				sb.append(sCurrentLine);
			}
		}catch (IOException e) {
			System.out.println("File Not Found " + e);
		}
		return sb.toString();
	}
}
