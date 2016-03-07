package by.krukouski.testscreator.function;

import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Krukouski Andrei on 27.12.2015.
 */
public class CreatePasswordMD5 {

    static Logger logger = Logger.getLogger(CreatePasswordMD5.class);

    public String createPasswordMD5(String password){
        MessageDigest messageDigest = null;                             //password encryption md5
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        }catch (NoSuchAlgorithmException e){
            logger.error(e.getMessage());
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5password = bigInt.toString(16);
        while (md5password.length() < 32){
            md5password = "0" + md5password;
        }

        return md5password;
    }
}
