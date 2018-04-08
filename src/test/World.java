package test;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class World {
	
	char[] westSide = new char[6];
	char[] eastSide = new char[6];
	boolean[] state;
	// linkedlist for frontier
	// linkedlist for expended
	
	/* initial state = {true,true,true,true,true,true,true}
	 * Indices of state[] are as follows:
	 * 0, 1, 2 = Human
	 * 3 = Big Wolf
	 * 4, 5 = Small Wolves
	 * 6 = Boat
	 */

	// We can represent the state with an array of boolean, and since we only need to represent one side of the river only
	// then the initial state would be currentState = {true, true, true, true, true, true, true}
	// that is, indices 0-2 are for humans, 3 is for big wolf, (4,5) for small wolves, and the last index is for the boat
	
	// there should be another class where the algorithm is implemented.
	
	public World() {
		// Initial state
		state = new boolean[7];
		for(int i=0; i<7; i++) {
			state[i] = true;
		}
		
	}

	public void displayState() {
//		int man = 0;
//		int smallWolf = 0;
//		int bigWolf = 0;
//		int boat = 0;
//		
//		for(int i=0; i<3; i++) {
//			if(state[i]) man++;
//		}
//		
//		for(int i=4; i<6; i++) {
//			if (state[i]) smallWolf++;
//		}
//		
//		if (state[3]) bigWolf++;
//		
//		if (state[6]) {
//			System.out.println("There are " + man + "and\n" +
//					bigWolf + " big wolf and\n" + 
//					smallWolf + "small wolf and\n" +
//					"and the boat at the starting side");
//		}
//		
//		else {
//			System.out.println("There are " + (3-man) + "and\n" +
//					(1-bigWolf) + " big wolf and\n" + 
//					(2-smallWolf) + "small wolf on the ");
//		}
		
		/* According to state representation explained above
		 * if the index of the participant is true
		 * then it is on the starting side
		 * if it's false
		 * then it is on the finishing side.
		 */
		
		System.out.println("Starting Side:");
		for (int i=0; i<3; i++) {
			if(state[i]) {
				System.out.print("M ");
			}
		}
		
		if(state[3]) System.out.print("W ");
		
		for (int i=4; i<6; i++) {
			if(state[i]) {
				System.out.print("w ");
			}
		}
		
		if(state[6]) {
			System.out.print("B");
		}
		System.out.println("");
		
		System.out.println("Finshing side:");
		for (int i=0; i<3; i++) {
			if(!state[i]) {
				System.out.print("M ");
			}
		}
		
		if(!state[3]) System.out.print("W ");
		
		for (int i=4; i<6; i++) {
			if(!state[i]) {
				System.out.print("w ");
			}
		}
		
		if(!state[6]) {
			System.out.print("B");
		}
		System.out.println("");
	}
	
	public boolean goalTest() {
		boolean result=true;
		for(int i=0; i<7; i++) {
			// if one is true, that means that there is still a participant on the 
			// starting side that haven't traveled to the finishing side.
			if (state[i]) {
				result = false;
			}
		}
		return result;
	}
	
	public boolean isValidMove(/*state? indices of travelers?*/) {
		boolean[] currentState = state;
		// where is the boat?
		boolean boatLocation = currentState[6];
		return true; // just to remove the red line under the method signature
	}
	
	// the following methods are traveling methods
	
	

}
