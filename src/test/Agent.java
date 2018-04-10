package test;


public class Agent {
	public static void main(String args[]) {

		/*
		 * The implementation should look like this: a search tree the consists of node
		 * the node should contain:
		 */

		
		Frontier frontier = new Frontier();
		Explored explored = new Explored();

		World initialState = new World(); // initial state
		frontier.add(initialState); // add initial state to frontier;

		/*
		 * I see the process as follows:
		 * 1) initial state created,
		 * 2) check if state has been expanded
		 * 3-a) if has not been explored, add to frontier
		 * 3-b) if has been explored, skip or delete or whatever.
		 * 4) pop from frontier
		 * 5) check if state is goal
		 * 6-a) if goal, return solution
		 * 6-b) if not goal, expand then go to 2). 
		 */
		int i = 0;
		boolean goalFound = false;
		World temp, goalState = null;
		Frontier expanded = new Frontier();
		Node pointer;
		
		while (!goalFound) {
			temp = frontier.serve();
			if(temp.goalTest()) {
				goalFound = true;
				goalState = temp;
				break;
			}
			expanded = temp.expand();
			explored.add(temp);
			pointer = expanded.getHead();
			while(pointer != null) {
				System.out.println(i);
				if (!explored.hasBeenExplored(pointer)) {
					frontier.add(pointer.getData());
				}
				pointer = pointer.getNext();
			}
			i++;
		}
				
	}
}









































