package BoggleGame;

import java.util.ArrayList;
import java.util.List;

public class Boggle {
	private Board board;
	private BoggleSolver solver;
	
	public Boggle (String input) {
		board = buildBoard(input);
	}
	
	public Board buildBoard (String input) {
		List<Node> nodes = new ArrayList<Node>(input.length());
		int dimension = (int) Math.sqrt(input.length());
		
		for (int i = 0; i < input.length(); i++) {
			nodes.add(buildNode(input.charAt(i),
					new Position(i / dimension, i % dimension), dimension));
		}
		
		return new Board(nodes);
	}
	
	public Node buildNode(char value, Position pos, int dimension) {
		return new Node(value, pos, getNeighbours(pos, dimension));
	}
	
	public List<Position> getNeighbours(Position pos, int dimension) {
		int[] direction = {-1, 0, 1}; // possible neighbours' position
		List<Position> neighbours = new ArrayList<Position>();
		
		for (int rowChange : direction) {
			for (int columnChange : direction) {
				/*
				int row = pos.getRow() + rowChange;
				int column = pos.getColumn() + columnChange;
				if (row <= dimension && column <= dimension) {
					neighbours.add(new Position(row, column));
				}
				*/
				Position neighbour = new Position(pos.getRow() + rowChange,
						pos.getColumn() + columnChange);
				if(!pos.equals(neighbour) && validPosition(neighbour, dimension)) {
					neighbours.add(neighbour);
				}
			}
		}
		return neighbours;
	}
	
	public boolean validPosition(Position pos, int dimension) {
		if (pos.getRow() >= 0 && pos.getRow() < dimension &&
				pos.getColumn() >= 0 && pos.getColumn() <= dimension) {
			return true;
		}
		return false;
	}
	
	public void solve() {
		List<String> foundWords = solver.solve(board);
		
		for (String word : foundWords) {
			System.out.print(word + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
