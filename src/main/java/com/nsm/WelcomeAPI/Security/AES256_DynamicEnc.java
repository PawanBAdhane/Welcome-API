/*
package com.nsm.WelcomeAPI.Security;

import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.codec.binary.Base64;

*/
/**
 *
 * AES static function for different key and iv
 *
 * mode: AES/CBC/PKCS5Padding
 *
 * text input encoding: utf-8
 *
 * text output encoding: base64
 *
 *
 *
 *//*


public class AES256_DynamicEnc {

	private static final Log LOG = LogFactory.getLog(AES256_DynamicEnc.class);
	private static final SecureRandom RANDOM = new SecureRandom();

	private static byte[] getNextSalt() {
		// TODO Auto-generated method stub
		byte[] salt = new byte[16];
		RANDOM.nextBytes(salt);
		return salt;
	}

	private static byte[] getNextIV() {
		// TODO Auto-generated method stub
		byte[] iv = new byte[16];
		SecureRandom srandom = new SecureRandom();
		srandom.nextBytes(iv);
		return iv;
	}

	public static ArrayList<String> AES256Encrypt(ArrayList<String> messages) {
		String passphrase = "y0vGkORhnGF1xdsCtrr8";
		byte[] salt = getNextSalt();
		byte[] iv = null;
		int n = 0;
		int i = 0;
		String strSalt = null;
		String IVVV = null;
		String encryptedStr = null;
		String pvid = null;
		String pvbn = null;
		ArrayList<String> concat = new ArrayList<String>();

		try {

			for (i = 0; i < 1; i++) {
				salt = getNextSalt();
				strSalt = Base64.encode(salt);
				LOG.info("Salt: " + strSalt);

				iv = getNextIV();
				IVVV = Base64.encode(iv);
				LOG.info("IV: " + IVVV);

			}
			for (String c : messages) {
				SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
				KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt, 10000, 128);
				SecretKey tmp = factory.generateSecret(spec);
				SecretKeySpec sKey = new SecretKeySpec(tmp.getEncoded(), "AES");

				IvParameterSpec ivspec = new IvParameterSpec(iv);
				Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
				ci.init(Cipher.ENCRYPT_MODE, sKey, ivspec);

				LOG.info("msg: " + messages.get(n));
				byte[] str = ci.doFinal((messages.get(n)).getBytes("UTF-8"));
				encryptedStr = Base64.encode(str);
				if (n == 0) {
					String EncPvIDString = strSalt + "::" + IVVV + "::" + encryptedStr;
					pvid = Base64.encode(EncPvIDString.getBytes());
				} else {
					pvbn = encryptedStr;
				}
				LOG.info("msg after encryption: " + encryptedStr);
				n++;
			}

			// ULR encoder for encode a String And pass it to the url for string
			// compatibility
			String urlpvinid = URLEncoder.encode(pvid, "UTF-8");
			System.out.println("urlpvinid: " + urlpvinid);
			String urlpvinbn = URLEncoder.encode(pvbn, "UTF-8");
			System.out.println("urlpvinbn: " + urlpvinbn);
			concat.add(urlpvinid);
			concat.add(urlpvinbn);

		} catch (Exception e) {
			LOG.error("Error in AES256_DynamicEnc - AES256Encrypt() : " + e);
		}
		return concat;
	}

}
*/
