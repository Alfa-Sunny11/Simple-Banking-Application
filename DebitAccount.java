public class DebitAccount extends Account {
    public DebitAccount(String name, int ID, Date DOB, String nominee, double balance,String Ac_type) throws Exception{
        super(name, ID, DOB, nominee,balance,Ac_type);
    }
    public DebitAccount(){

    }

    
    @Override
    public boolean deposit(double amount) {

        if((this.balance+ amount)<10000000){
            this.balance= this.balance+ amount;
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean withdraw(double amount) {
        if((this.balance - amount)>0 && amount<=20000000){
            this.balance= this.balance- amount;
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void balanceValidity(String name, Date DOB, String nominee, double balance){
        if(balance>10000000){
            throw new IllegalArgumentException("Max balance 10000000");
        }
    }
}
