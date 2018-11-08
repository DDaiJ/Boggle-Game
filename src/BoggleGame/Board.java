package BoggleGame;

import java.util.List;

public class Board {
	private final List<Node> nodes;
	
	public Board (List<Node> nodes) {
		this.nodes = nodes;
	}
	
	public List<Node> getNodes() {
		return nodes;
	}
	
	public String toString() {
		String out = "";
		for (Node node : nodes) {
			out = out + node.getValue();
		}
		return out;
	}
}
