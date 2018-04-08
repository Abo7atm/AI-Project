package test;

import java.util.LinkedList;

public class Agent {
	public static void main(String args[]) {
	
 /*
  * The implementation should look like this:
  * a search tree the consists of node
  * the node should contain: 
  */
		
	// the frontier should be a LIFO of FIFO which should be implemented manually instead of using 
	// already existing libraries, due to some idiot asking the professor if we should implement it or not.
		
	LinkedList<World> frontier = new LinkedList<>();
	LinkedList<World> expanded = new LinkedList<>();
	
	World initialState = new World();
	
	frontier.add(initialState);
	
	}
}
