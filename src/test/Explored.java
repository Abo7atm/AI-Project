package test;

import java.util.Arrays;

public class Explored {
	private int length;
	private Node head, current;

	public Explored() {
		length = 0;
		current = head = null;
	}

	public void add(World e) {
		Node x = new Node(e);
		if (head == null) {
			head = x;
			length++;
		} else {
			current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(x);
			length++;
		}
	}
	
	public World serve() {
		
		World result = head.getData();
		head = head.getNext();
		length--;
		return result;
	}
	
	public boolean hasBeenExplored(World w) {
		//Node n = new Node(w);
		current = head;
		boolean flag = false;
		if(this.isEmpty()) {
			flag = false;
		}
		while(current != null) {
			if(Arrays.equals(current.getData().state, w.state)) {
				flag = true;
			}
			current = current.getNext();
		}
		return flag;
	}
	
	public int getLength() {
		return length;
	}

	public void displayAll() {
		current = head;
		while (current != null) {
			current.getData().displayState();
			current = current.getNext();
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void displayAll2() {
		current = head;
		while(current != null) {
			current.getData().printState();
			current = current.getNext();
		}
	}
	
}
