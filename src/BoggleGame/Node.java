package BoggleGame;

import java.util.List;

public class Node {
	// Node is a single square on a board which contains a character
	// in it.
	
	private final char value;
	private final Position position;
	private final List<Position> neighbours;
	
	public Node (char value, Position position, List<Position> neighbours) {
		this.value = value;
		this.position = position;
		this.neighbours = neighbours;
	}
	
	public char getValue() {
		return value;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public List<Position> getNeighbours() {
		return neighbours;
	}
}
