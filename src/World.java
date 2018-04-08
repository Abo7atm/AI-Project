
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
