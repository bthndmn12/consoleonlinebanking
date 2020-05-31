                       
package bank.app;


public class Credit {
    
    private double limit;
    private String creditCart_number;
    private double debt;
    private double minimum_debt;
    private double money;
    
  
    
    public Credit(double limit, double debt, double minimum_debt) {
        this.limit = limit;
        this.debt = debt;
        this.minimum_debt = minimum_debt;
         int CartNum = (int)(Math.random()*1000000000);
        this.creditCart_number= Integer.toString(CartNum);
        
        
    }

    
    public void withdrawn(String CartNumber,double withdrawn){
       // double limitCart;
        boolean checkLimit = true;
       
        if(creditCart_number.contains(CartNumber)){
            checkLimit = true;
        }else{
            checkLimit = false;
        }
         
        if(checkLimit == true){
        if(limit >= 0 && withdrawn == limit){
        limit -= withdrawn;
        if(debt < 0){
            limit = 0;
        }
        System.out.println("Your Limit (after withdrawn): "+getLimit());
        }else if(limit > 0 || withdrawn < 0 || limit < 0){
        debt -= withdrawn - limit;
        System.out.println("Your Debt (after withdrawn): "+getDebt());
        }else if(debt == minimum_debt || debt < minimum_debt){
            System.out.println("You have to pay your debt");
        }
     }
}
    public void payDebt(String CartNumber,double money){
        double debtCart;
        boolean checkDebt = true;
       
        if(creditCart_number.contains(CartNumber)){
            checkDebt = true;
        }else{
            checkDebt = false;
        }
        if(checkDebt = true){
        debt += money;
        limit = money;
        System.out.println("Your debt"+debt);
        }
    }
   
    
    
    
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String getCreditCart_number() {
        return creditCart_number;
    }

    public void setCreditCart_number(String creditCart_number) {
        this.creditCart_number = creditCart_number;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public double getMinimum_debt() {
        return minimum_debt;
    }

    public void setMinimum_debt(double minimum_debt) {
        this.minimum_debt = minimum_debt;
    }
    
    
}
