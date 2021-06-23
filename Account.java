import java.io.FileReader;
import java.io.FileWriter;


public abstract class Account {
    protected String name;
    protected String  ID;
    protected Date DOB;
    protected String nominee;
    protected double balance;
    protected String Ac_type;

    public Account(){

    }

    public Account(String ID)throws Exception{

        balanceValidity(name, DOB, nominee,balance);
        this.ID = ID;
        this.Ac_type= Ac_type;

    }
    public Account(String name, int ID, Date DOB, String nominee, double balance,String Ac_type) throws Exception {

        balanceValidity(name, DOB, nominee,balance);
        this.name = name;
        this.ID = IDGenarator.genarate(ID,DOB);
        this.DOB = DOB;
        this.nominee = nominee;
        this.balance = balance;
        this.Ac_type= Ac_type;

        checkID(this.ID);

    }


    private void checkID(String id) throws Exception{
        int ch=0;

        String pre="";

        FileReader fr=null;
        try
        {
            fr = new FileReader("AccountInfo.txt");
            while ((ch=fr.read())!=-1) pre = pre + (char)ch;
            fr.close();
        }
        catch (Exception fe)
        {
            return;
        }

        int j=0;


        while(j<pre.length()){

            ch= pre.charAt(j);

            if(ch==10){
                try{

                    String ids = pre.substring(j+1,j+14);

                    if(id.equals(ids)){
                        throw new IllegalArgumentException("ID Already Exist");
                    }


                }catch (StringIndexOutOfBoundsException e){
                }
            }
            j++;
        }

        return;
    }

    public abstract boolean deposit(double amount);
    public abstract boolean withdraw(double amount);
    public abstract void balanceValidity(String name, Date DOB, String nominee, double balance);

    public void printAccount() throws Exception{
        System.out.println("Account Type:"+Ac_type);
        System.out.println("Name: "+ name );
        System.out.println("ID: "+ ID);
		try{
			
        System.out.println("DOB: "+DOB.day+"-"+DOB.month+"-"+DOB.year);
		}catch(Exception e){
		}
        System.out.println("Nominee: "+ nominee);
        System.out.println("Balance: "+balance);


    }
    public void confirmChanges()throws Exception{


        int ch=0;
        String pre="";
        FileReader fr=null;
        try
        {
            fr = new FileReader("AccountInfo.txt");
            while ((ch=fr.read())!=-1) pre = pre + (char)ch;
            fr.close();
        }
        catch (Exception fe)
        {
            String str = "Account Info \n";
          //  System.out.println("File not found");
            FileWriter fw=new FileWriter("AccountInfo.txt");
            for (int i = 0; i < str.length(); i++) fw.write(str.charAt(i));
            fw.close();
        }

        int j=0;
        String amount="0";
        while(j<pre.length()){

            ch= pre.charAt(j);

            if(ch==10){
                try{

                    String id = pre.substring(j+1,j+14);
                    int linestart= j+1;

                    if(id.equals(this.ID)){
                        System.out.println("ok");

                        int count=0, st=0;
                        j++;
                        ch= pre.charAt(j);

                        while(ch!=10){

                            ch= pre.charAt(j);
                            if(ch=='|'){
                                count ++;

                            }
                            if (count==3){
                                st= j;
                            }
                            j++;
                        }

                        int lineend= j;
                        String line = pre.substring(linestart,lineend);
                        amount = pre.substring(st+3, j-1);
                        String newLine=line.replace(amount, String.valueOf(balance));
                        pre = pre.replace(line,newLine);

                        String str= pre;

                        FileWriter fw=new FileWriter("AccountInfo.txt");
                        for (int i = 0; i < str.length(); i++) fw.write(str.charAt(i));
                        System.out.println("Account Transection Successful!");
                        fw.close();
                        return;
                    }



                }catch (StringIndexOutOfBoundsException e){
                }
            }
            j++;
        }

String str="";

		try{
			
         str = this.ID + "\t|\t" + name.replace("|","")+ "\t|\t"+ nominee.replace("|","") + "\t|\t" + DOB.day+"/"+DOB.month+"/"+DOB.year + "\t|\t" +balance +"\t|\t"+this.Ac_type+  "\n";
		}catch(Exception e){
		}
        str= pre +str;

        FileWriter fw=new FileWriter("AccountInfo.txt");
        for (int i = 0; i < str.length(); i++) fw.write(str.charAt(i));
        System.out.println("Account Transection Successful!");
        fw.close();

    }
}
