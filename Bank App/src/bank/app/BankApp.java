
package bank.app;
import java.util.*;
public class BankApp {

    public static int userNumber=-1;

    public static void main(String[] args) {
       Scanner asd = new Scanner(System.in);
        
        
        User user_0 = new User("Mehmet Batuhan","Duman",123456,"1234","059999999999","mehmetbatuhanduman@gmail.com");
        User user_1 = new User("name1","surname1",456789,"4567","058888888888","name1surname1@cbu.com");
        User user_2 = new User("name2","surname2",123789,"1245","057777777777","name1surname1@cbu.com");
        User user_3 = new User("name3","surname3",654321,"3214","0566666666666","name1surname1@cbu.com");
        
        User[] users = {user_0,user_1,user_2,user_3};
      
                   
            String menu =(      
                                "*****************************************\n"+
                                "1_New Account\n"
                              + "2_New Credit Cart\n"
                              + "3_Show Account(Enter a account num)\n"
                              + "4_Show Carts(Enter a cart num)\n"
                              + "5_EFT\n"
                              + "6_Withdrawn\n"
                              + "7_Pay Debt\n"
                              + "8_ EFT TRANSACTIONS HAS MADE \n"
                              + "9_Show user's information\n"
                              + "10_EXIT\n"
                              + "*****************************************");
       

        boolean workin = true;
        String num;
        
         int userNum = -1; 
         boolean userSelect = true;
         int accountLimit = 0;
         int cartLimit = 0;
         int creditCartLimit = 0;
         //***************************************************************************************************************
        System.out.println("_______________________________________DUMAN-BANK_______________________________________");
         System.out.print("Costumer Number: ");
         int costumer_num = asd.nextInt();
         asd.nextLine();
         System.out.print("Password: ");
         String password = asd.nextLine();
        
         try{
             for(int i = 0;i<=users.length;i++){
             if((users[i].getCostumer_number() == costumer_num) && (users[i].getPassword().contains(password))){
                 userSelect = true;
                 userNum = i;
                 break;
             }
            
         }
         }catch(ArrayIndexOutOfBoundsException ex){
             System.out.println("Wrong user name or password.");
             System.exit(0);
             
         }//***************************************************************************************************************
         System.out.println("___________________________________________________WELCOME_"+users[userNum].getName()+" "+users[userNum].getSurname());
       
        while(workin && userSelect){
              
          

            System.out.println(menu);
            System.out.print("CHOOSE: ");
            num = asd.nextLine();
            
            
            switch(num){
                
                case "1":    //Open Account
                    if(accountLimit == 5){
                        System.out.println("You can not open new account more than 5.");
                        continue;
                    }
                    System.out.print("Balance:");
                    double balance = asd.nextDouble();
                    System.out.print("Minimum Balance:");
                    double minBalance = asd.nextDouble();
                    asd.nextLine();
                    users[userNum].openAccount(balance, minBalance);
                    accountLimit++;
                    
                    break;
                
                case "2":    //Take New Cart
                    if(cartLimit == 2){
                        System.out.println("You can not take new cart more than 2.");
                        continue;
                    }
                    
                    System.out.print("Enter Your Money Limit: ");
                    double limit = asd.nextDouble();
                    double debt = 0;
                    System.out.print("Minimum Debt: ");
                    double minDebt = asd.nextDouble();
                    asd.nextLine();
                     users[userNum].newCreditCart(limit, debt, minDebt);
                     cartLimit++;
                    break;
                    
                
                case "3":   //Show Account with Account Number
                    if(accountLimit == 0){
                        System.out.println("You do not have any accounts for the money transaction.\n"
                                        + "*You have to open an account.*\n"
                                         + "Do you want to open an account?(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
          
                    System.out.print("Balance:");
                    balance = asd.nextDouble();
                    System.out.print("Minimum Balance:");
                    minBalance = asd.nextDouble();
                    asd.nextLine();
                    users[userNum].openAccount(balance, minBalance);
                    accountLimit++;
                    break;
                        }else{
                            continue;
                        }
                }
                      
                    System.out.print("Please enter your Account number: ");
                    String accountNum = asd.nextLine();
                    users[userNum].show_Accounts(accountNum);
                    break;
                
                case "4":     //Show Cart with CreditCart Number
                    if(cartLimit == 0){
                        
                         System.out.println("You do not have any CreditCart.\n"
                                         + "*You have to take a cart.*");
                         continue;
                    }
                    System.out.print("Cart Number: ");
                    String showCart = asd.nextLine();
                    users[userNum].show_Carts(showCart);
                    break;
                    
                case "5":   //EFT(Money Transaction) with IBAN Number
                    if(accountLimit == 0){
                        System.out.println("You do not have any accounts for the money transaction.\n"
                                        + "*You have to open an account.*\n"
                                         + "Do you want to open an account?(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                             if(accountLimit == 5){
                        System.out.println("You can not open new account more than 5.");
                        continue;
                    }
                    System.out.print("Balance:");
                    balance = asd.nextDouble();
                    System.out.print("Minimum Balance:");
                    minBalance = asd.nextDouble();
                    asd.nextLine();
                    users[userNum].openAccount(balance, minBalance);
                    accountLimit++;
                    break;
                        }else{
                            continue;
                        }
                }
                    boolean check = true;
                    int getNum = -1;
                    
                    System.out.print("IBAN: ");
                    String receiver = asd.nextLine();
                    System.out.print("Money: ");
                    double money = asd.nextInt();
                    asd.nextLine();
                    if(users[userNum].getIBAN().contains(receiver)){
                        getNum = users[userNum].getIBAN().indexOf(receiver);
                        check = true;
                    }else{
                        check = false;
                    }
                    
                    if(check == true){
                        users[userNum].getBank_accounts()[getNum].EFT(receiver, money);
                        
                        System.out.println("Your EFT sucessfully done...");
                    }else{
                        System.out.println("Error EFT ");
                    }
                    break;
               
                case "6":   //Money Withdrawn with Cart Number
                    if(cartLimit == 0){
                         System.out.println("You do not have any CreditCart for the withdrawn.\n"
                                         + "*You have to take a cart.*");
                         continue;
                    }
                     boolean checkCart = true;
                    int getNumCart = -1;
                    
                    System.out.print("CreditCart Number: ");
                    String cart = asd.nextLine();
                    System.out.print("Money: ");
                    double moneyCart = asd.nextDouble();
                    asd.nextLine();
                   if(users[userNum].getCartNums().contains(cart)){
                       getNumCart = users[userNum].getCartNums().indexOf(cart);
                       checkCart = true;
                   }else{
                       checkCart = false;
                   }
                   
                   if(checkCart == true){
                       users[userNum].getCreditCart()[getNumCart].withdrawn(cart, moneyCart);
                     
                   }else{
                       System.out.println("Withdrawn Error!");
                   }
                    break;
                
                case "7":   //Debt paying with CreditCart Number
                    if(cartLimit == 0){
                         System.out.println("You do not have any CreditCart for the paying debt.\n"
                                         + "*You have to take a cart.*");
                         continue;
                    }
                    checkCart = true;
                     getNumCart = -1;
                    
                    System.out.print("CreditCart Number: ");
                    cart = asd.nextLine();
                    System.out.print("Pay Debt(Enter Cash): ");
                    moneyCart = asd.nextDouble();
                    asd.nextLine();
                   if(users[userNum].getCartNums().contains(cart)){
                       getNumCart = users[userNum].getCartNums().indexOf(cart);
                       checkCart = true;
                   }else{
                       checkCart = false;
                   }
                   if(checkCart == true){
                       users[userNum].getCreditCart()[getNumCart].payDebt(cart, moneyCart);
                   }else{
                       System.out.println("Debt Error!");
                   }
                        
                   break;
                    
                case "8":   //Shows the EFT TRANSACTIONS HAS MADE.
                    check = true;
                    getNum = -1;
                    
                    System.out.print("IBAN: ");
                    receiver = asd.nextLine();
                    if(users[userNum].getIBAN().contains(receiver)){
                        getNum = users[userNum].getIBAN().indexOf(receiver);
                        check = true;
                    }else{
                        check = false;
                    }
                    
                    if(check == true){
                        System.out.println("EFT TRANSACTIONS:");
                       users[userNum].getBank_accounts()[getNum].recordOfEFT(receiver);
                        
                        
                    }else{
                        System.out.println("Error EFT ");
                    }  
                    break;
                    
                case "9"://Show User's Information
                    users[userNum].showUser();
                    break;
                
                case "10"://Exit
                    workin = false;
                    userSelect = false;
                    break;
               
               default: 
                   System.out.println("incorrect operation");
                  
                   
                   try{
                    
                    char one = num.charAt(0);
                    char two = num.charAt(0);
                    char three = num.charAt(0);
                    char four = num.charAt(0);
                    char five = num.charAt(0);
                    char six = num.charAt(0);
                    char seven = num.charAt(0);
                    char eight = num.charAt(0);
                    char nine = num.charAt(0);
                    
                   
                    if(one == '1'){
                        System.out.print("Did you mean open new account:(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                          
                    System.out.print("Balance:");
                    balance = asd.nextDouble();
                    System.out.print("Minimum Balance:");
                    minBalance = asd.nextDouble();
                    asd.nextLine();
                    users[userNum].openAccount(balance, minBalance);
                    accountLimit++;
                    break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    
                    if(two == '2'){
                        System.out.print("Did you mean take new CreditCart:(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                   System.out.print("Enter Your Money Limit: ");
                     limit = asd.nextDouble();
                     debt = 0;
                    System.out.print("Minimum Debt: ");
                     minDebt = asd.nextDouble();
                    asd.nextLine();
                     users[userNum].newCreditCart(limit, debt, minDebt);
                     cartLimit++;
                    break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    
                    if(three == '3'){
                        System.out.print("Did you mean show account:(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                          if(accountLimit == 0){
                        System.out.println("You do not have any accounts for the money transaction.\n"
                                        + "*You have to open an account.*\n"
                                         + "Do you want to open an account?(yes or no)");
                        answer = asd.nextLine();
                        if(answer.contains("yes")){
                             if(accountLimit == 5){
                        System.out.println("You can not open new account more than 5.");
                        continue;
                    }
                    System.out.print("Balance:");
                    balance = asd.nextDouble();
                    System.out.print("Minimum Balance:");
                    minBalance = asd.nextDouble();
                    asd.nextLine();
                    users[userNum].openAccount(balance, minBalance);
                    accountLimit++;
                    break;
                        }else{
                            continue;
                        }
                }
                       if(accountLimit == 5){
                        System.out.println("You can not open new account more than 5.");
                        continue;
                    }
                    System.out.print("Please enter your Account number: ");
                    accountNum = asd.nextLine();
                    users[userNum].show_Accounts(accountNum);
                    break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    
                    if(four == '4'){
                        System.out.print("Did you mean show CreditCart:(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                            
                    if(cartLimit == 0){
                         System.out.println("You do not have any CreditCart.\n"
                                         + "*You have to take a cart.*");
                         continue;
                    }
                    System.out.print("Cart Number: ");
                    showCart = asd.nextLine();
                    users[userNum].show_Carts(showCart);
                    break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    
                    if(five == '5'){
                        System.out.print("Did you mean EFT(nomey transaction):(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                          
                     if(accountLimit == 0){
                        System.out.println("You do not have any accounts for the money transaction.\n"
                                        + "*You have to open an account.*\n"
                                         + "Do you want to open an account?(yes or no)");
                        answer = asd.nextLine();
                        if(answer.contains("yes")){
                             if(accountLimit == 5){
                        System.out.println("You can not open new account more than 5.");
                        continue;
                    }
                    System.out.print("Balance:");
                    balance = asd.nextDouble();
                    System.out.print("Minimum Balance:");
                    minBalance = asd.nextDouble();
                    asd.nextLine();
                    users[userNum].openAccount(balance, minBalance);
                    accountLimit++;
                    break;
                        }else{
                            continue;
                        }
                }
                    check = true;
                    getNum = -1;
                    
                    System.out.print("IBAN: ");
                    receiver = asd.nextLine();
                    System.out.print("Money: ");
                    money = asd.nextInt();
                    asd.nextLine();
                    if(users[userNum].getIBAN().contains(receiver)){
                        getNum = users[userNum].getIBAN().indexOf(receiver);
                        check = true;
                    }else{
                        check = false;
                    }
                    
                    if(check == true){
                        users[userNum].getBank_accounts()[getNum].EFT(receiver, money);
                        System.out.println("Your EFT sucessfully done...");
                    }else{
                        System.out.println("Error EFT ");
                    }
                    break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    
                    if(six == '6'){
                        System.out.print("Did you mean Withdrawn:(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                          
                     if(cartLimit == 0){
                         System.out.println("You do not have any CreditCart for the withdrawn.\n"
                                         + "*You have to take a cart.*");
                         continue;
                    }
                    checkCart = true;
                    getNumCart = -1;
                    
                    System.out.print("CreditCart Number: ");
                    cart = asd.nextLine();
                    System.out.print("Money: ");
                    moneyCart = asd.nextDouble();
                    asd.nextLine();
                   if(users[userNum].getCartNums().contains(cart)){
                       getNumCart = users[userNum].getCartNums().indexOf(cart);
                       checkCart = true;
                   }else{
                       checkCart = false;
                   }
                   
                   if(checkCart == true){
                       users[userNum].getCreditCart()[getNumCart].withdrawn(cart, moneyCart);
                     
                   }else{
                       System.out.println("Withdrawn Error!");
                   }
                    break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    
                    if(seven == '7'){
                        System.out.print("Did you mean Pay Debt:(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                      if(creditCartLimit == 0){
                         System.out.println("You do not have any CreditCart for the paying debt.\n"
                                         + "*You have to take a cart.*");
                         continue;
                    }
                    checkCart = true;
                     getNumCart = -1;
                    
                    System.out.print("CreditCart Number: ");
                    cart = asd.nextLine();
                    System.out.print("Pay Debt(Enter Cash): ");
                    moneyCart = asd.nextDouble();
                    asd.nextLine();
                   if(users[userNum].getCartNums().contains(cart)){
                       getNumCart = users[userNum].getCartNums().indexOf(cart);
                       checkCart = true;
                   }else{
                       checkCart = false;
                   }
                   if(checkCart == true){
                       users[userNum].getCreditCart()[getNumCart].payDebt(cart, moneyCart);
                   }else{
                       System.out.println("Debt Error!");
                   }
                        
                   break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    
                    if(eight == '8'){
                        System.out.print("Did you mean Show User's Information:(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                  check = true;
                    getNum = -1;
                    
                    System.out.print("IBAN: ");
                    receiver = asd.nextLine();
                    if(users[userNum].getIBAN().contains(receiver)){
                        getNum = users[userNum].getIBAN().indexOf(receiver);
                        check = true;
                    }else{
                        check = false;
                    }
                    
                    if(check == true){
                        System.out.println("EFT TRANSACTIONS:");
                       users[userNum].getBank_accounts()[getNum].recordOfEFT(receiver);
                        
                        
                    }else{
                        System.out.println("Error EFT ");
                    }  
                    break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    
                    if(nine == '9'){
                        System.out.print("Did you mean EXIT:(yes or no)");
                        String answer = asd.nextLine();
                        if(answer.contains("yes")){
                    workin = false;
                    userSelect = false;
                    break;
                        }else{
                            System.out.println("incorrect operation");
                            continue;
                        }
                    }
                    break;
                
                
            }catch(StringIndexOutOfBoundsException ex){
                       System.out.println("incorrect operation");
                continue;
            }   
        }

    }
}
    }
