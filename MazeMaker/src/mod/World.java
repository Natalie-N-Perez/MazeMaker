package mod;

import cont.JOP;
import view.StringMap;

public class World {
	
	//Declaring and initializing variables needed to properly execute the code
	static boolean [][] maze;
	public static int row;
	public static int cols;
	private StringMap _s;
	private Player _p;
	private Minotaur _t;
	private Maze _m;
	public static int x = 0;
	public static int p1;
	public static int p2;
	public static int m1;
	public static int m2;
	public static int e1;
	public static int e2;
	
	public World() {
		_m = new Maze();
	
		//Sets up all the information for the maze, start positions, exits, and the maze's size
	JOP.msg("Welcome to Maze Maker\nAt any point in time just enter Exit to leave\nLook, I get it, I don't want to be here either");
	String response = JOP.in("Alright, to start off, how big do you want your maze to be?\nEnter the number of rows");
	row = Integer.parseInt(response); 
	if (response.equalsIgnoreCase("exit")) {
    	System.exit(0);
        }
	String respons = JOP.in("How many columns?");
	cols = Integer.parseInt(respons);
	if (respons.equalsIgnoreCase("exit")) {
    	System.exit(0);
        }
	maze = new boolean[row][cols];
	Maze.maze  = World.maze;
	for(int i =0; i<maze.length;)
	{
		String aa = "Do you want to add any paths in row " + (i+1) +"?\nType in the column number of that path\nOne value at a time\nType in done when you want to move on to the next row\n\nI really tried to show the map but after an hour of constant errors and a headache ive given up so uh\njust plan out the maze before you make it ig\nnot rlly my problem,,,";
		String respon = JOP.in(aa);
				if (respon.equalsIgnoreCase("exit")) {
	    	System.exit(0);
	        }
		else if(respon.equalsIgnoreCase("done")) {
	    	i++;
	        }
		else {
		int x = Integer.parseInt(respon);
		maze[i][x-1] = true;
		}
		
		}
	
	for(int i =0;i < 1;) {
	String respo = JOP.in("WHat row do you want the player to start in?");
	if (respo.equalsIgnoreCase("exit")) {
    	System.exit(0);
        }
	p1 = Integer.parseInt(respo)-1;
	
	String resp = JOP.in("Que column do you want the player to start in?");
	if (resp.equalsIgnoreCase("exit")) {
    	System.exit(0);
        }
	p2 = Integer.parseInt(resp)-1;
	
	if(maze[p1][p2]==false)
	{
		JOP.msg("That's a wall,,, not a path\nenter a valid value");
	}
	else
	{
		int [] player = {p1,p2};
		Maze._plyStartLocations = player;
		i++;
	}
	}
	
	for(int i =0;i < 1;) {
	
	String res = JOP.in("What row does the minotaur start on\ntheres only one cow person, we're on a budget, get off my case smh");
	if (res.equalsIgnoreCase("exit")) {
    	System.exit(0);
        }
	m1 = Integer.parseInt(res)-1;
	
	String re = JOP.in("Column?");
	if (re.equalsIgnoreCase("exit")) {
    	System.exit(0);
        }
	m2 = Integer.parseInt(re)-1;

	
	if(maze[m1][m2]==false)
	{
		JOP.msg("That's a wall not a path\nenter the coords of a path");
	}
	else
	{
		int [] mino = {m1,m2};
		Maze._minStartLocations = mino;
		i++;
	}
	}
	
	for(int i =0;i < 1;) {
	String r = JOP.in("what row is the exit on?\ndamn i envy the exit\ni wish i could exit out of doing this assingment ughhhh");
	if (r.equalsIgnoreCase("exit")) {
    	System.exit(0);
        }
	e1 = Integer.parseInt(r)-1;
	
	String r1 = JOP.in("which col?");
	if (r1.equalsIgnoreCase("exit")) {
    	System.exit(0);
        }
	e2 = Integer.parseInt(r1)-1;
	
	if(maze[e1][e2]==false)
	{
		JOP.msg("¿Oi qué te crees?\nYou tried to make a wall into an exit?\nBr uh that's invalid");
	}
	else
	{
		int [] exit = {e1,e2};
		Maze._exit = exit;
		i++;
	}
		}
	int [] mino = {m1,m2};
	Maze._minStartLocations = mino;

	int [] player = {p1,p2};
	Maze._plyStartLocations = player;
	Maze.maze  = World.maze;
	
	_p = new Player(_m.getPlyStart()[0], _m.getPlyStart()[1]);
	_t = new Minotaur(_m.getMinStart()[0], _m.getMinStart()[1]);
	_s = new StringMap(_m, _p, _t);
	
	//Sends the user to play the maze they created
	update();
	}

