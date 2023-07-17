//import library
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.lang.model.util.ElementScanner14;


public class MainSeatReservation
{
    public static void main (String [] args)
    {
        //import scanner
        Scanner in = new Scanner(System.in);
        //create Linkedlist [LinkedList] of customer
        LinkedList custList = new LinkedList();
        //declare variables for user input
        Queue custListQ = new Queue();
        Stack custListS = new Stack();
       
        //ask user for the number of Customers
        System.out.print ("Enter no of Customer :");
        int n = Integer.parseInt(in.nextLine());
        ArrayList SeatResList = new ArrayList(n);
        
        //add customer to the list
        for (int i = 0; i<SeatResList.getMaxSize(); i++)
        {
            //ask user input
            System.out.print("\nEnter your Name :");
            String name = in.nextLine();
            System.out.print("Enter your IC :");
            String IC = in.nextLine();
            System.out.print("Enter your Age :");
            int age = Integer.parseInt(in.nextLine());
            
            
            //assign object class
            Customer cst = new Customer();
            cst.setCustomer(name,IC,age);
            custList.insertAtBack(cst); //add method dalam arraylist
        }
        
        //get first customer from linked list
        Object obj = custList.getFirst();
        int i = 0;
        while(obj != null)
        {
            Customer cst = (Customer)obj;
            System.out.println("*********WELCOME TO RAILWAY SEAT RESERVATION SYSTEM********");
            System.out.print("***************************************");
            System.out.println("  \n    Seat Purchased by " +cst.getCustName());
            System.out.println("***************************************");
            System.out.print("Enter Seat No :");
            String seatNo = in.nextLine();
            System.out.print("Destination :");
            String destination = in.nextLine();
            System.out.print("Number of Passenger:");
            int numOfPassenger = Integer.parseInt(in.nextLine());
            System.out.print("Ticket seat price (RM) : ");
            double ticketPrice = in.nextDouble();
            
            SeatReservation seat = new SeatReservation();
            seat.setSeatReservation(seatNo,destination,numOfPassenger,
            ticketPrice,cst.getCustName(),cst.getCustIC(),cst.getCustAge());
            SeatResList.add(i,seat);
            in.nextLine();
            
            obj = custList.getNext();
            i++;
        }
        
        //Display current data in Arraylist
        System.out.println("===============================================");
        System.out.println("Current List in ArrayList.");
        System.out.println(custList.print() + "\n");
        
        
        // Copying Data from Arraylist to LinkedList
        LinkedList seat = new LinkedList();
        
        // ArrayList >> LinkedList
        for (i = 0; i < SeatResList.getMaxSize(); i++) {
            Object ob = SeatResList.getData(i);
            SeatReservation seat1 = (SeatReservation) ob;

            seat.insertAtBack(seat1);
        }
        
        //search boolean
        String searchMe = "Y";
        int select;
        double totalP = 0;
        
        //Menu Selection
        while (searchMe.equalsIgnoreCase("Y")){
        System.out.println("====================================");
        System.out.println("            MAIN MENU");
        System.out.println("====================================");
        System.out.println("1.    TOTAL PROFIT OF TICKETS SOLD");
        System.out.println("2.    AVERAGE OF TICKETS SOLD");
        System.out.println("3.    MINIMUM SPENT BY CUSTOMER");
        System.out.println("4.    MAXIMUM SPENT BY CUSTOMER");
        System.out.println("5.    REMOVE CUSTOMER DATA");
        System.out.println("====================================");
        
        select = Integer.parseInt(in.nextLine());
        
        //This will calculate the sum of tickets sold
        if(select==1){
           totalP = 0;
           Object ob = seat.getFirst();
           
           while (ob != null){
               SeatReservation st = (SeatReservation) ob;
               totalP += st.getTicketPrice() * st.getNumOfPassenger();
               ob = seat.getNext();
           }
           
           System.out.println("TOTAL PROFIT OF TICKETS SOLD IS :" +totalP);
         }
         else if(select==2){
            System.out.println("2. AVERAGE PROFIT OF TICKETS SOLD");
            totalP = 0;
            Object ob = seat.getFirst(); 
            
            while (ob != null){
               SeatReservation st = (SeatReservation) ob;
               totalP += st.getTicketPrice() * st.getNumOfPassenger();
               ob = seat.getNext();
            }
            
            System.out.println("AVERAGE PROFIT OF TICKETS SOLD IS :" +(totalP/seat.size()));
         }
         else if(select==3){
            System.out.println("3. MINIMUM SPENT BY CUSTOMER");
            Object ob = seat.getFirst(); 
            SeatReservation st = (SeatReservation) ob;
            double min = st.getTicketPrice();
            Object ob2 = seat.getFirst();
            while (ob2 != null){
            SeatReservation s2 = (SeatReservation) ob2;
            if (s2.getTicketPrice () < min){
                min = s2.getTicketPrice();
            }
            ob2 = seat.getNext();
            }
            System.out.println("MINIMUM SPENT BY CUSTOMER :" +min);
         }
         else if(select==4){
            System.out.println("4. MAXIMUM SPENT BY CUSTOMER");
            Object ob = seat.getFirst(); 
            SeatReservation st = (SeatReservation) ob;
            double max = st.getTicketPrice();
            Object ob2 = seat.getFirst();
            while (ob2 != null){
            SeatReservation s2 = (SeatReservation) ob2;
            if (s2.getTicketPrice () > max){
                max = s2.getTicketPrice();
            }
            ob2 = seat.getNext();
            }
            System.out.println("MAXIMUM SPENT BY CUSTOMER :" +max);
         }
         else if(select==5){
             System.out.print("Did You Want To Remove data? (Y/N):");
             String r = in.nextLine();
         
         if(r.equalsIgnoreCase("Y")){
            System.out.println(" Remove from front or back? (F/B):");
            String fb = in.nextLine();
            if(fb.equalsIgnoreCase("F"))
            seat.removeFromFront();
            else if(fb.equalsIgnoreCase("B"))
            seat.removeFromBack();
         }
         int rev = 1;
         Object ob1 = seat.getFirst();
         System.out.print("-------");
         System.out.print("Front");
         System.out.print("-------");
         while (ob1 != null){
            SeatReservation st = (SeatReservation) ob1;
            System.out.println(st.getCustName());
            ob1 = seat.getNext();
         }
         System.out.print("-------");
         System.out.print("Back "); 
         System.out.println("-------");
        }
         System.out.println("Do you want continue? (Y/N)");
         searchMe = in.nextLine();
     }
     
        int searchIndex = -1;
        String sname;
        System.out.print("SEARCH CUSTOMER :");
        sname = in.nextLine();
        boolean found = true;
        
        for (int k = 0 ; k < seat.size() ; k++)
        {
            Object ob = seat.getFirst();
            SeatReservation st = (SeatReservation) ob;
           
           found = (st.getCustName().equalsIgnoreCase(sname));
            searchIndex = k;
            found = true;
            break;
           
        }
        
        if(found){
        
        System.out.println(sname + " found in Customer List ");
        }
        else
        System.out.println(sname + " not found in Customer List ");
        
        
        System.out.println("****************SYSTEM ENDED*******************");
    } 
    
}
