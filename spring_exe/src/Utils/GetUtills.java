package Utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class GetUtills {
	public static String getMD5Value(String pass){
		System.out.println(pass+"getMd5");
		try{
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] md5valueByteArray = messageDigest.digest(pass.getBytes());
			BigInteger bigInteger = new BigInteger(1,md5valueByteArray);
			return bigInteger.toString(16);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
