//CHAPTER 3 : LINKED LIST
//HOW TO BUILD A LINKEDLIST

public class Node // class Node is to create a Node
{
   //declare variables
   
   Object data;    //  ----------
   Node next;      //  |   |    |
                  //   ----------
   
    //default constuctor
    public Node ()
    {
        data = null;
        next = null;
    }
    
    //normal constructor
    public Node (Object data)
    {
        this.data = data;
        next = null;
    }
    
    public Node (Object data,Node next)
    {
        this.data = data;
        this.next = next;
    }
    
    //Update data
    //Using SETTERS
    public void setData (Object newData)
    {
        data = newData;
    }
    
    //update the reference to the next Node
    public void setNext (Node newNext)
    {
        next = newNext;
    }
    
    //GETTERS
    //to get the data from main
    public Object getData()
    {
        return data;
    }
    
    //to get the Next data from main
    public Object getNext()
    {
        return next;
    }
    
    //to print @ toString
    public String toString()
    {
        if (next == null)
        return data.toString() + "";
        else 
        return data.toString() + "," + next.toString();
    }
}
