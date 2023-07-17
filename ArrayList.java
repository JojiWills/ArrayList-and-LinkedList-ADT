
public class ArrayList
{
   //declare variables
   public Object [] data;
   private int length,maxSize;
   
   //default constructor
   public ArrayList()
   {
      maxSize = 0;
      data = null;
      length = 0;
   }
   
   //normal constructor
   public ArrayList(int k)
   {
       maxSize = k;
       data = new Object[maxSize];
       length = 0;
   }
   
   //Return the size of the ArrayList
   public int getMaxSize()
   {
       return maxSize;
   }
   
   //Return the number of elements in the ArrayList
   public int getNum()
   {
       return length;
   }
   
   //Insert an element at the back of ArrayList
   public void insertEnd(Object k) throws ArrayListException
   {
       if (!isFull())
       {
           data [length]=k;
           length = length + 1;
       }
       else
           throw new ArrayListException("The Array List is full");
   }
   
   //Insert an element at the front of the Arraylist
   public void insertFront (Object k) throws ArrayListException
   {
       add(0,k);
   }
   
   //Insert an element at a specified index of the ArrayList
   public void add (int i,Object k) throws ArrayListException
   {
       if (isFull())
           throw new ArrayListException("The Array List is Full");   
        else if ((i<0) || (i>length))
           throw new ArrayListException("Index is out of Bounds");
        else 
        {
            for(int j = length-1; j >= i;--j)
            data [j+1] = data[j];
            
            length = length + 1;
            data[i] = k;
        }
   }
   
   //Return data at the specific location
   public Object getData (int i) throws ArrayListException
   {
       if (isEmpty())
       throw new ArrayListException ("The Array List is Empty");
       else if ((i<0) || (i>length-1))
       throw new ArrayListException ("Index is out of bounds");
       
       return data[i];
   }
   
   //Set data at the specified location
   public void setData(int i,Object k) throws ArrayListException 
   {
       if (isEmpty())
       throw new ArrayListException("The Array List is Empty");
       else if ((i<0) || (i>length-1))
       throw new ArrayListException("Index is out of bounds");
       
       data[i] = k;
   }
   
   //Remove data at the specified location 
   public Object removeAt (int i) throws ArrayListException
   {
       if (isEmpty())
       throw new ArrayListException("The Array List is Empty");
       else if ((i<0) || (i>length-1))
       throw new ArrayListException("Index is out of bounds");
       
       if(i==(length-1))
       {
           length = length-1;
           return data[i];
       }
       
       Object obj = data[i];
       for (int j=i;j<length-1;++j)
       {
           data [j] = data[j+1];
       }
       
       length = length-1;
       return obj;
   }
   
   //Remove the first element
   public Object RemoveFirst() throws ArrayListException
   {
       return removeAt(0);
   }
   
   //Remove the last Element 
   public Object RemoveLast() throws ArrayListException
   {
       return removeAt(length-1);
   }
   
   //Clear all the element in the ArrayList
   public void clearList()
   {
       length = 0;
   }
   
   //Return true if the ArrayList is full otherwise return false
   public boolean isFull()
   {
       return length == maxSize;
   }
   
   //Return true if the Arraylist is Empty otherwise return false
   public boolean isEmpty()
   {
       return length == 0;
    }
   //for displaying the element in the ArrayList
   public String print()
   {
       String str = "(";
       if (length == 0)
       return "()";
       else
       {
           for (int i = 0;i<length;i++)
           str += data[i]+",";
           return str+")";
        }
    }
}
