package BoggleGame;

import java.util.ArrayList;
import java.util.List;

public class Boggle {
	private Board board;
	private BoggleSolver solver;
	
	public Boggle (String input) {
		board = buildBoard(input);
		solver = new FindWordsFromDictionarySolver();
	}
	
	private Board buildBoard (String input) {
		List<Node> nodes = new ArrayList<Node>(input.length());
		int dimension = (int) Math.sqrt(input.length());
		
		for (int i = 0; i < input.length(); i++) {
			nodes.add(buildNode(input.charAt(i),
					new Position(i / dimension, i % dimension), dimension));
		}
		
		return new Board(nodes);
	}
	
	private Node buildNode(char value, Position pos, int dimension) {
		return new Node(value, pos, getNeighbours(pos, dimension));
	}
	
	private List<Position> getNeighbours(Position pos, int dimension) {
		int[] direction = {-1, 0, 1}; // possible neighbours' position
		List<Position> neighbours = new ArrayList<Position>();
		
		for (int rowChange : direction) {
			for (int columnChange : direction) {
				Position neighbour = new Position(pos.getRow() + rowChange,
						pos.getColumn() + columnChange);
				if(!pos.equals(neighbour) && validPosition(neighbour, dimension)) {
					neighbours.add(neighbour);
				}
			}
		}
		return neighbours;
	}
	
	private boolean validPosition(Position pos, int dimension) {
		return pos.getRow() >= 0 && pos.getRow() < dimension &&
				pos.getColumn() >= 0 && pos.getColumn() < dimension;
	}
	
	public void solve() {
		List<String> foundWords = solver.solve(board);
		
		for (String word : foundWords) {
			System.out.print(word + " ");
		}
		System.out.println();
	}
}
