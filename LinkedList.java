//Class Linkedlist

public class LinkedList
{
    //declare variables
    private Node head,tail,current;
    
    //default Linkedlist Class
    public LinkedList()
    {
        head=tail=current=null;  // @ head = null; tail=null; current=null;
    }
    
    //to Check whether the Linkedlist is Empty
    public boolean isEmpty()
    {
        return head == null;
    }
    
    //To print data
    public String print()
    {
        if (isEmpty())
        return "(Empty List)";
        else
        return "("+ head +")";
    }
    
    //To Add new object data at the front of the LinkedList 
    public void insertAtFront(Object data)
    {
        if (isEmpty())
        head = tail = new Node (data);
        else 
        head = new Node (data,head);
    }
    
    //return the number of elements in the list
    public int size ()
    {
        int count = 0;
        
        if (isEmpty())
         return count;
        
        current=head;
        while (current != null)
        {
            ++count;
            current=current.next;
        }
        return count;
    }
    
    //to add Object Data at the back of linked list
    public void insertAtBack(Object data)
    {
        if (isEmpty())
        head = tail = new Node(data);
        else
        tail = tail.next = new Node (data);
    }
    
    //Return first element in the linked list
    public Object getFirst() throws EmptyListException
    {
        if(isEmpty())
        throw new EmptyListException();
        else
        current = head;
        return current.data;
    }
    
    //Return the Next element in the linked list
    public Object getNext()
    {
        if(current != tail)
        {
            current=current.next;
            return current.data;
        }
        else
        return null;
    }
    
    //Return the Last element in the linked list
    public Object getLast() throws EmptyListException
    {
        if (isEmpty())
        throw new EmptyListException();
        return tail.data;
    }
    
    //Remove the first element in the linked list
    public Object removeFromFront () throws EmptyListException
    {
        if(isEmpty())
        throw new EmptyListException();
        
        Object d = head.data;
        
        if(head == tail)
            head=tail=null;
        else 
        {
            Node curr = head;
            head = head.next;
            curr.next = null;
        }
        return d;
    }
    
    //Remove the Last element in the linked list
    public Object removeFromBack() throws EmptyListException
    {
        if(isEmpty())
        throw new EmptyListException();
        
        Object d = tail.data;
        
        if(head==tail)
            head=tail=null;
        else
        {
            Node curr = head;
            while (curr.next != tail)
                curr=curr.next;
            
            tail=curr;
            curr.next=null;
        }
        return d;
    }
}