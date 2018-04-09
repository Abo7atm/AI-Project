package test;

public class Node {
	private World data;
	private Node next;
	
	public Node() {
		data = null;
		next = null;
	}
	
	public Node(World d) {
		data = d;
		next = null;
	}
	
	public Node(World d, Node n) {
		data = d;
		next = n;
	}
	
	public World getData() {
		return data;
	}
	
	public void setData(World d) {
		data = d;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
}
