package user.Exception;


//Password-length measuration Exception class
 public class poorPasswordException extends Exception
 {
    private String msg;
 
    public poorPasswordException(String msg)
    {
	  this.msg = msg;
    }
    
    public String toString()
    {
       return "username and password length must be greater or equal than 8";
    }
 }
