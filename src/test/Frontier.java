package test;

public class Frontier {
	private int length;
	private Node head, current;
	
	
	public Frontier() {
		length = 0;
		current = head = null;
	}
	
	public void add(World e) {
		Node x = new Node(e);
		if (head==null) {
			head = x;
			length++;
		}
		else {
			current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(x);
			length++;
		}
	}
	
	public void add(Frontier f) {
		this.add(f.peek());
		length+=f.getLength();
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
	
	public Node getHead() {
		return head;
	}
	
}
