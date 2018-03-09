package org.hackerrank.mahmood;

public class LinkedList {
	private Node head;
	
	public LinkedList() {
		
	}
	public LinkedList(int [] array) {
		this.head=this.new Node(array[0]);
		Node curr=this.head;
		for (int i = 1; i < array.length; i++) {
			int j = array[i];
			curr.next(this.new Node(j));
			curr=curr.next();
		}
	}
	
	public void insert(int after,int value) {
		Node curr=this.head;
		while(curr!=null) {
			if(curr.value()!=after) {
				curr=curr.next();
			}else {
				Node newNode= this.new Node(value);
				newNode.next(curr.next());
				curr.next(newNode);
				break;
			}
		}
		
	}
	public void delete(int value) {
		Node curr=this.head;
		while(curr!=null) {
			if(curr.next().value()!=value) {
				curr=curr.next();
			}else {
				curr.next(curr.next().next());
				break;
			}
		}
	}
	public void reverse() {
		Node curr=this.head;
		Node prev=null;
		while (curr!=null) {
			Node next=curr.next();
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		this.head=prev;
		//return this.head;
	}
	@Override
	public String toString() {
		StringBuilder  sb= new StringBuilder();
		Node curr=this.head;
		while(curr!=null) {
			sb.append(curr.value()+"-->");
			curr=curr.next();
		}
		sb.append("NULL");
		return sb.toString();
	}
	public static void main(String[] args) {
		LinkedList list= new LinkedList();
		list.head=list.new Node(10);
		list.head.next(list.new Node(20))
		.next(list.new Node(30))
		.next(list.new Node(40))
		.next(list.new Node(50));
		
		System.out.println(list);
		list.insert(30,35);
		System.out.println(list);
		list.delete(35);
		System.out.println(list);
		list.reverse();
		System.out.println(list);

		
	}
	
	class Node{
		
		private Node next=null;
		private Node prev=null;
		private int value;
		private int length;
		
		public Node(int value) {
			this.value=value;
		}
		public Node next() {
			return this.next;
		}
		
		public Node next(Node next) {
			if(next!=null) {
				this.next=next;
				this.length++;
			}
			return this.next;
		}
		
		public Node prev() {
			return this.prev;
		}
		
		public Node prev(Node prev) {
			this.prev=prev;
			return this.prev;
		}
		
		public int value() {
			return this.value;
		}
		
		
		
	}

}
