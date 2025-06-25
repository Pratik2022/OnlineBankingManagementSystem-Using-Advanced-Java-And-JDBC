package com.serviceImpl;

import java.sql.Connection;
import java.util.Random;

import com.bean.Account;
import com.dao.AccountDaoInterface;
import com.daoimpl.AccountDaoImpl;
import com.services.AccountServices;

//Account Services Implementation
public class AccServiceImpl implements AccountServices
{
   Account a;
   private static int sequence = 100;
   int accNo;
   AccountDaoInterface dao;
   
   public AccServiceImpl(Connection con)
   {
       dao = new AccountDaoImpl(con);
   }
	
   // for Open Account
	public Account openAccount(String accType, float amount) 
	{
	    accNo = sequence++;
        a = new Account(accNo, amount, accType);
        dao.insertRecord(a);
        return a;
	}

	//for Balance Enquiry
	public Account balEnquiry(int accNo, String accType)
	{
		Account a = dao.retriveRecord(accNo);
	
	   if(a!=null&&a.getAccNo()==accNo && a.getAccType().equalsIgnoreCase(accType))
	   {
				return a;
	   }
	   else{
				return null;
	   }
	 }
		
	//for Deposite amount
	public float deposit(int accNo, float amount) {
		
		if(amount<=1000)
		{
			return 0.0f;
		}
		Account a = dao.retriveRecord(accNo);
		System.out.println(a);
		if(a==null)
		{
			return 0.0f;
		}
		else
		{
			if((a.getAccNo()==(accNo)))
			{
				synchronized(this)
				{
					if(a!=null)
					{
						float newBal = a.getAccBal() + amount;
						a.setAccBal(newBal);
						dao.updateRecord(a);
						return newBal;
					}
				}
			}
			else
			{
				return 0.0f;
			}
		}
		return 0.0f;
	}
	
	//For Withdrawl amount
	public float withdraw(int accNo,float amount)
	{
	   Account a = dao.retriveRecord(accNo);
	   
	   if(a==null)
	   {
		   return  -1.0f;
	   }
	   
	   if (a.getAccBal() - amount < 500) {
	        return -2.0f; // Prevent withdrawal if balance goes below ₹500
	    }
	   
	   if(a.getAccBal()<amount)
	   {
		   return -0.0f;
	   }
	   else
	   {
		   float newBal = a.getAccBal()-amount;
		   a.setAccBal(newBal);
		   dao.updateRecord(a);
		   return newBal;		   
	   }
	}
	
	//For withdraw Account
	public float delete(int accNo)
	{
		a = dao.retriveRecord(accNo);
		
		if(a==null)
		{
			return -1.0f;
		}
		else
		{
			a.getAccNo();
			dao.deletedRecord(a.getAccNo());
			return a.getAccBal();
		}
	}
}
