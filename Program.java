class ListNode
{
    int val;
    ListNode next;
    
    public ListNode(int _val)
    {
        val = _val;
    }
    
    public ListNode(int _val, ListNode _next)
    {
        val = _val;
        next = _next;
    }
}


class List
{
    ListNode head;
    int Count = 0;
    
    public void Add(int value)
    {
        //If the head is null, simply assign the value to the head
        //Then increment the count by 1
        if(head == null)
        {
            head = new ListNode(value);
            Count += 1;
            return;
        }
        
        //If not, start by defining a ListNode which is equal to the head Node
        ListNode temp = head;
        
        //Loop on this Node until the last element is reached
        while(temp.next != null)
        {
            temp = temp.next;
        }
        
        //Assign the value to the last node, and incement count by 1
        temp.next = new ListNode(value);
        Count += 1;
    }
    
    
    public void DeleteByValue(int value)
    {
        //If the head has the value passed in the parameter, unlink it from the list
        //Then decrement count by 1
        if(head.val == value)
        {
            head = head.next;
            Count -= 1;
            return;
        }
        
        //Otherwise, loop on all nodes until the node that lies before the node with the value is reached
        //Link this node with the node next to the node with the value
        //Then decrement count by 1
        ListNode temp = head;
        while(temp.next != null)
        {
            if(temp.next.val == value)
            {
                temp.next = temp.next.next;
                Count -= 1;
                return;
            }
            temp = temp.next;
        }
    }
    
    public void DeleteByIndex(int index)
    {
        //If the index is the head, unlink it from the list
        if(index == 0)
        {
            head = head.next;
            Count -= 1;
            return;
        }
        
        //Otherwise, loop on all nodes until the node before the node which has the index is reached
        //Delete that node with the same mechanism as the DeleteByValue()
        ListNode temp = head;
        int i = 0;
        while(temp.next != null)
        {
            if(i + 1 == index)
            {
                temp.next = temp.next.next;
                Count -= 1;
                return;
            }
            temp = temp.next;
            i += 1;
        }
    }
    
    
    public int GetElementAtIndex(int index)
    {
        //Check whether the user entered a valid index
        if(index >= Count)
        {
            System.out.println("Index was outside of range");
            return 0;
        }
        
        //Return the value of the head if the index was 0
        if(index == 0)
        {
            return head.val;
        }
        
        //Otherwise, Loop on all the listnodes
        
        ListNode temp = head;
        int i = 0;
        int val = 0;
        while(temp != null)
        {
            //If this node has the required index, return it's value
            if(i == index)
            {
                val = temp.val;
                break;
            }
            //Otherwise, continue looping and increment i by 1
            temp = temp.next;
            i += 1;
        }
        return val;
    }
    
    public int[] ToArray()
    {
        //Define an array with the length of the list
        ListNode temp = head;
        int[] arr = new int[Count];
        int i = 0;
        
        //Loop on each node in the list and add it's value to the array
        while(temp != null)
        {
            arr[i] = temp.val;
            temp = temp.next;
            i += 1;
        }
        
        //Return the array in the end
        return arr;
    }
    
}


class Stack
{
    ListNode head;
    int Top = -1;
    
    public void Push(int value)
    {
        //If the head was null, assign the value to the head
        //Then Increment top by 1
        if(head == null)
        {
            head = new ListNode(value);
            Top += 1;
            return;
        }
        
        //Loop on the nodes until the last node is reached
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        
        //Add the value to the node next to that node
        temp.next = new ListNode(value);
        Top += 1;
    }
    
    public int Pop()
    {
        //If the top was -1, then the stack must be empty
        if(Top == -1)
        {
            System.out.println("Stack is empty");
            return 0;
        }
        
        //If only head was in the stack, return it's value and delete it
        //Decrement Top by 1
        if(head.next == null)
        {
            int val = head.val;
            head = null;
            Top -= 1;
            return val;
        }
        
        //Otherwise, use the same mechanism as deleting a list node to find the last list and return it's value and delete it.
        ListNode temp = head;
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        int val = temp.next.val;
        Top -= 1;
        temp.next = null;
        return val;
    }
}


public class Program
{

     public static void main(String []args)
     {
        //Testing the Data structures 
        List list = new List();
        list.Add(1);
        list.Add(2);
        list.Add(3);
        list.Add(4);
        list.Add(5);
        list.Add(216);
        Stack stack = new Stack();
        stack.Push(1);
        stack.Push(3);
        stack.Push(5);
        stack.Push(7);
        int[] arr = list.ToArray();
        System.out.println(stack.Pop());
        System.out.println(stack.Pop());
        System.out.println(stack.Pop());
        System.out.println(stack.Pop());
        System.out.println(stack.Pop());
     }
     
}