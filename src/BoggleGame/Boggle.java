package BoggleGame;

import java.util.List;

public class Boggle {
	private Board board;
	private BoggleSolver solver;
	
	public Boggle (String input) {
		//board = 
	}
	
	public Board buildBoard (String input) {
		// TODO
		return null;
	}
	
	public void solve() {
		List<String> foundWords = solver.solve(board);
		
		for (String word : foundWords) {
			System.out.print(word + " ");
		}
		
		//System.out
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
