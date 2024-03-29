package test;

public class World {

	boolean[] state;
	Frontier path;
	int cost;
	World parent;
	
	/*
	 * initial state = {true,true,true,true,true,true,true} Indices of state[] are
	 * as follows: 0, 1, 2 = Human 3 = Big Wolf 4, 5 = Small Wolves 6 = Boat
	 */

	/*
	 * We can represent the state with an array of boolean, and since we only need
	 * to represent one side of the river only then the initial state would be
	 * currentState = {true, true, true, true, true, true, true} that is, indices
	 * 0-2 are for humans, 3 is for big wolf, (4,5) for small wolves, and the last
	 * index is for the boat
	 * 
	 * there should be another class where the algorithm is implemented.
	 */

	public World() {
		// Initial state
		state = new boolean[7];
		for (int i = 0; i < 7; i++) {
			state[i] = true;
		}
		path = new Frontier();
	}

	public World(World w) {
		this.parent = w.parent;
		state = new boolean[7];
		this.cost = w.cost; // copying cost variable
		for (int i = 0; i < 7; i++) { // copying state variable
			this.state[i] = w.state[i];
		}
	}

	public World(boolean[] state, Frontier path) {
		this.state = state;
		this.path = path;
	}

	public void printState() {
		System.out.print("{");
		for (int i = 0; i < 7; i++) {
			System.out.print(state[i] + " ");
		}
		System.out.println("}");
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
		System.out.println("------------------------------");
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
	
	public boolean isValidExpansion(int choice) {
		/*
		 * possible moves at any given state: 1) Man 2) Man, Man 3) Man, Small wolf 4)
		 * Man, Big wolf 5) Big wolf 6) Big wolf, Small
		 */
		int nbOfMenStartngSide = 0; // the number of men on the starting side after travel;
		int nbOfMenFinishingSide = 0; // the number of men on the finishing side after travel;
		int nbOfWolvesSS = 0;
		int nbOfWolvesFS = 0;

		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				if (state[i]) {
					nbOfMenStartngSide++;
				} else {
					nbOfMenFinishingSide++;
				}
			} else {
				if (state[i]) {
					nbOfWolvesSS++;
				} else {
					nbOfWolvesFS++;
				}
			}
		}

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

			// check if nbWolves > nbMen constraint gets violated.
			if (state[6]) {
				nbOfMenStartngSide--;
				nbOfMenFinishingSide++;
			} else {
				nbOfMenStartngSide++;
				nbOfMenFinishingSide--;
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

			if (state[6]) {
				nbOfMenStartngSide -= 2;
				nbOfMenFinishingSide += 2;
			} else {
				nbOfMenStartngSide += 2;
				nbOfMenFinishingSide -= 2;
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
			} else {
				return false;
			}
			if (!manWolfBoatSameSide) {
				return false;
			}

			if (state[6]) {
				nbOfMenStartngSide--;
				nbOfMenFinishingSide++;
				nbOfWolvesSS--;
				nbOfWolvesFS++;
			} else {
				nbOfMenStartngSide++;
				nbOfMenFinishingSide--;
				nbOfWolvesSS++;
				nbOfWolvesFS--;
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
			// System.out.println("##########Now checking case 4 " + (state[6]));
			if (!manWolfBoatSameSide) {
				return false;
			}

			if (state[6]) {
				nbOfMenStartngSide--;
				nbOfMenFinishingSide++;
				nbOfWolvesSS--;
				nbOfWolvesFS++;
			} else {
				nbOfMenStartngSide++;
				nbOfMenFinishingSide--;
				nbOfWolvesSS++;
				nbOfWolvesFS--;
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

			if (state[6]) {
				nbOfWolvesSS--;
				nbOfWolvesFS++;
			} else {
				nbOfWolvesSS++;
				nbOfWolvesFS--;
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

			if (state[6]) {
				nbOfWolvesSS -= 2;
				nbOfWolvesFS += 2;
			} else {
				nbOfWolvesSS += 2;
				nbOfWolvesFS -= 2;
			}

			break;

		}

		// check if the resulting state disrupts the wolf cannot out-number men
		// condition.
		// System.out.println("Choice number ("+choice+") is " + (nbOfMenStartngSide <
		// nbOfWolvesSS || nbOfMenFinishingSide < nbOfWolvesFS));
		// if (nbOfMenStartngSide < nbOfWolvesSS || nbOfMenFinishingSide < nbOfWolvesFS)
		// {
		// return false;
		// }

		if ((nbOfMenStartngSide > 0 && nbOfWolvesSS > nbOfMenStartngSide)
				|| (nbOfMenFinishingSide > 0 && nbOfWolvesFS > nbOfMenFinishingSide)) {
			return false;
		}

		return true;
	}
	
	public World expandMethod(int choice) {

		/*
		 * choices: 1) Man 2) Man, Man 3) Man, Small wolf 4) Man, Big wolf 5) Big wolf
		 * 6) Big wolf, Small wolf
		 */

		World result = new World(this);
		result.setParent(this);
		switch (choice) {

		case 1: // Man
			int manLocation = 0;
			for (int i = 0; i < 3; i++) {
				if (result.state[i] == result.state[6]) {
					manLocation = i;
				}
			}
			result.state[manLocation] = !result.state[manLocation];
			result.state[6] = !result.state[6];
			break;

		case 2: // Man, Man
			int manOneLocation = 0, manTwoLocation = 0;
			for (int i = 0; i < 3; i++) {
				if (result.state[i] == result.state[6]) {
					manOneLocation = manTwoLocation;
					manTwoLocation = i;
				}
			}
			result.state[manOneLocation] = !result.state[manOneLocation];
			result.state[manTwoLocation] = !result.state[manTwoLocation];
			result.state[6] = !result.state[6];
			break;

		case 3: // Man, Small wolf
			manLocation = 0;
			int wolfLocation = 0;
			for (int i = 0; i < 3; i++) {
				if (result.state[i] == result.state[6]) {
					manLocation = i;
				}
			}

			for (int i = 4; i < 6; i++) {
				if (result.state[i] == result.state[6]) {
					wolfLocation = i;
				}
			}
			result.state[manLocation] = !result.state[manLocation];
			result.state[wolfLocation] = !result.state[wolfLocation];
			result.state[6] = !result.state[6];

			break;

		case 4: // Man, Big Wolf
			manLocation = 0;
			for (int i = 0; i < 3; i++) {
				if (result.state[i] == result.state[6]) {
					manLocation = i;
				}
			}
			result.state[manLocation] = !result.state[manLocation];
			result.state[3] = !result.state[3];
			result.state[6] = !result.state[6];

			break;

		case 5: // Big wolf
			result.state[3] = !result.state[3];
			result.state[6] = !result.state[6];

			break;

		case 6: // Big wolf, Small wolf
			wolfLocation = 0;
			for (int i = 4; i < 6; i++) {
				if (result.state[i] == result.state[6]) {
					wolfLocation = i;
				}
			}
			result.state[wolfLocation] = !result.state[wolfLocation];
			result.state[3] = !result.state[3];
			result.state[6] = !result.state[6];

			break;

		}
		
		return result;
	}
	
	public void setParent(World w) {
		parent = w;
	}
	
	public World getParent() {
		return parent;
	}
	
	public Frontier expand() {

		Frontier result = new Frontier();
		for (int i = 1; i < 7; i++) {
			if (isValidExpansion(i)) {
				
				// expandMethod() is working fine
				// edit: not really.
				// edit2: maybe it is.

				result.add(expandMethod(i));
			}
		}
		return result;
	}

}
