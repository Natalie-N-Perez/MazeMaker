package view;

import mod.Maze;
import mod.Minotaur;
import mod.Player;

public class StringMap {

	//Declares and initializes the icons for the maze
	private final String _wall = "◼";
	private final String _path = "◻";
	private final String _ply = " ☺";
	private final String _min = "む";
	private final String _exit = " X";
	private final String _space = "   ";
	private Maze _maze;
	private Player _plyr;
	private Minotaur _mint;
	
	//Creates a map constructor
	public StringMap(Maze m, Player p, Minotaur t) {
		_maze = m;
		_plyr = p;
		_mint = t;
	}
	
	//Generates the board, changing the icon to represent the player and minotaur's positions
	public String generateMap() {
		 String map = "";
		 for(int r = 0; r < Maze.maze.length; r++) {
			 for(int c = 0; c < Maze.maze[0].length; c++) {
				 if(_plyr.getRow() == r && _plyr.getCol() == c) {
					 map += _ply + _space;
				 }
				 else if(_mint.getRow() == r && _mint.getCol() == c) {
					 map += _min + _space; 
				 }
				 else if(_maze.getExit()[0] == r && _maze.getExit()[1] == c) {
					 map += _exit + _space; 
				 }
				 else if(_maze.getMaze()[r][c]) {
					 map += _path + _space;
				 }
				 else {
					map += _wall + _space; 
				 }
			 }
			 map += "\n";
		 }
		 map += "\n";
		 
		 return map;
	}
	
}