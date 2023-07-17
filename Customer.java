
public class Customer
{
    //declare variable
    String CustName;
    String CustIC;
    int CustAge;
   
    
    //default constructor
    public Customer ()
    {
         CustName = "";
         CustIC ="";
         CustAge = 0;
         
    }
    
    //normal constructor
    public Customer (String Name,String IC, int age)
    {
        CustName = Name;
        CustIC = IC;
        CustAge = age;
        
    }
    
    //setter
    public void setCustomer (String Name,String IC, int age)
    {
        CustName=Name;
        CustIC=IC;
        CustAge=age;
       
    }
    
    //getter
    public String getCustName() {return CustName;}
    public String getCustIC() {return CustIC; }
    public int getCustAge() {return CustAge;}
   
    
    //public toString
    public String toString()
    {
        return ("\nCustomer Name :"+CustName + "\nIC :"+CustIC +"\nAge :"+CustAge);
    }
}   
