package com.nsm.WelcomeAPI.Security;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;


public class RSAKeyPairGenerator {

	//private static final Log log = LogFactory.getLog(RSAKeyPairGenerator.class);
	@SuppressWarnings("unused")
	private Cipher c;
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		KeyPair pair = keyGen.generateKeyPair();
		this.privateKey = pair.getPrivate();
		this.publicKey = pair.getPublic();
	}

	public void writeToFile(String path, byte[] key) throws IOException {
		File f = new File(path);
		f.getParentFile().mkdirs();

		FileOutputStream fos = new FileOutputStream(f);
		fos.write(key);
		fos.flush();
		fos.close();
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
		keyPairGenerator.writeToFile("RSA/publicKey", keyPairGenerator.getPublicKey().getEncoded());
		keyPairGenerator.writeToFile("RSA/privateKey", keyPairGenerator.getPrivateKey().getEncoded());
		System.out.println(Base64.encodeBase64String(keyPairGenerator.getPublicKey().getEncoded()));

		System.out.println(Base64.encodeBase64String(keyPairGenerator.getPrivateKey().getEncoded()));
	}
}