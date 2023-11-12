package student;

public class HillClimbing_SA {
	public Node excute(Node initalState) {
		Node current = initalState, next = null;
		int T = 1000;
		while (current.getH() != 0) {
			next = current.selectNextRandomCandidate();
			int deltaE = next.getH() - current.getH();
			if (deltaE < 0) {
				current = next;

			} else {
				if (Math.exp(deltaE / T) > Math.random()) {
					current = next;
				}
			}
			T -= 1;
			if (T == 0) {
				return current;
			}
		}
		return current;
	}
}
