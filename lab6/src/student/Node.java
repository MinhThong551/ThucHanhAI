package student;


	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.List;
	import java.util.Random;

	public class Node {
		public static final int N = 8;
		private Queen[] state;

		public Node() {
			// generateBoard();
			state = new Queen[N];
		}

		public Node(Queen[] state) {
			this.state = new Queen[N];
			for (int i = 0; i < state.length; i++) {
				this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
			}
		}

		public Node(Node n) {
			this.state = new Queen[N];
			for (int i = 0; i < N; i++) {
				Queen qi = n.state[i];
				this.state[i] = new Queen(qi.getRow(), qi.getColumn());
			}
		}

		public void generateBoard() {
			Random random = new Random();
			for (int i = 0; i < N; i++) {
				state[i] = new Queen(random.nextInt(N), i);
			}
		}

		public int getH() {
			int heuristic = 0;
			// Enter your code here
			for (int i = 0; i < state.length-1; i++) {
				for (int j = 1; j < state.length; j++) {
					if(state[i].isConflict(state[j]) ) {
						heuristic++;
					}
				}
			}
			return heuristic;
		}

		public List<Node> generateAllCandidates() {
			List<Node> result = new ArrayList<Node>();
			for (int i = 0; i < state.length; i++) {
				Node copy = new Node(this.state);
				copy.state[i].move();
				result.add(copy);
			}
		
			return result; 
		}

		public Node selectNextRandomCandidate() {
			// Enter your code here
			Node re = new Node(state);
			Random r = new Random();
			int i = r.nextInt(N);
			int row = r.nextInt(N);
			re.state[i].setRow(row);
			return re;
		
		}
		

		public void displayBoard() {
			int[][] board = new int[N][N];
			// set queen position on the board
			for (int i = 0; i < N; i++) {
				board[state[i].getRow()][state[i].getColumn()] = 1;
			}
			// print board
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						System.out.print("Q" + " ");
					} else {
						System.out.print("-" + " ");
					}
				}
				System.out.println();
			}
		}

		public Node getBestCandidate() {
			List<Node> list=generateAllCandidates();
			Node res=list.get(0);
			for (int i=1; i<list.size();i++) {
				if (res.getH()>list.get(i).getH()) 
					res=list.get(i);
			}
			return res;
		}
		
	
}
