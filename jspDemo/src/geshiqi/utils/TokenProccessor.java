package geshiqi.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenProccessor {
	private TokenProccessor(){
		
	}
	private static final TokenProccessor instance = new TokenProccessor();
	public static TokenProccessor getInstance(){
		return instance;
	}
	public String makeToken(){
		String token = (System.currentTimeMillis()+new Random().nextInt(9999999)+"");
		try{
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
			
			
		}catch (NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}
}
