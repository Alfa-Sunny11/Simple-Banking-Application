import java.util.Scanner;
 

public class Bank {
    public static void main(String[] args)throws Exception{
		int x;
		while(true){
		String n;
		String m;
		double ad,cd,sd,aw,cw,sw;
		int aid,cid,sid;
                String Ac_type;
		
		Scanner input=new Scanner(System.in);
		Scanner input1=new Scanner(System.in);
		
		
		System.out.println("Enter Account : \n 1.Debit Account \n 2.Credit Account \n 3.Savings Account \n 4.Exit");
		x = input.nextInt();
		
		
		switch(x){
			case 1:{
                             Ac_type = "Debit Account";
				input.nextLine();
				System.out.println("Enter Name :");
				n=input.nextLine();
				
		        System.out.println("Enter Nominee Name :");
		        m=input1.nextLine();
				System.out.println("Enter Debit Account Id :");
		        aid=input.nextInt();
				System.out.println("Enter Debit Account deposit :");
		        ad=input.nextDouble();
		        System.out.println("Enter Debit Account Withdraw :");
		        aw=input.nextDouble();
                        System.out.println(Ac_type);
				 Account account= new DebitAccount(n,aid, new Date(18,05,1998),m, 0,Ac_type);
                 account.printAccount();
                 account.deposit(ad);
                 account.printAccount();
                 account.withdraw(aw);
                 account.printAccount();
                 account.confirmChanges();
				 break;
		
			}
			case 2:
			{
                            Ac_type = "Credit Account";
				input.nextLine();
				System.out.println("Enter Name :");
		n=input.nextLine();
		System.out.println("Enter Nominee Name :");
		m=input1.nextLine();
				System.out.println("Enter Credit Account Id :");
		        cid=input.nextInt();
				System.out.println("Enter Credit Account deposit :");
	         	cd=input.nextDouble();
	        	System.out.println("Enter Credit Account Withdraw :");
		        cw=input.nextDouble();
                        System.out.println(Ac_type);
				Account creditAccount= new Credit(n,cid, new Date(18,05,1998),m, 0,Ac_type);
                creditAccount.printAccount();
                creditAccount.deposit(cd);
                creditAccount.printAccount();
                creditAccount.withdraw(cw);
                creditAccount.printAccount();
                creditAccount.confirmChanges();
				
				break;
			}
			case 3:
			{
                            Ac_type = "Savings Account";
				input.nextLine();
				System.out.println("Enter Name :");
		n=input.nextLine();
		System.out.println("Enter Nominee Name :");
		m=input1.nextLine();
				System.out.println("Enter Savings Account Id :");
	          	sid=input.nextInt();
		        System.out.println("Enter Savings Account deposit :");
		        sd=input.nextDouble();
		        System.out.println("Enter Savings Account Withdraw:");
		        sw=input.nextDouble();
                        System.out.println(Ac_type);
				Account savingsAccount= new Savings(n,sid, new Date(18,05,1998),m, 0,Ac_type);
                savingsAccount.printAccount();
                savingsAccount.deposit(sd);
                savingsAccount.printAccount();
                savingsAccount.withdraw(sw);
                savingsAccount.printAccount();
                savingsAccount.confirmChanges();
				break;
			}
			case 4:
			{
				System.exit(0);
				break;
			}
			default:
				System.out.println("No Match");
		}


       Account old= new OldAccount("1998-05-18");
        old.printAccount();
        old.deposit(500);
        old.printAccount();
        old.confirmChanges();


    }
	}
}
