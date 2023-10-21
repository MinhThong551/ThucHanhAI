package k21;

public class test {
	static void print(Node node) {
		for (String node1 : NodeUtils.printPath(node)) {
			
			System.out.print(node1 +" ");
		}
		System.out.println();
		
		System.out.println(node);
	}
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A"); Node nodeB = new Node("B");
		Node nodeC = new Node("C"); Node nodeD = new Node("D");
		Node nodeE = new Node("E"); Node nodeF = new Node("F");
		Node nodeG = new Node("G"); Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
	ISearchAlgo algo1 = new UniformCostSearchAlgo();
	Node result = algo1.execute(nodeS, "G");
	print(result);
	Node result1 = algo1.execute(nodeS, "C","G");
	print(result1);
	Node result2 = algo1.execute(nodeS, "G", 3);
	print(result2);
//	for (String temp : NodeUtils.printPath(result1)) {
//		System.out.println(temp);
//	}
//	System.out.println(result );

	
	
	}
}
