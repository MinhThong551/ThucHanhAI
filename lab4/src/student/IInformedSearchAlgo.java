package student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public interface IInformedSearchAlgo {
	public Node execute(Node root, String goal);
	
	public Node execute(Node root, String start, String goal);

	public boolean isAdmissibleH(Node tree, String goal);
}
