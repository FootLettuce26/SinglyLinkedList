package test;
import java.util.ArrayList;

public class MySinglyLinkedList {
	MyNode Head;
	int Size;
	
	MySinglyLinkedList(){
		this.Head = null;
		this.Size = 0;
	}

	//implementation of insertAfter
	public boolean InsertAfter(int x, int y) {
		//search for x
		MyNode currNode = this.Search(x);
		if(currNode == null) {
			return false;
		}else {
			//then insert y after x
			MyNode newNode = new MyNode();
			newNode.Data = y;
			MyNode nextNode = currNode.NextNode;
			currNode.NextNode = newNode;
			newNode.NextNode = nextNode;
			this.Size++;
			return true;
		}
		
	}
	
	//return the first node whose payload match the value that we are searching for
	//return null if no node matches that value
	public MyNode Search(int x) {
		MyNode currNode = this.Head;
		while(currNode != null && currNode != null) {
			if(currNode.Data == x) {
				return currNode;
			}else {
				currNode = currNode.NextNode; //sets the currNode to the next node in list
			}
		}
		return null;
	}
	
	//empty list means to return false
	//return true if there is no node after the currNode
	//overwrite a node with null
	public boolean RemoveAfter(int x) {
		MyNode currNode = this.Search(x);
		if(currNode == null) {
			return false;
		}else {
			MyNode nextNode = currNode.NextNode;
			if(nextNode == null) {
				return true;
			}
			MyNode nextNextNode = nextNode.NextNode;
			if(nextNextNode == null) {
				currNode.NextNode = null;
				return true;
			}else {
				currNode.NextNode = nextNextNode; //linking currNode to the nextNext node
				nextNode.NextNode = null; //setting the next node of the nextNode to null
				this.Size--;
				return true;
			}
		}
	}
	
	public String Print() {
		MyNode currNode = this.Head;
		String result = "";
		while(currNode != null) {
			result += currNode.Data + " ";
			currNode = currNode.NextNode;
		}if(result.length() == 0) {
			return "There is nothing here!";
		}else {
			return result;
		}
		
	}
	
	public String PrintReverse() {
		MyNode currNode = this.Head;
		String result = "";
		while(currNode != null) {
			//this line is the only difference between this and Print()
			result = currNode.Data + " " + result; 
			currNode = currNode.NextNode;
		}if(result.length() == 0) {
			return "There is nothing here!";
		}else {
			return result;
		}
		
	}
	
	public boolean Remove(int x) {
	    MyNode currNode = this.Head;

	    // if the node that needs to be removed is the head
	    if (currNode != null && currNode.Data == x) {
	        this.Head = currNode.NextNode;
	        return true;
	    }

	    // Search for the node with the value x
	    while (currNode != null && currNode.NextNode != null) {
	        MyNode nextNode = currNode.NextNode;
	        if (nextNode.Data == x) {
	            // Found the node to remove
	            currNode.NextNode = nextNode.NextNode;
	            return true;
	        }
	        currNode = nextNode;
	    }

	    // Node with value x not found
	    return false;
	}

	
	public boolean IsEmpty() {
		MyNode currNode = this.Head;
		if(currNode != null) {
			return false;
		}else {
			return true;
		}
	}
	
	public void Append(int x) {
	    MyNode newNode = new MyNode();
	    newNode.Data = x;

	    if (this.Head == null) {
	        this.Head = newNode;
	    } else {
	        MyNode currNode = this.Head;
	        while (currNode.NextNode != null) {
	            currNode = currNode.NextNode;
	        }
	        currNode.NextNode = newNode;
	    }
	    this.Size++;
	}

	public void Prepend(int x) {
	    MyNode newNode = new MyNode();
	    newNode.Data = x;
	    newNode.NextNode = this.Head;
	    this.Head = newNode;
	    this.Size++;
	}

	
	public int GetLength() {
		int count =  0;
		MyNode currNode = this.Head;
		while(currNode.NextNode != null) {
			currNode = currNode.NextNode;
			count++;
		}
		return count + 1;
	}
	
	public void Sort() {
		MyNode smallestNode = this.Head;
		MyNode currNode = this.Head;
		MyNode nextNode = currNode.NextNode;
		ArrayList<MyNode> resultList = new ArrayList<MyNode>();
		while(nextNode != null) {
			if(nextNode.Data < smallestNode.Data) {
				smallestNode = nextNode;
			}
			currNode = currNode.NextNode;
			nextNode = currNode.NextNode;
		}
		
		resultList.add(smallestNode);
		Remove(smallestNode.Data);
		smallestNode.NextNode = null;
	}
}
