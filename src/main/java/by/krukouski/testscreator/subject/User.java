package by.krukouski.testscreator.subject;

import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Krukouski Andrei on 26.12.2015.
 */
public class User extends Entity {

    static Logger logger = Logger.getLogger(User.class);

    private String lastname;//user lastname
    private String firstname;//user surname
    private String email;//user e-mail
    private String login;//user login
    private String password;//uset password
    private boolean admin;//is admin(true - yes, false - no)


    public User(){

    }
    public User(int id, String lastname, String firstname, String email, String login, String password, boolean admin){
        super(id);
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.admin = admin;
    }
    public User(String lastname, String firstname){
        this.lastname = lastname;
        this.firstname = firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getEmail(){
        return email;
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public boolean getAdmin(){
        return admin;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void  setFirstname(String firstname){
        this.firstname = firstname;
    }
    public void  setEmail(String email){
        this.email = email;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPasswordMD5(String password){//add password (function is used to store passwords
        MessageDigest messageDigest = null;                             //md5 password encryption
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

        this.password = md5password;
    }
    public void setAdmin(boolean admin){
        this.admin = admin;
    }

    public class Statistic {

        private int takeTests;
        private int rightTests;

        public Statistic(){}
        public Statistic(int takeTests, int rightTests){
            this.rightTests = rightTests;
            this.takeTests = takeTests;
        }
        public int getTakeTests(){
            return takeTests;
        }
        public int getRightTests(){
            return rightTests;
        }
        public void setTakeTests(int takeTests){
            this.takeTests = takeTests;
        }
        public void setRightTests(int rightTests){
            this.rightTests = rightTests;
        }
        public void addTakeTests(){
            takeTests++;
        }
        public void addRighTasts(){
            rightTests++;
        }
        @Override
        public String toString(){
            return "Statistic [ takeTests = " + takeTests + ", rightTests = " + rightTests + " ]";
        }

    }

    @Override
    public String toString(){//redirect toString() method
        return "User [ id = " + getId() + ", lastname = " + lastname + ", firstname = " +
                firstname + ", email = " + email + ", login = " + login + ", password = " +
                password + ", admin = " + admin +" ]";
    }
    @Override
    public boolean equals(Object object){//redirect equals() method
        if(this == object){
            return true;
        }
        if(object == null){
            return false;
        }
        if(getClass() != object.getClass()){
            return false;
        }

        User other = (User) object;
        if(!getId().equals(other.getId())){
            return false;
        }
        if(lastname == null){
            if(other.lastname != null){
                return false;
            }
        }else if (!lastname.equals(other.lastname)){
            return false;
        }
        if(firstname == null){
            if(other.firstname != null){
                return false;
            }
        }else if (!firstname.equals(other.firstname)){
            return false;
        }
        if(email == null){
            if(other.email != null){
                return false;
            }
        }else if (!email.equals(other.email)){
            return false;
        }
        if (login == null){
            if(other.login != null){
                return false;
            }
        }else if (login.equals(other.login)){
            return false;
        }
        if(password == null){
            if(other.password != null){
                return false;
            }
        }else if (password.equals(other.password)){
            return false;
        }
        if( admin != other.admin){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){//переопределение метода hashCode()
        return (int)(13 * getId() + ((email == null) ? 0 : email.hashCode()));
    }

}
