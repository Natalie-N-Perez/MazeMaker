package mod;

public class Player {
	
	//Variables that determines the Players's information
	private int _row, _col;
	private boolean _isAlive;
	
	//Getter methods for the player
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	//PLayer's location and status
	public Player(int r, int c) {
		_row = r;
		_col = c;
		_isAlive = true;
	}
	
	//Methods to get if the player is alive
	public boolean isAlive() { return _isAlive; }
	public void kill() { _isAlive = false; }
}
