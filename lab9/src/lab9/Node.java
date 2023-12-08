package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public Integer set(int index, Integer element) {
		return this.data.set(index, element);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> child = new ArrayList<Node>();
		Collections.sort(data, DESCOMPARATOR);
		for (int i = 0; i < data.size(); i++) {
			int current = data.get(i);
			for (int j = 1; j <= current / 2; j++) {
				if (j != current - j) {
					Node n = new Node();
					n.add(current - j);
					n.add(j);
					for (int k = 0; k < data.size(); k++) {
						if (k != i) {
							n.add(data.get(k));
						}
					}
					if (!child.contains(n))
						child.add(n);
				}
			} // System.out.println(child);
		}
		return child;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		Collections.sort(data, DESCOMPARATOR);
		return data.get(0) <= 2;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return Objects.equals(data, other.data);
	}

}
