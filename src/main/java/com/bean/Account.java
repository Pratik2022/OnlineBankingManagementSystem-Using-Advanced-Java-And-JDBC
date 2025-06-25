package com.bean;

import java.util.Objects;

public class Account 
{
	private int accNo;
	private float accBal;
	private String accType;

	public Account(){}
	
	public Account(int accNo, float accBal, String accType)
	{
		this.accNo = accNo;
		this.accBal = accBal;
		this.accType = accType;
	}
	
	public void setAccNo(int accNo)
	{
		this.accNo = accNo;
	}
	
	public void setAccType(String accType)
	{
		this.accType = accType;
	}
	
	public void setAccBal(float accBal)
	{
		this.accBal = accBal;
	}
	
	public int getAccNo()
	{
		return this.accNo;
	}
	
	public String getAccType()
	{
		return this.accType;
	}
	
	public float getAccBal()
	{
		return this.accBal;
	}
	
	public void display()
	{
		System.out.println("AccNo = "+accNo);
		System.out.println("AccType = "+accType);
		System.out.println("AccBal = "+accBal);
		System.out.println();
	}
	
	public String toString()
	{
		return "the AccNo = "+accNo+" AccType = "+accType+" accBal = "+accBal;
	}

	public int hashCode()
	{
		return Objects.hash(accBal, accType);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accBal == other.accBal && Objects.equals(accType, other.accType);
	}
}
