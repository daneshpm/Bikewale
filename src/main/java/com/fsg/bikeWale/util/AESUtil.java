package com.fsg.bikeWale.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

	private static final String ALGORITHM = "AES";
	private static final String SECRET_KEY = "BikeWaleSecret!";
	// MUST be 16 chars for AES-128

	private AESUtil() {
	}

	public static String encrypt(String plainText) {
		try {
			SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);

			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
			return Base64.getEncoder().encodeToString(encryptedBytes);

		} catch (Exception e) {
			throw new RuntimeException("Error encrypting password", e);
		}
	}

	public static String decrypt(String encryptedText) {
		try {
			SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);

			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);

			byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);

			byte[] decryptedBytes = cipher.doFinal(decodedBytes);
			return new String(decryptedBytes);

		} catch (Exception e) {
			throw new RuntimeException("Error decrypting password", e);
		}
	}
}
