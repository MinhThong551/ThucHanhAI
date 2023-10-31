package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class GreedyBFSAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					frontier.add(child);
//					child.setH(current.getH() + edge.getWeight());
//				} else {
//					frontier.add(current);
//					child.setParent(current);
//					double newH = current.getH() + edge.getWeight();
//					if (child.getH() > newH)
//						child.setH(newH);
	}
			}

			
		
		}
		return null;

	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdmissibleH(Node tree, String goal) {
		// TODO Auto-generated method stub
		return false;
	}

}
