
	public class Q2_DoublyLL 
	{
	    
		class Node
		{
			int data;
			Node next;
			Node prev;
		}
		Node head;
		Q2_DoublyLL()
		{
			head=null;
		}
		public void traverse()
		{
			Node temp=head;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
		public void insert_at_head(int value)
		{
			Node newnode=new Node();
			newnode.data=value;
			newnode.prev=null;
			newnode.next=null;
			newnode.next=head;
			head=newnode;
		}
		public void insert_at_tail(int value)
		{
			Node temp=head;
			Node newnode=new Node();
			newnode.data=value;
			newnode.prev=null;
			newnode.next=null;
			if(temp!=null)
			{
				while(temp.next!=null)
					temp=temp.next;
				newnode.prev=temp;
				temp.next=newnode;
			}
			else 
				head=newnode;
			
		}
		public void insert_at_middle(int value,int pos)
		{
			Node temp=head;
			Node newnode = new Node();
			newnode.data=value;
			newnode.next=null;
			if(temp!=null)
				for(int i=0;(i<pos-1&&temp.next!=null);i++)
					temp=temp.next;
			if(temp.next!=null)
			{
				newnode.prev=temp;
				newnode.next=temp.next;
				newnode.next.prev=newnode;
			}
			temp.next=newnode;
		}
		
		public void delete_node(int data)
		{
			Node temp=head;
			if(head==null)
				System.out.println("Nothing to delete");
			else if(head.data==data && head.next!=null)
				head=head.next;
			else if(temp.next!=null)
			{
				while(temp.next!=null && temp.next.data!=data)
					temp=temp.next;
				if(temp.next!=null)
				{
					temp.next.prev=null;
					temp.next=temp.next.next;
					temp.next.prev=temp;
				}
			}
			else
			{
				if(head.data==data)
					head=null;
				else
					System.out.println("Node not found");
			}
		}
		
		public static void main(String[] args) 
		{
			Q2_DoublyLL o1 = new Q2_DoublyLL();
	    	   o1.insert_at_head(5);
	    	   o1.insert_at_head(10);
	    	   o1.insert_at_tail(15);
	    	   o1.insert_at_head(20);
	    	   System.out.print("Insert after at a position after given node ");
	    	   o1.insert_at_middle(25, 2);
	    	   o1.traverse();	    	  
	    	   System.out.print("Delete a node with given item ");
	    	   o1.delete_node(5);
	    	   o1.traverse();
	       }
	}
   
