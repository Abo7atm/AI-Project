package test;

import java.util.LinkedList;

public class Agent {
	public static void main(String args[]) {

		/*
		 * The implementation should look like this: a search tree the consists of node
		 * the node should contain:
		 */

		// the frontier should be a LIFO of FIFO which should be implemented manually
		// instead of using
		// already existing libraries, due to some idiot asking the professor if we
		// should implement it or not.
		
		Frontier frontier = new Frontier();
		Expanded expanded = new Expanded();
		
		World e = new World(); // initial state
		frontier.add(e);
		e.displayState();
		boolean goalFound = false;
		Frontier f = new Frontier();
		f = e.expand();
		System.out.println(f.getLength());

		
//		while(!goalFound) {
//			World temp = frontier.peek();
//			Frontier t = new Frontier();
//			if(temp.goalTest()) {
//				goalFound = true;
//			}
//			else {
//				expanded.add(frontier.serve());
//				t = temp.expand();
//				frontier.add(t.peek());
//			}
//		}
		
	}
}
