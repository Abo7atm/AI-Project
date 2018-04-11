package test;


public class Agent {
	public static void main(String args[]) {

		/*
		 * The implementation should look like this: a search graph the consists of node
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
		
		
		// initial state
		World initialState = new World();
		
		// add initial state to frontier
		frontier.add(initialState);
		
		// space measurement, max number of node if frontier
		int spaceMeasurement = 0;
		
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
//		long startTime = System.nanoTime();
		long startTime = System.currentTimeMillis();
		
		// where the magic happens
		while(true) {
			if(spaceMeasurement < frontier.getLength()) {
				spaceMeasurement = frontier.getLength();
			}
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
		
//		long endTime   = System.nanoTime();
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		
		
		Frontier path = new Frontier();
		
		while(temp.getParent() != null) {
			path.add(temp);
			temp = temp.getParent();
		}
		
		path.add(temp);
		
		System.out.println("Solution: ");
		
		for(i=path.getLength()-1; i>=0; i--) {
			path.displayIndex(i);
		}
		
		System.out.println("Cost: " + (path.getLength()-1));
		System.out.println("Time measurement: " + (totalTime) + " ms");
		System.out.println("Space measurement: " + spaceMeasurement + " nodes");
	}
}