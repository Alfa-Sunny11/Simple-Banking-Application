public class Savings extends Account{

    String ID;
    public Savings(){

    }
    public Savings(String name, int ID, Date DOB, String nominee, double balance,String Ac_type) throws Exception{
        super(name, ID, DOB, nominee,balance,Ac_type);

    }
    @Override
    public boolean deposit(double amount) {
        this.balance= this.balance+ amount;

        return true;
    }
    @Override
    public boolean withdraw(double amount) {
        if((this.balance - amount)>0){
            this.balance= this.balance- amount;
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void balanceValidity(String name, Date DOB, String nominee, double balance){

    }

}
