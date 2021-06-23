public class Credit extends Account {
       
    
    public Credit(){
           
    }
    
    public Credit(String name, int ID, Date DOB, String nominee, double balance,String Ac_type) throws Exception{
        super(name, ID, DOB, nominee,balance,Ac_type);
     
    }


    /**
     *
     * @param amount
     * @return
     */
    @Override
    public boolean deposit(double amount) {
        this.balance= this.balance+ amount;
        return true;
    }
    @Override
    public boolean withdraw(double amount) {
       if((this.balance - amount)>-100000 && amount<=200000)
        
        {
            this.balance= this.balance- amount;
            return true;
        }
       else{
            return false;
        }
    }

   @Override
   public void balanceValidity(String name, Date DOB, String nominee, double balance){
        if(balance<-100000){
            throw new IllegalArgumentException("Min balance is -100000");

        }
    }

}
