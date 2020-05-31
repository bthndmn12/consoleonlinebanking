
package bank.app;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    private String name;
    private String surname;
    private int costumer_number;
    private String password;
    private String email;
    private String telephone_number;
    private Account [] bank_accounts = new Account[5];
    private static int numberOfAccounts = 0;
    private Credit [] creditCart = new Credit[2];
    private static int numberOfCarts = 0;
    private List<String> accNums = new ArrayList<String>();
    private List<String> IBAN = new ArrayList<String>();
    private List<String> cartNums = new ArrayList<String>();
   
   
    public User(String name, String surname, int costumer_number, String password, String telephone_number,String email) {
        this.name = name;
        this.surname = surname;
        this.costumer_number = costumer_number;
        this.password = password;
        this.telephone_number = telephone_number;
        this.email = email;
    }
    
    
    public void openAccount(double balance,double minimum_balance){
        //int numberOfAccounts = 0;
       //bank_accounts = new Account[5];
      Account New_User_Account = new Account(balance,minimum_balance);
      bank_accounts[numberOfAccounts] = New_User_Account;
      accNums.add(New_User_Account.getAccount_number());
      IBAN.add(New_User_Account.getIBAN_number());
        System.out.println("__________________YOUR ACCOUNT HAS CREATED__________________");
        System.out.println("Balance: "+bank_accounts[numberOfAccounts].getBalance());
        System.out.println("Minimum Balance: "+bank_accounts[numberOfAccounts].getMinimum_balance());
        System.out.println("Account Number(Keep It Please): "+ bank_accounts[numberOfAccounts].getAccount_number());
        System.out.println("IBAN: "+bank_accounts[numberOfAccounts].getIBAN_number());
        System.out.println("____________________________________________________________");
        System.out.println("______________________________________"+this.name+" "+this.surname);
      
        numberOfAccounts++;
    }
    
    public  void show_Accounts(String Account_Enter){
        boolean check = true;
        int getNum = -1;
        
        if(accNums.contains(Account_Enter)){
            getNum = accNums.indexOf(Account_Enter);
           check = true;
        }else{
            check = false;
        }
    
        if(check == true){
         System.out.println("__________________Account_"+(getNum+1)+"__________________");
        System.out.println(getNum+1+"_Account:");
        System.out.println("Balance: "+bank_accounts[getNum].getBalance());
        System.out.println("Minimum Balance: "+bank_accounts[getNum].getMinimum_balance());
        System.out.println("Account Number(Keep It Please): "+ bank_accounts[getNum].getAccount_number());
        System.out.println("IBAN: "+bank_accounts[getNum].getIBAN_number());
        System.out.println("____________________________________________________________");
        System.out.println("______________________________________"+this.name+" "+this.surname);
        }else{
        System.out.println("Wrong Account Number.");
        }
    }
    
    
    public void newCreditCart(double limit,double debt,double minimum_debt){
        Credit New_User_Cart = new Credit(limit,debt,minimum_debt);
       creditCart[numberOfCarts] = New_User_Cart;
       cartNums.add(New_User_Cart.getCreditCart_number());
        System.out.println("__________________YOUR CREDIT CART HAS CREATED__________________");
        System.out.println("Limit: "+creditCart[numberOfCarts].getLimit());
        System.out.println("Debt"+creditCart[numberOfCarts].getDebt());
        System.out.println("Minimum Debt: "+creditCart[numberOfCarts].getMinimum_debt());
        System.out.println("CreditCart Number(Don't Forget): "+creditCart[numberOfCarts].getCreditCart_number());
        System.out.println("____________________________________________________________");
        System.out.println("____________________________________________"+this.name+" "+this.surname);
       numberOfCarts++;
    }
    
    public void show_Carts(String cart_Enter){
        boolean check = true;
        int getNum = -1;
        
        if(cartNums.contains(cart_Enter)){
            getNum = cartNums.indexOf(cart_Enter);
           check = true;
        }else{
            check = false;
        }
        if(check == true){
        System.out.println("__________________DUMAN-CART_"+(getNum+1)+"__________________");
        System.out.println("Limit: "+creditCart[getNum].getLimit());
        System.out.println("Debt"+creditCart[getNum].getDebt());
        System.out.println("Minimum Debt: "+creditCart[getNum].getMinimum_debt());
        System.out.println("Credit Cart Number(Don't Forget): "+creditCart[getNum].getCreditCart_number());
        System.out.println("____________________________________________________________");
        System.out.println("____________________________________________"+this.name+" "+this.surname);
    }else{
            System.out.println("Wrong Cart Number.");
        }
        
    }
    public void showUser(){
        System.out.println("Name: "+this.name);
        System.out.println("Surname: "+this.surname);
        System.out.println("Costumer Number: "+this.costumer_number);
        System.out.println("Email: "+this.email);
        System.out.println("Phone Number: "+this.telephone_number);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCostumer_number() {
        return costumer_number;
    }

    public void setCostumer_number(int costumer_number) {
        this.costumer_number = costumer_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public Account[] getBank_accounts() {
        return bank_accounts;
    }

    public void setBank_accounts(Account[] bank_accounts) {
        this.bank_accounts = bank_accounts;
    }
     public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    public static void setNumberOfAccounts(int numberOfAccounts) {
        User.numberOfAccounts = numberOfAccounts;
    }

    public Credit[] getCreditCart() {
        return creditCart;
    }

    public void setCreditCart(Credit[] creditCart) {
        this.creditCart = creditCart;
    }

    public static int getNumberOfCarts() {
        return numberOfCarts;
    }

    public static void setNumberOfCarts(int numberOfCarts) {
        User.numberOfCarts = numberOfCarts;
    }

    public List<String> getAccNums() {
        return accNums;
    }

    public void setAccNums(List<String> accNums) {
        this.accNums = accNums;
    }

    public List<String> getIBAN() {
        return IBAN;
    }

    public void setIBAN(List<String> IBAN) {
        this.IBAN = IBAN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCartNums() {
        return cartNums;
    }

    public void setCartNums(List<String> cartNums) {
        this.cartNums = cartNums;
    }
    
    
}
