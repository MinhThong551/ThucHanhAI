package student;

public class HillClimbing {
	public Node excute(Node enitalState) {
		Node current = enitalState;
		Node neighbor = null;
		while (true) {
			neighbor = current.getBestCandidate();
			if (current.getH() > neighbor.getH()) {
				current = neighbor;
			} else {
				return current;
			}

		}	
	}
}
