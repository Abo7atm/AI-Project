package test;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frontier frontier = new Frontier();
		Explored explored = new Explored();

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
		
		// testing hasBeenExplored() manually
		System.out.println("----------- first iteration -----------");
		temp = frontier.serve();
		if(temp.goalTest()) {
			System.out.println("Goal has been found!");
		}
		explored.add(temp);
		
		// expansion
		expanded = temp.expand();
		System.out.println("Expansion List:");
		expanded.displayAll2();
		
		// add unexplored expanded stated to frontier
		while(!expanded.isEmpty()) {
			// variable to store state popped from expanded
			checker = expanded.serve();
			if (!explored.hasBeenExplored(checker)) {
				frontier.add(checker);
				System.out.println("Checked has beed added!");
			}
		}
		
		System.out.println("Frontier: ");
		frontier.displayAll2();
		System.out.println("Explored: ");
		explored.displayAll2();
		
		// correct states has been added to frontier
		// correct states has been added to explored
		
		System.out.println("----------- second iteration -----------");
		temp = frontier.serve();
		if(temp.goalTest()) {
			System.out.println("Goal has been found!");
		}
		explored.add(temp);
		System.out.println("temp path: ");
		temp.path.displayAll();
		//expansion
		expanded = temp.expand();
		System.out.println("Expansion List:");
		expanded.displayAll2();
		
		// add unexplored expanded states to frontier
		while(!expanded.isEmpty()) {
			// variable to store state popped from expanded
			checker = expanded.serve();
			if (!explored.hasBeenExplored(checker)) {
				frontier.add(checker);
				System.out.println("Checker has been added!");
			}
		}
		System.out.println("Frontier: ");
		frontier.displayAll2();
		System.out.println("Explored: ");
		explored.displayAll2();
		// correct states has been added to frontier
		// correct states has been added to explored
		
		System.out.println("----------- third iteration -----------");
		temp = frontier.serve();
		if(temp.goalTest()) {
			System.out.println("Goal has been found!");
		}
		explored.add(temp);
		
		//expansion
		expanded = temp.expand();
		
		// add unexplored expanded states to frontier
		while(!expanded.isEmpty()) {
			// variable to store state popped from expanded
			checker = expanded.serve();
			if (!explored.hasBeenExplored(checker)) {
				frontier.add(checker);
				System.out.println("Checker has been added!");
			}
		}
//		frontier.displayAll2();
		
	} // end of main

}
