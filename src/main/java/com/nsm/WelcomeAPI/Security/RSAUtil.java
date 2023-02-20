package com.nsm.WelcomeAPI.Security;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RSAUtil {

	private static final Log log = LogFactory.getLog(RSAUtil.class);

	/*For ST Server
	 private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDzYbF3MjCxZaBsMWNEfmnSxp2rVAwB/HpaH1/qncAi6JHC73+hrDpHukfTJa8a1pK9C1tKeH1dooM7rlREPJ8Ch+tcyDs86Lwei+LYGy03k6wj36E1f+gJTJrJeDd61HrO6kG8QLsT+wKlFW+GEWxlrDbVe28XqCOHZAaBlYAUtwIDAQAB";
	 private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPNhsXcyMLFloGwxY0R+adLGnatUDAH8elofX+qdwCLokcLvf6GsOke6R9MlrxrWkr0LW0p4fV2igzuuVEQ8nwKH61zIOzzovB6L4tgbLTeTrCPfoTV/6AlMmsl4N3rUes7qQbxAuxP7AqUVb4YRbGWsNtV7bxeoI4dkBoGVgBS3AgMBAAECgYEA57acGiqbt1lVKYy/wMdGAxl7pVFIeV+iMUlrrVhxRAr+M4SHlCn/9qhAl6NqGfguDnPQf49FdC80GE76BVld3FSRukVHG4aKYet7e5afWlsgVNTNNAeEUKO1qVoyv2WGmozKeD0DVbAELI8AOnSdgb/Wr9b6Hn5ckoKocaM9AOECQQD/wYga0DorkM+CaeiqFcEey3z5WwzORZjs9x7D+bqZc2pnVjSLB9/547jbxj6DwFBJy1iOKyPzVoOiWhWtlIJxAkEA850jnfcH6xGQt3da/IIY1KcUkLAEtWQwcTTosfv1ZQ4H4gRNoqwsCP2fDqwI5yLMmx2vqAd/fnMVedpCABNNpwJAY35PS1cL+hy4jRxUVa5m1WsF8B9aiPgMOMsd3dFNpRqAHzkq8Zcbq6PKKz0g3rI2ya5ggdYIg0Z5qPPwkPlAEQJAJn+94jfo63BCM4xMN72DmQ+yg08d32Cu+yUGZSJRXKAEBObzMfMNnnoeSd5MJeLs/NKLMP3GW0Bqs3AXoBVs3wJAWxO2m2Ejl6zZ4oBrmGhCi6UB7YV/2VMFnEUyQ+fm3p5uexM6WqtcogtxFH8ezEiPfxsc+HrgJFqFA8ufTfkDeQ==";
     */

	  /*For Production Server */
	  public static String publicKey= "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm+Kfcnv4NhKWhgkUf938zdQHptyOL2jzxAhArgqxspanktklVoIj4ekPbSzb30Oju0T+WNPD5wtbwzcXMlk2yCdwAftncTzs4aFc2NMaJ9uA8pNe7rsB+kXYOK/b6dAWyYjEDLmxX7mQIMKbkpQqTZce/n4ljWSBhkQtmRiTbOXkgzsAZ1xpPJfIYujhoyBoOk/bu5ehl5H37iJlZbA/Kan5IlP+7V4yI3yf/Oj8NcsCbCS37kqpov0X2tTavVoJdrl77xLm5AW1LzkVPfmHopQ/W65W5EQF4v0pjpmbhZk8KcUPuJ+0mSiN5drMX9wG7jlUaOiFT4v2/4en+FGtNQIDAQAB";
	  public static String privateKey="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCb4p9ye/g2EpaGCRR/3fzN1Aem3I4vaPPECECuCrGylqeS2SVWgiPh6Q9tLNvfQ6O7RP5Y08PnC1vDNxcyWTbIJ3AB+2dxPOzhoVzY0xon24Dyk17uuwH6Rdg4r9vp0BbJiMQMubFfuZAgwpuSlCpNlx7+fiWNZIGGRC2ZGJNs5eSDOwBnXGk8l8hi6OGjIGg6T9u7l6GXkffuImVlsD8pqfkiU/7tXjIjfJ/86Pw1ywJsJLfuSqmi/Rfa1Nq9Wgl2uXvvEubkBbUvORU9+YeilD9brlbkRAXi/SmOmZuFmTwpxQ+4n7SZKI3l2sxf3AbuOVRo6IVPi/b/h6f4Ua01AgMBAAECggEAUzZeNxbGINc7UsF2F+vAD3+ntgL2Q4ia14IwRLegs9yIB3Oy4sMFtIpcmcLgfAX3WPgzbeddI/CEQ2kdENteyumCeQxi46fKK4efsH6/75bU9qiEfJuHKrot+dSmZ+GUyHAhd0mIzbiYn2RC97PwAQsymFduZFPKcInkbV0ZFX+pZJJZKMn+d7KX2JTItXnzJh7Jj5/sal4uGSd5oq2fynr+h+s1fjyjDpC8asJ0wuMpe1wpBMVIFmiGBrZTOLHqlhhlSur+5HduVfLfEWgvQMEmoGROq2N8IC5REbtnmvsawPTtPY+PMAP65IhEtwFlygp3nYetP7Juc6sTERB1AQKBgQDy8k+OnleQzdgHBT3heKd1l/9h7L4N83zhC9a/MMc96IgBu9GhjJmGFmZEaGAAtKlpPyoBPC3YONDxkcy1uItNFw3E6AVgROfczNhdEjhI/SvLdl74Fri+TMCt1cDz6ks89YuRQfKNumvLuukfoFRQz+n7Mw/2GN5JltMZLEqTOQKBgQCkQsxvL7xCjh6JYJ6jmJGWyFoUMT8dqfndSNGSHIEElyrqcQitRqSy/nucpvvX7k+UYtq33BlUHCH9T+hmtYFhDLI/K3aYAx3xG5fFE8ItMateolFPHbrCjgXL+0H11E3HgHKGsx05I1MDFgWR0xi9tB1XoTckNIPGiXokobw93QKBgQC6gs4S9nrRP0ZOtXZ5R5CAFc3I1uBdg4VmnBkkNIVxgLgRZKieNnuSVlXyxJKXWBsLIqPTyOiFK7E1E7Kt+9xttXorpdiivKOoflbItPkjB8H8dIaaPY9dAT2W9xgn6cITLYsVXCSjK/AfuwHH9uVkGQpPgDcLvrHAmxq7I6ao+QKBgQCDjXf7KEjnKLkuHvKOZRdcojL6bwJ0eHhDkBk/opJ1obfeMQ7Y73XiYMuRB281XYfgeFdg3uZuJWXXYRLohz8KAcgTrXR6hCyLuCSR0qQ128y6qtbhvRag0Gu2FRGblx9/wtB2Lqcd5ruKAi4NvvnWnJTPZK8r0N8kt1/aTKndBQKBgBKkX95nS5lEMYfyR8hGKTbJ5dmLLMlJBo6YHmjaeunN5mmRGc/T5Dp7BIBmyW3SVinSIuZgep0efTmW0OWn0Tix3kRAU2o9CSCRqC7dBkvLn657lhvRlRjJ2iKHRiqYi+2wEunOSIS7WGM0/OSR+/MOJJ7TlMmA3yDjqp6APgL9";


    public static PublicKey getPublicKey(String base64PublicKey){
        PublicKey publicKey = null;
        try{
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
        } catch (InvalidKeySpecException e) {
            e.getMessage();
        }
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String base64PrivateKey){
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
        }
        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            e.getMessage();
        }
        return privateKey;
    }

    public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return cipher.doFinal(data.getBytes());
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decrypt(Base64.decodeBase64(data.getBytes()), getPrivateKey(base64PrivateKey));
    }

   public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException {
        try {
        	byte[] encryptedString = Base64.encodeBase64(encrypt("8gi7bPzmKg6Zuei8awPN7clegcys/2ggg+Pxg7a2PNxLfRfkGeu4bglzBuV5ZbT2xps+97AhHXRW0Z189jcillks0hBW1ofZ949LfMUj0BeLOtU350Yaq8R8BMFvDr4dey2+Npjp/KPoaFVRoXR1/VeMmu8L2T776Di4dSenWsU=", publicKey));
        	System.out.println(new String(encryptedString));
          String decryptedString = RSAUtil.decrypt("Q3Z75eeIqbI1Yg8mDTRCkAwh95BjPCf1xBpuoz/IYg3iCUXsU9E4Xub+l5EjPADm79eHzrM4EIR9g/us5JWneX6rP5n3AM3V5uKcu0CiOhNntgKhvPKWyJ6nfDKgpY/Gwk8msUlT432nT60p9x314yw20f2EL/mWXAYRxUDJ3vBUni49nH653JCxxc48eEEuNavn7N/iFPc2NSHL5A8QmrSzXBza6YnRs1UWeKlVz/b3uk6Vp0HhfR3FbYON10xru+gvizdNW9Ix0kOOUzRTEVsiTTqtro5KixpdNvEMlKJKW4CfqykiHrniyckdFMxOlTg2cQHA2TL9m4tcRGwL6Q==", privateKey);
   			log.info(decryptedString);
        } catch (NoSuchAlgorithmException e) {
        }

    }
}