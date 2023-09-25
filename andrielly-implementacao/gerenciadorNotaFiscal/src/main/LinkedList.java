package main;

public class LinkedList {
	
	Node head;
	
	public Node getHead() {
		return head;
	}
	
	
	class Node {
		
		Node next;
		String data;
		
		Node (String data) {
			this.data =  data;
		}
		
	}

}
