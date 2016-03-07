package by.bsu.krukouski.testscreator.function;

import by.bsu.krukouski.testscreator.exception.ResourceException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class CreatePasswordMD5 {
    public String createPasswordMD5(String password){
        MessageDigest messageDigest = null;                             //для шифрования пороля md5
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        }catch (NoSuchAlgorithmException e){
            new ResourceException(e);
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5password = bigInt.toString(16);
        while (md5password.length() < 32){
            md5password = "0" + md5password;
        }

        return md5password;
    }
}
