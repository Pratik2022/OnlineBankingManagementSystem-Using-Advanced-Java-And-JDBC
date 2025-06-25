package user.DaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.DaoServices.DaoInterface;
import user.bean.User;

//User Service Implementation
public class DaoServiceImpl implements DaoInterface
{
  PreparedStatement pst;
  ResultSet rs;
  Connection con;
  DaoInterface dao;
  User user;
  
  public DaoServiceImpl(Connection con)
  {
      this.con = con;
  }

    //For Insert Data
	public void insertRecord(User user)
	{
		int updateCount = 0;
		try
		{
			pst =con.prepareStatement("insert into login values(?,?,?,?)");
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassWord());
			pst.setString(3, user.getSqn());
			pst.setString(4, user.getSqa());
			updateCount = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

    //For Retrieval Of Data
	public User retrieveRecord(String username, String password)
	{
		try
		{
			pst = con.prepareStatement("select * from login where username = ? and password = ?");
			pst.setString(1,username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
			 username = rs.getString("username");
			 password = rs.getString("password");
			 String sqn = rs.getString("sqn");
			 String sqa = rs.getString("sqa");
               
			 user = new User(username,password,sqn,sqa);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}

	//For Retreival of data for using username, sqn and sqa
	public User retrieveRecord(String username, String sqn, String sqa)
	{
	    try
	    {
	        pst = con.prepareStatement("SELECT * FROM login WHERE username = ? AND sqn = ? AND sqa = ?");
	        pst.setString(1, username);
	        pst.setString(2, sqn);
	        pst.setString(3, sqa);
	        rs = pst.executeQuery();
	        
	        if(rs.next())
	        {
	            String password = rs.getString("password"); // Retrieve password from result set
	            user = new User(username, password, sqn, sqa);
	        }
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return user;
	}

	//For Update The Data in database
	public void updateRecord(String newPassword, String username) 
	{
		int updateCount = 0;
		try
		{
	    	pst = con.prepareStatement("update login set password = ? where username = ?;");
	    	pst.setString(1, newPassword);
	    	pst.setString(2, username);
	    	updateCount = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//For Delete The data
	public void deleteRecord(String username, String password)
	{
		int updateCount = 0;
	   try
	   {
		   pst = con.prepareStatement("delete from login where username = ? and password = ?");
		   pst.setString(1, username);
		   pst.setString(2, password);
		   updateCount = pst.executeUpdate();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	}
}

