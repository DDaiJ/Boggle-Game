package BoggleGame;

public class Position {
	// define row and column of a value on the board
	
	private final int row, column;
	
	public Position (int row, int column) {
		this.row = row;
		this.column = column;
	}
	d
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof Position) { 
			// check if obj is a Position object
			Position pos = (Position) obj;
			if (pos.getRow() == row && pos.getColumn() == column) {
				return true;
			}
		}
		
		return false;
	}
}
