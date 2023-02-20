/*
package com.nsm.WelcomeAPI.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JsonWebToken {
	private static final Log log = LogFactory.getLog(JsonWebToken.class);

	public Claims parseJWT(String jwt) {

	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("92C336F2209922C378F3D46A5121A2E81068A123413A579711DA8A32474558B7")).parseClaimsJws(jwt).getBody();
	    System.out.println("ID: " + claims.getId());
	    System.out.println("Subject: " + claims.getSubject());
	    System.out.println("Issuer: " + claims.getIssuer());
	    System.out.println("Expiration: " + claims.getExpiration());
	    System.out.println("Issued At: " + claims.getIssuedAt());

		return claims;

	}

	public String  createJWT(String id, String issuer, String subject, long ttlMillis) throws Exception
	{
		try {
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

			long curMillis = System.currentTimeMillis();
			Date now = new Date(curMillis);
			byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("92C336F2209922C378F3D46A5121A2E81068A123413A579711DA8A32474558B7");
			Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

			JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer).signWith(signatureAlgorithm, signingKey);

			if(ttlMillis>0)
			{
				long expMillis = curMillis+ttlMillis;
				Date date = new Date(expMillis);
				builder.setExpiration(date);
			}
			return builder.compact();
		} catch (Exception e) {
		log.info("---------------------> Exception in Creating JWT Token :"+e.getMessage());
		}
		return null;
	}


	public static void main(String[] args) throws Exception
	{
		//To  generated  token
		JsonWebToken obj = new JsonWebToken();
		String jwtToken = obj.createJWT("OLT", "llmsClpClient", "jwt_token_for_verification", 3600000);
		System.out.println(jwtToken);
		obj.parseJWT(jwtToken);

		//to verify generated  token
		*/
/*String token =  "EiRdZoiDzVnJz2UUgreeqD6aBOGkSuaI7XUmT7AkVP6dYkfC3CoGP4qtCHGHvslY9Amq3OPuUNP6o2jiukiTobOp4KERiN++zlXfiAhiL/NbIea65WSUhwLy1fM1W9h/IoQqv5sa8HR3q8xt/gNism4Igt2045bf+Zk+UuxKrAGX+HInNTqEuXHIE7cL2SwnpwYWk9EEnwXlmp1LcGLY+n/HrDYk7NmcOpPXjyqPaSZA2YErVAFwJpRydyIqAJ4C";
		String decToken=AES256.decText(token);
		JsonWebToken  jwt= new JsonWebToken();
		Claims claims = jwt.parseJWT(decToken);*//*


	}
}
*/
