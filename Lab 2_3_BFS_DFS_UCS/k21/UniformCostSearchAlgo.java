package k21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.naming.ldap.SortControl;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
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
					child.setPathCost(current.getPathCost() + edge.getWeight());
				} else {
					frontier.add(current);
					child.setParent(current);
					double newPathCost = current.getPathCost() + edge.getWeight();
					if (child.getPathCost() > newPathCost)
						child.setPathCost(newPathCost);
				}
			}

		}

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		boolean started = false;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
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
				current.setPathCost(0);
			}
			List<Edge> children = current.getChildren();
			for (Edge edge : children) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					frontier.add(child);
					child.setPathCost(current.getPathCost() + edge.getWeight());
				} else {
					frontier.add(current);
					child.setParent(current);
					double newPathCost = current.getPathCost() + edge.getWeight();
					if (child.getPathCost() > newPathCost)
						child.setPathCost(newPathCost);
				}
			}
			if (current.getLabel().equals(goal) && started) {
				return current;

			}

		}
		return null;
	}

	public Node execute(Node root, String goal, int DepthLimited) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		int state = 1;
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal))
				return current;
			explored.add(current);
			if (current.getDepth() < DepthLimited) {
				List<Node> children = current.getChildrenNodes();
			
					Collections.sort(children , new Comparator<Node>() {

						public int compare(Node node1,Node node2) {
						
							return node2.getLabel().compareTo(node1.getLabel());
						}		
						
					});
					
			
				for (Node child : children) {
					if (!frontier.contains(child) && !explored.contains(child)) {
						child.setParent(current);
						frontier.add(child);
						child.setDepth(current.getDepth() + 1);

					}
				}
			}
		}

		return null;
	}
}
