
package bank.app;

import java.util.List;
import java.util.ArrayList;

public class Account {
    
    private double balance;
    private double minimum_balance;
    private String account_number;
    private String IBAN_number;
    private static int numberOfAccounts = 0;
    private List<String> EFTrec = new ArrayList<String>();
    private List<Double> EFTmoneyRec = new ArrayList<Double>();

     
    
    public Account(double balance, double minimum_balance) {
        this.balance = balance;
        this.minimum_balance = minimum_balance;
        int accountNum = (int)(Math.random()*1000000000);
        this.account_number = Integer.toString(accountNum);
        this.IBAN_number = "TR"+"036"+this.account_number;
        //numberOfAccounts++;
    }

    
    
    public void EFT(String IBANreceiver,double money){
        double transferPayment = 0;
        if(money <= 1000){
           transferPayment += 1;
           money -= 1;
        }else if(money <= 50000 && money >1000){
            transferPayment += 10;
            money -= 10;
        }else if( money >50000){
            transferPayment += 100;
            money -= 100;
        }
        
        //double balanceR;
        boolean checkR = true;
        if(IBAN_number.contains(IBANreceiver)){
            EFTrec.add(IBAN_number);
            checkR = true;
        }else{
            checkR = false;
            System.out.println("Wrong IBAN");
        }
            
        if(checkR == true){
            this.balance += money;
            EFTmoneyRec.add(this.balance);
            System.out.println("Your balance after EFT: "+this.balance);
            System.out.println("EFT payment: "+transferPayment);
        }
       
       
    }
    
    public void recordOfEFT(String IBANreceiver){
         boolean checkR = true;
        if(IBAN_number.contains(IBANreceiver)){
            checkR = true;
        }else{
            checkR = false;
            System.out.println("Wrong IBAN");
        }
        
        if(checkR == true){
          EFTmoneyRec.forEach((a)->System.out.println(a));
        }
    }

    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimum_balance() {
        return minimum_balance;
    }

    public void setMinimum_balance(double minimum_balance) {
        this.minimum_balance = minimum_balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getIBAN_number() {
        return IBAN_number;
    }

    public void setIBAN_number(String IBAN_number) {
        this.IBAN_number = IBAN_number;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        Account.numberOfAccounts = numberOfAccounts;
    }

    public List<String> getEFTrec() {
        return EFTrec;
    }

    public void setEFTrec(List<String> EFTrec) {
        this.EFTrec = EFTrec;
    }

    public List<Double> getEFTmoneyRec() {
        return EFTmoneyRec;
    }

    public void setEFTmoneyRec(List<Double> EFTmoneyRec) {
        this.EFTmoneyRec = EFTmoneyRec;
    }

                       
    

}
