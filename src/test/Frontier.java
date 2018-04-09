package test;

public class Frontier {
	private int length;
	private Node head, current;
	
	
	public Frontier() {
		length = 0;
		current = head = null;
	}
	
	public boolean add(Node e) {
		if (head==null) {
			head = e;
			length++;
			return true;
		}
		else {
			current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(e);
			length++;
			return true;
		}
	}
	
	public World serve() {
		World result = head.getData();
		head = head.getNext();
		length--;
		return result;
	}
	
	public int getLength() {
		return length;
	}
	
}
