
import javax.lang.model.SourceVersion;

public class OldAccount extends Account {

    public OldAccount(String ID)throws Exception{
        super(ID);
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

    /**
     *
     * @param name
     * @param DOB
     * @param nominee
     * @param balance
     */
    @Override
    public void balanceValidity(String name, Date DOB, String nominee, double balance){
        if(balance>10000000){
            throw new IllegalArgumentException("Max balance 100000");
        }
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}
