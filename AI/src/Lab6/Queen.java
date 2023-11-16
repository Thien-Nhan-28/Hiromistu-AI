package Lab6;

public class Queen {
	private int row;
	private int column;
	private boolean conflict;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.conflict=false;
	}

	public void move() {
		// Enter your code here
		row = (row == Node.N - 1) ? 0 : (row + 1);
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// Enter your code here
		boolean re = (row == q.row || column == q.column || (Math.abs(row - q.row) == Math.abs(column - q.column))) ? true : false;
		if (re) {
			this.conflict = true;
			q.conflict = true;
		}
		return re;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
