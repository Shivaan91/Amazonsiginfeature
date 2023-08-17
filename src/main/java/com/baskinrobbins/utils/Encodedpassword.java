package com.baskinrobbins.utils;

import org.codehaus.plexus.util.Base64;

public class Encodedpassword {
	
	public static void main(String[] args) {
		
		String str  = "Tillster@123";
		
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		System.out.println("encodedString:" + new String(encodedString));
		
		byte[] decodedString = Base64.decodeBase64(encodedString);
		System.out.println("decodedString:" + new String(decodedString));
		
	}

}