	public void update() {
		boolean isPlaying = true;
		//Creates an infinite loop to play the maze
		while (isPlaying) {
			boolean on = true;
			// Get the Map
			String map = _s.generateMap();
			String msg = "Use WASD to move. What direction do you want to move?";

			while (on) {
				// Get the player move
				String move = JOP.in(map + msg);

				// move the player
				if(move == null) {

				}
				else if (getPlayerMove(move)) {
					on = false;
				}		
			}

			// check for victory
			if (victory()) {
				isPlaying = false;
				JOP.msg("You won,,, hip hip hooray\n\nalr im off to bed\nciao");
			}
			// move the minotaur
			moveMinotaur();
			
			// check for death
			if(death()) {
				isPlaying = false;
				JOP.msg("Love is dead.\n\nwait no,,,\ni meant you lol\nyou died\nand also love but thats not important here\nalr, fr this time, im done lmao");
			}

		}
	
		
	}

	// change to getPlayerMove(String s) change to private.
	private boolean getPlayerMove(String s) {

		// Moving North
		if (s.equalsIgnoreCase("W")) {
			if ((_p.getRow() - 1) >= 0 && _m.getMaze()[_p.getRow() - 1][_p.getCol()]) {
				_p.setPos(_p.getRow() - 1, _p.getCol());
				return true;
			} else {
				return false;
			}
		}
		// Moving South
		if (s.equalsIgnoreCase("S")) {
			if ((_p.getRow() + 1) < _m.getMaze().length && _m.getMaze()[_p.getRow() + 1][_p.getCol()]) {
				_p.setPos(_p.getRow() + 1, _p.getCol());
				return true;
			} else {
				return false;
			}
		}
		// Moving East
		if (s.equalsIgnoreCase("D")) {
			if ((_p.getCol() + 1) < _m.getMaze()[0].length && _m.getMaze()[_p.getRow()][_p.getCol() + 1]) {
				_p.setPos(_p.getRow(), _p.getCol() + 1);
				return true;
			} else {
				return false;
			}
		}
		// Moving West
		if (s.equalsIgnoreCase("A")) {
			if ((_p.getCol() - 1) >= 0 && _m.getMaze()[_p.getRow()][_p.getCol() - 1]) {
				_p.setPos(_p.getRow(), _p.getCol() - 1);
				return true;
			} else {
				return false;
			}
		}


		return false;
		}
	
	//Method to get the minotaur's move
	private void moveMinotaur() {
		int rDist = _p.getRow() - _t.getRow();
		int cDist = _p.getCol() - _t.getCol();
		int r = _t.getRow();
		int c = _t.getCol();
		
		// Minotaur moving North
		if(rDist < 0 && _m.getMaze()[r - 1][c]) {
			_t.setPos(r - 1, c);
		}

		// Minotaur moving South.
		if(rDist > 0 && _m.getMaze()[r +1][c]) {
			_t.setPos(r + 1, c);
		}
		// Minotaur moving East
		if(cDist > 0 && _m.getMaze()[r][c + 1]) {
			_t.setPos(r, c + 1);
		}
		// Minotuar moving west
		if(cDist < 0 && _m.getMaze()[r][c - 1]) {
			_t.setPos(r, c - 1);
		}
	}
	
	//Method to check if the player has died
	public boolean death() {
		if(_t.getRow() == _p.getRow() &&
				_t.getCol() == _p.getCol())
		{
			return true;
		}
		return false;
	}

	//Method to see if the player has reached the exit
	public boolean victory() {
		if (_p.getRow() == _m.getExit()[0] && _p.getCol() == _m.getExit()[1])
			return true;
		return false;
	}

}

