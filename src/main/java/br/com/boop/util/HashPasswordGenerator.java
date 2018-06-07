package br.com.boop.util;

import java.security.MessageDigest;

public class HashPasswordGenerator {

	public static String getHashSha256(String text) {
		MessageDigest algorithm;
		byte messageDigest[] = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
			messageDigest = algorithm.digest(text.getBytes("UTF-8"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		StringBuilder hexaString = new StringBuilder();
		for (byte b : messageDigest) {
			hexaString.append(String.format("%02X", 0xFF & b));
		}
		String hexaText = hexaString.toString();
		System.out.println(hexaText);
		return hexaText;
	}

}
