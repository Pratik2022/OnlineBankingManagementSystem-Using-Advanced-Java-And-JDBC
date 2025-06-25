package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Account;
import com.dao.AccountDaoInterface;

//CRUD operations implementation
public class AccountDaoImpl implements AccountDaoInterface
{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	Account a;
	
	public AccountDaoImpl(Connection con) {
        this.con = con;
    }
	
	//Insert data 
	public int insertRecord(Account a)
	{
		int updateCount = 0;
		try
		{
			pst = con.prepareStatement("insert into account values(?,?,?)");
			pst.setInt(1, a.getAccNo());
			pst.setFloat(2,a.getAccBal());
			pst.setString(3,a.getAccType());
			updateCount = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return updateCount;
	}

	//Retrieval of data
	public Account retriveRecord(int accNo)
	{
		try
		{
			pst = con.prepareStatement("select * from account where accNo = ?");
			pst.setInt(1, accNo);
			rs = pst.executeQuery();
			
			if (rs.next()) {
	            accNo = rs.getInt("accNo");
	            float accBal = rs.getFloat("accBal");
	            String accType = rs.getString("accType");

	            a = new Account(accNo, accBal, accType);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
  
	//for update the Record
	public void updateRecord(Account a)
	{
		int updateCount = 0;
		
		try
		{
			pst = con.prepareStatement("update account set accBal = ? where accNo = ?");
			pst.setFloat(1, a.getAccBal());
			pst.setInt(2, a.getAccNo());
			updateCount = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//for Deleted the Record
	public void deletedRecord(int accNo)
	{
		int updateCount = 0;
		try
		{
			pst = con.prepareStatement("delete from account where accNo = ?");
			pst.setInt(1, accNo);
			updateCount = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
