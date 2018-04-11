package test;

public class Frontier {

	// FIFO LinkedList

	private int length;
	private Node head, current;

	public Frontier() {
		length = 0;
		current = head = null;
	}

	public void add(World e) {
		Node x = new Node(new World(e));
		if (head == null) {
			head = x;
			length++;
		} else {
			current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(x);
			current = current.getNext();
			length++;
		}
	}

	public void add(Frontier f) {
		
		Node pointer = f.getHead();
		while (pointer != null) {
			pointer = new Node(f.serve());
			add(pointer.getData());
			pointer = f.getHead();
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

	public Node getHead() {
		return head;
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

	public void displayIndex(int i) {
		if(i > (length-1)) {
			System.out.println("Index out of bound");
		}
		else {
			current = head;
			for (int j=0; j<i; j++) {
				current = current.getNext();
			}
			current.getData().displayState();
		}
	}

}
