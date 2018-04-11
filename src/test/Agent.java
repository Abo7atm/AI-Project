package test;


public class Agent {
	public static void main(String args[]) {

		/*
		 * The implementation should look like this: a search tree the consists of node
		 * the node should contain:
		 */

		
		Frontier frontier = new Frontier();
		Explored explored = new Explored();

		/*
		 * The process is as follows:
		 * 1) initial state created
		 * 2) check if state has been explored
		 * 3-a) if has not been explored, add to frontier
		 * 3-b) if has been explored, skip or delete or whatever
		 * 4) pop from frontier
		 * 5) check if state is goal
		 * 6-a) if goal, return solution
		 * 6-b) if not goal, expand
		 * 7) pop from expand list, go to 2)
		 */
		
		// ------------------------------------------------
//		boolean[] one = {true, true, true, true, true };
//		boolean[] two = {true, true, true, true, true };
//		System.out.println("The two boolean arrays are equivilant: " + Arrays.equals(one, two));
		// ------------------------------------------------
		
		
		// initial state
		World initialState = new World();
		
		// add initial state to frontier
		frontier.add(initialState);
		
		// counter for debugging
		int i=0;
		
		// variable to store popped state
		World temp;
		
		// frontier to store expansion
		Frontier expanded;
		
		// variable for iterating through explored list
		World checker;
		
		// for debugging
		/* there was something here */
		
		// where the magic happens
		while(true) {
			// popping from frontier
			temp = frontier.serve();
			
			// check if popped state is goal
			if (temp.goalTest()) {
				frontier.add(temp);
				break;
			}
			
			// if not goal state expand, then add to explored
			expanded = temp.expand();
			
			// check if haven't been explored
			if(!explored.hasBeenExplored(temp)) {
				explored.add(temp);
			}
			
			// check for explored states before adding to frontier
			while(!expanded.isEmpty()) {
				checker = expanded.serve();
				if(!explored.hasBeenExplored(checker)) {
					frontier.add(checker);
				}
			}
			i++;
		} // end of while loop
		temp.path.displayAll();
	}
}