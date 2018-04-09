package test;

public class Frontier {
	private int length;
	private Node head, current;
	
	
	public Frontier() {
		length = 0;
		current = head = null;
	}
	
	public boolean add(World e) {
		Node x = new Node(e);
		if (head==null) {
			head = x;
			length++;
			return true;
		}
		else {
			current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(x);
			length++;
			return true;
		}
	}
	
	public World peek() {
		return head.getData();
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
