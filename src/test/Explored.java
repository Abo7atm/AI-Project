package test;

public class Explored {
	private int length;
	private Node head, current;

	public Explored() {
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
	
	public boolean hasBeenExplored(Node n) {
		current = head;
		boolean result = false;
		
		while(current != null) {
			for(int i=0; i<7; i++) {
				if(current.getData().state[i] == n.getData().state[i]) {
					result = true;
					break;
				}
			}
			current = current.getNext();
		}
		
		result = false;
		return result;
	}
	
	public int getLength() {
		return length;
	}
}
