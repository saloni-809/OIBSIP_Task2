import java.util.*;

class Account
{
	String name;
	String username;
	String pass;
	float balance=70000;
	int transaction=0;
	String trans="";
	Scanner sc=new Scanner(System.in);
	
	public void register()
	{
	
	System.out.println("Enter your name:");
	name=sc.nextLine();
	System.out.println("Enter username");
	username=sc.next();
	System.out.println("Enter password");
	pass=sc.next();
	}
	
	public void login()
	{
		System.out.println("Enter username:");
		String u_name=sc.next();
		System.out.println("Enter password");
		String pwd=sc.next();
		if(u_name.equals(username) && pwd.equals(pass))
		{
			System.out.println("Login Successful......");
		}
		else if((u_name!=username) || (pwd!=pass))
		{
			System.out.println("Incorrect username and password");
		}
		else
		{
			System.out.println("please enter valid username or password");
		}
	}
	
	
	public void withdraw()
	{
		System.out.println("Enter the amount to withdraw:");
		float amt=sc.nextFloat();
		try
		{
		if(balance>amt)
		{
			balance=balance-amt;
			transaction++;
			System.out.println("Withdraw is successful......");
			String str=" "+amt+"Rs has been withdraw from your Account.";
			trans=trans.concat(str);
		}
		else
		{
			System.out.println("Insufficient balance");
		}
		}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	
	public void deposit()
	{
		System.out.println("Enter the amount to deposit:");
		float amt=sc.nextFloat();
		try
		{
			if(amt<=balance)
			{
				balance=balance+amt;
				transaction++;
				System.out.println("Deposited Successfully...");
				String str1=" "+amt+"Rs deposied in your Account.";
			    trans=trans.concat(str1);
				
			}
			else
			{
				System.out.println("Sorry the amount cannot be deposited.......limit is upto 70000");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void transfer()
	{
		System.out.println("Enter the Recepient name ");//the one to whom you want to transfer money
		String rec=sc.next();
		System.out.println("Enter the amount to transfer");
		float amt=sc.nextFloat();
		try
		{
		if(amt<=(balance/2))
		{
			balance=balance-amt;
			transaction++;
			System.out.println("Amount transferred successfully");
			String str3=" "+amt+"Rs transferred from your Account";
			trans=trans.concat(str3);
			
		}
		else
		{
			System.out.println("Cannot Transfer....");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void checkbalance()
	{
		System.out.println("Balance in your Account is:"+balance);
	}
	
	public void transhistory()
	{
		if(transaction==0)
		{
			System.out.println("No any transactions performed");
		}
		else
		{
			System.out.println("*******TRANSACTIONS******");
			System.out.println("\n"+trans+"\n");
			System.out.println("*************************");
		}
	}
			
}
class AtmInterface
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("*******WELCOME TO ATM SYSTEM******");
		System.out.println("1.Register\n2.Exit");
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		Account a=new Account();
		if(ch==1)
		{
			a.register();
			while(true)
			{
				System.out.println("1.Login\n2.Exit");
				System.out.println("Enter your choice");
				int ch1=sc.nextInt();
				if(ch1==1)
				{
					a.login();
					System.out.println("Welcome back"+a.name);
					
					while(true)
					{
					System.out.println("\n 1.WITHDRAW\n 2.DEPOSIT\n 3.TRANSFER\n 4.CHECK_BALANCE\n 5.TRANSCTION_HISTORY");
					System.out.println("Enter your choice:");
					int ch2=sc.nextInt();
					switch(ch2)
					{
						case 1:a.withdraw();
							   break;
					    case 2:a.deposit();
							   break;
					    case 3:a.transfer();
							   break;
					    case 4:a.checkbalance();
							   break;
					    case 5:a.transhistory();
							   break;
					    
						default:System.exit(0);
						
						
					}
					}
				}
				else
				{
					System.exit(0);
					
				}
			}
			
		}
		else
		{
			System.exit(0);
		}
		
	}
}