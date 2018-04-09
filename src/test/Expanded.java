package test;

public class Expanded {
	private int length;
	private Node head, current;

	public Expanded() {
		length = 0;
		current = head = null;
	}

	public boolean add(World e) {
		Node x = new Node(e);
		if (head == null) {
			head = x;
			length++;
			return true;
		} else {
			current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(x);
			length++;
			return true;
		}
	}
	
	public int getLength() {
		return length;
	}
}
