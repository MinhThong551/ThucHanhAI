package student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;



public class AStarSearchAlgo implements IInformedSearchAlgo {

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
					child.setG(current.getG() + edge.getWeight());
					child.setParent(current);
					frontier.add(child);
					
				} else if (frontier.contains(child) && child.getG() > current.getG() + edge.getWeight()) {
					frontier.remove(child);
					child.setParent(current);
					child.setG(current.getG() + edge.getWeight());
					frontier.add(child);

				}
			}
			

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			if (current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);
				current.setG(0);
			}
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {

					child.setParent(current);
					frontier.add(child);
					child.setG(current.getG() + edge.getWeight());
				} else if (frontier.contains(child) && child.getG() > current.getG() + edge.getWeight()) {
					frontier.remove(child);
					child.setParent(current);
					child.setG(current.getG() + edge.getWeight());
					frontier.add(child);
					
				}
			}
			if (current.getLabel().equals(goal) && started) {
				return current;

			}
		}
		return null;
	}

	@Override
	public boolean isAdmissibleH(Node tree, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<Node>();
		Set<Node> explored = new HashSet<Node>();
		boolean result = true;

		frontier.offer(tree);

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			Node nodeRe = execute(current, goal);
			if (nodeRe == null) {
				return false;
			}

			if (current.getH() > nodeRe.getG())
				return false;

			for (Node child : current.getChildrenNodes())
				if (!explored.contains(child) && !frontier.contains(child)) {
					child.setParent(null);
					child.setG(0);
					result = result && isAdmissibleH(child, goal);
					if (result==false)
						return result;
				}
		}
		return true;

	}

}
