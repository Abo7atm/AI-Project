package test;

import java.util.LinkedList;

public class World {

	boolean[] state;
	LinkedList<World> path;
	int cost;

	/*
	 * initial state = {true,true,true,true,true,true,true} Indices of state[] are
	 * as follows: 0, 1, 2 = Human 3 = Big Wolf 4, 5 = Small Wolves 6 = Boat
	 */

	// We can represent the state with an array of boolean, and since we only need
	// to represent one side of the river only
	// then the initial state would be currentState = {true, true, true, true, true,
	// true, true}
	// that is, indices 0-2 are for humans, 3 is for big wolf, (4,5) for small
	// wolves, and the last index is for the boat

	// there should be another class where the algorithm is implemented.

	public World() {
		// Initial state
		state = new boolean[7];
		for (int i = 0; i < 7; i++) {
			state[i] = true;
		}
		path = new LinkedList<>();
	}

	public World(boolean[] state, LinkedList<World> path) {
		this.state = state;
		this.path = path;
	}

	public void displayState() {

		/*
		 * According to state representation explained above if the index of the
		 * participant is true then it is on the starting side if it's false then it is
		 * on the finishing side.
		 */

		System.out.println("Starting Side:");
		for (int i = 0; i < 3; i++) {
			if (state[i]) {
				System.out.print("M ");
			}
		}

		if (state[3])
			System.out.print("W ");

		for (int i = 4; i < 6; i++) {
			if (state[i]) {
				System.out.print("w ");
			}
		}

		if (state[6]) {
			System.out.print("B");
		}
		System.out.println("");

		System.out.println("Finshing side:");
		for (int i = 0; i < 3; i++) {
			if (!state[i]) {
				System.out.print("M ");
			}
		}

		if (!state[3])
			System.out.print("W ");

		for (int i = 4; i < 6; i++) {
			if (!state[i]) {
				System.out.print("w ");
			}
		}

		if (!state[6]) {
			System.out.print("B");
		}
		System.out.println("");
	}

	public boolean goalTest() {
		boolean result = true;
		for (int i = 0; i < 7; i++) {
			/*
			 * if one is true, that means that there is still a participant on the starting
			 * side that haven't traveled to the finishing side.
			 */
			if (state[i]) {
				result = false;
			}
		}
		return result;
	}

	public boolean isValidExpansion(World w, int choice) {
		/*
		 * possible moves at any given state: 1) Man 2) Man, Man 3) Man, Small wolf 4)
		 * Man, Big wolf 5) Big wolf 6) Big wolf, Small
		 */
		switch (choice) {
		case 1: // move man
			// if there's a boat and a man on the same side, manBoatSameSide = true
			boolean manBoatSameSide = false;
			for (int i = 0; i < 3; i++) {
				if (state[i] == state[6]) {
					manBoatSameSide = true;
				}
			}
			if (!manBoatSameSide) {
				return false;
			}
			break;

		case 2: // move man, man
			// if two men and boat are on same side
			boolean twoMenBoatSameSide = false;
			manBoatSameSide = false;
			for (int i = 0; i < 3; i++) {
				if (state[i] == state[6]) {
					/*
					 * this if statement should confirm that there are two men at the same side, I
					 * think it's obvious that is, if there has been a man on the same side of the
					 * boat, when an other man is found, the manBoatSameSide should be true,
					 * therefore entering the block the switched the variable twoMenSameSide to true
					 */
					if (manBoatSameSide) {
						twoMenBoatSameSide = true;
					}
					manBoatSameSide = true;
				}
			}
			if (!twoMenBoatSameSide) {
				return false;
			}
			break;

		case 3: // move man, small wolf
			manBoatSameSide = false;
			boolean manWolfBoatSameSide = false;
			for (int i = 0; i < 3; i++) {
				if (state[i] == state[6]) {
					manBoatSameSide = true;
				}
			}
			if (manBoatSameSide) {
				for (int i = 4; i < 6; i++) {
					if (state[i] == state[6]) {
						manWolfBoatSameSide = true;
					}
				}
			}
			if (!manWolfBoatSameSide) {
				return false;
			}
			break;

		case 4: // move man, big wolf
			manBoatSameSide = false;
			manWolfBoatSameSide = false;
			for (int i = 0; i < 3; i++) {
				if (state[i] == state[6]) {
					manBoatSameSide = true;
				}
			}
			if (manBoatSameSide) {
				if (state[3] == state[6]) {
					manWolfBoatSameSide = true;
				}
			}
			if (!manWolfBoatSameSide) {
				return false;
			}
			break;

		case 5: // move big wolf
			// boolean wolfBoatSameSide = false;
			// if(state[3] == state[6]) {
			// wolfBoatSameSide = true;
			// }
			// if(!wolfBoatSameSide) {
			// return false;
			// }
			if (state[3] != state[6]) { // does the same this as the commented section above
				return false;
			}
			break;

		case 6: // move big wolf, small wolf
			boolean wolfWolfBoatSameSide = false;
			if (state[3] == state[6]) {
				for (int i = 4; i < 6; i++) {
					if (state[i] == state[6]) {
						wolfWolfBoatSameSide = true;
					}
				}
			}
			if (!wolfWolfBoatSameSide) {
				return false;
			}
			break;

		}
		
		// check if the resulting state disrupts the wolf cannot out-number men condition.
		

		return true;
	}

	public LinkedList<World> expand() {
		LinkedList<World> result = new LinkedList<>();

		return result;
	}

	// the following methods are traveling methods

}
