package com.nsm.WelcomeAPI.Security;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Aes256Impl {

	private static final Log log = LogFactory.getLog(Aes256Impl.class);
	private Cipher c;
	private IvParameterSpec IV;
	private SecretKey s_KEY;

	// Constructor
	public Aes256Impl() {
		try {
			c = Cipher.getInstance("AES/CBC/PKCS5PADDING");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Aes256Impl(String iv, String hex) {
		try {
			c = Cipher.getInstance("AES/CBC/PKCS5PADDING");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public byte[] encrypt(String strToEncrypt) {
		try {
			byte[] byteToEncrypt = strToEncrypt.getBytes();

			c.init(Cipher.ENCRYPT_MODE, s_KEY, IV);
			byte[] encryptedBytes = c.doFinal(byteToEncrypt);

			return encryptedBytes;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}

	public String decrypt(byte[] byteToDecrypt) {
		try {
			c.init(Cipher.DECRYPT_MODE, s_KEY, IV);

			byte[] plainByte = c.doFinal(byteToDecrypt);

			String plainText = new String(plainByte, "UTF-8");

			return plainText;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public String byteArrayToString(byte[] s) {
		String string = null;
		try {
			string = new String(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.getMessage();
		}
		return string;
	}

	// Get Methods for all class variables
	public Cipher getCipher() {
		return c;
	}

	public IvParameterSpec getIV() {
		return IV;
	}

	public SecretKey getSecretKey() {
		return s_KEY;

	}

	public String toHex(String arg) {
		return String.format("%040x", new BigInteger(1, arg.getBytes()));
	}

	public void setIV(IvParameterSpec iV) {
		IV = iV;
	}
	public void setKey(String key1) {

		try {
			s_KEY = new SecretKeySpec(key1.getBytes(), "AES");

		} catch (Exception e) {
			e.getMessage();
		}
	}


	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		Aes256Impl aes = new Aes256Impl();
		byte[] iv = "6ea7b08b252f4743".getBytes();

		String strIv = new String(iv);

		StringBuffer sb1 = new StringBuffer(strIv);
		sb1 = sb1.append(strIv);
		aes.setKey(sb1.toString());

		//Start: Encryption

		aes.setIV(new IvParameterSpec(iv));

		FileInputStream fi = new FileInputStream("../LAYI/src/TestTemplates/LeadEnquiryRequest.txt");
		StringBuffer sb = new StringBuffer();

		int i;
		while ((i = fi.read()) != -1) {

			sb.append((char) i);
		}

		String str = sb.toString();

		byte[] enc = aes.encrypt(str);
		byte[] encoded = new Base64().encode(enc);
		String encrptString = new String(encoded);
		log.info("Encrypted String :" + encrptString);

  }
}
