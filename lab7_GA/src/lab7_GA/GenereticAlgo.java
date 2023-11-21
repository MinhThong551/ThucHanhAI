package lab7_GA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GenereticAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		Node x, y, child = new Node();
		List<Node> newPopulation = new ArrayList<>();
		initPopulation();
		int k = 0;
		while (k++ < MAX_ITERATIONS) {
			for (int i = 0; i < POP_SIZE; i++) {
				x = getParentByRandomSelection();
				y = getParentByRandomSelection();
				child = reproduce(x, y);
				if (rd.nextDouble() < MUTATION_RATE)
					mutate(child);

				if (child.getH() == 0)
					return child;
				newPopulation.add(child);
			}
			population = newPopulation;

		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		int randomIndex = rd.nextInt(Node.N);
		int randomQueen = rd.nextInt(Node.N);

		node.setRow(randomQueen, node.getRow(randomIndex));
	}

	public Node reproduce(Node x, Node y) {
		// Enter your code here

		Node child = new Node();
		child.generateBoard();
		int c = rd.nextInt(Node.N);
		for (int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		for (int i = c + 1; i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
		return child;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection(int k) {
		// Enter your code here
		k = rd.nextInt(5);
		int randomIndex = rd.nextInt(POP_SIZE);
		List<Node> tournamentParticipants = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			tournamentParticipants.add(population.get(i));

		}
		Collections.sort(tournamentParticipants);

		return tournamentParticipants.get(0);
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here

		int randomIndex = rd.nextInt(POP_SIZE);
		Node node = population.get(randomIndex);
		return node;

	}

}
