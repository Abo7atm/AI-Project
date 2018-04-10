package test;

import java.util.LinkedList;

public class Agent {
	public static void main(String args[]) {

		/*
		 * The implementation should look like this: a search tree the consists of node
		 * the node should contain:
		 */

		
		Frontier frontier = new Frontier();
		Expanded expanded = new Expanded();
		
		World e = new World(); // initial state
		frontier.add(e);
		frontier.add(e.expand());
		System.out.println("###");
		
		
		
		boolean goalFound = false;
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
