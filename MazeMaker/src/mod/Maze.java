package mod;

public class Maze {
	
	//Creates a maze
	public static boolean maze [][] = World.maze;

	//Sets the player's and minotaur's start locations, as well as the exit's location
		public static int[] _plyStartLocations = {World.p1,World.p2};
		public static int[] _minStartLocations = {World.m1,World.m2};
		public static int[] _exit = {World.e1,World.e2};
		
		
		//Getter methods for the maze
		public boolean[][] getMaze() { return maze; }
		public int[] getPlyStart() { return _plyStartLocations; }
		public int[] getMinStart() { return _minStartLocations; }
		public int[] getExit() { return _exit; }
		
	}
