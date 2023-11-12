package student;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		Node node = new Node();
		node.displayBoard();
		System.out.println("\nHill climbing:");
		HillClimbing algo= new HillClimbing();
		algo.excute(node).displayBoard();
		
	}
}
