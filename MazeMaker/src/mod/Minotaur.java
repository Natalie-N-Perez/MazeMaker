package mod;

public class Minotaur {

	//Variables that determines the minotaur's information
	private int _row, _col;
	
	//Getter methods for the minotaur
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	//Minotaur's location
	public Minotaur(int r, int c) {
		_row = r;
		_col = c;
	}
	
}
