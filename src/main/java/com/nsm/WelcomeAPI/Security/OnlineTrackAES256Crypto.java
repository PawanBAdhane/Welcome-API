package com.nsm.WelcomeAPI.Security;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;

public final class OnlineTrackAES256Crypto {
	static final String IV = "1234567891234567";

	static final byte[] key = DatatypeConverter
			.parseHexBinary("92C336F2209922D478F3D46A54E1A2E81068AFCFE13A579711DA8A32474558B7");

	static final String fail = "Fail";

	public static final String encrypt(String plaintext) {
		try {

			IvParameterSpec ivparam = new IvParameterSpec(IV.getBytes("UTF-8"));
			SecretKeySpec skeyspec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec, ivparam);
			byte[] encrypted = cipher.doFinal(plaintext.getBytes("UTF-8"));

			return Base64.encodeBase64String(encrypted);
		} catch (Exception e) {
			return fail;
		}
	}

	public static final String decrypt(String ciphertext) {
		try {

			IvParameterSpec ivparam = new IvParameterSpec(IV.getBytes("UTF-8"));
			SecretKeySpec skeyspec = new SecretKeySpec(key, "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			cipher.init(Cipher.DECRYPT_MODE, skeyspec, ivparam);

			byte[] decrypted = cipher.doFinal(Base64.decodeBase64(ciphertext));
			return new String(decrypted);
		} catch (Exception e) {
			e.printStackTrace();
			// e.getMessage();
			return fail;

		}

	}

	public static void main(String[] args) throws IOException {
		OnlineTrackAES256Crypto oo = new OnlineTrackAES256Crypto();
		/*FileInputStream fi = new FileInputStream("D://Softwares//eclipse_neon//SME_Pawan_Workspace//OnlineTrackingAPI//src//TestTemplates//TokenRequest.txt");
		StringBuffer sb = new StringBuffer();

		int i;
		while ((i = fi.read()) != -1) {

			sb.append((char) i);
		}

		String str = sb.toString();
		System.out.println(str);
		String encfile = oo.encrypt(str.toString());
		System.out.println(encfile);

		String decrtptfile = oo.decrypt(encfile);
		System.out.println(decrtptfile);


*/
		String str=oo.encrypt("Pawan.adhane@gmail.com");
		System.out.println(str);

		}
}