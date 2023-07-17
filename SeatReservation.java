
public class SeatReservation extends Customer
{
    //declare variable
    String seatNo;
    String destination;
    int numOfPassenger;
    double ticketPrice;
    
    //default constructor
    public SeatReservation ()
    {
         seatNo = "";
         destination ="";
         numOfPassenger = 0;
         ticketPrice = 0.0;
    }
    
    //normal constructor
    public SeatReservation (String seat,String desti,int pass,double ticketP)
    {
        seatNo = seat;
        destination = desti;
        numOfPassenger = pass;
        ticketPrice = ticketP;
    }
    
    //setter
    public void setSeatReservation (String seat,String desti,int pass,double ticketP,String CustName,String CustIC,int CustAge)
    {
        super.CustName=CustName;
        super.CustIC=CustIC;
        super.CustAge=CustAge;
        this.seatNo = seat;
        this.destination = desti;
        this.numOfPassenger = pass;
        this.ticketPrice = ticketP;
    }
    
    //getter
    public String getSeatNo(){return seatNo;}
    public String getDestination(){return destination;}
    public int getNumOfPassenger() {return numOfPassenger;}
    public double getTicketPrice () {return ticketPrice;}
    
    //public toString
    public String toString()
    {
        return ("\nSeat Number :"+seatNo + "\nDestination :"+destination+"\nNumber Of Passenger :"+numOfPassenger +"\nTicket Price:"+ticketPrice);
    }
    
}
