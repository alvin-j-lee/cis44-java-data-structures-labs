/*
 * MazeSolver.java
 * A recursive maze solving program using backtracking.

 * The maze is represented as a 2D char array containing:
 *  'S' = Start position
 *  'F' = Finish position
 *  ' ' = Open path
 *  '#' = Wall
 *
 * The solver searches for a path from the start to the finish
 * using recursion and Depth-First Search. As it explores the maze,
 * it marks visited path cells with '.' to avoid revisiting them.
 * If a path leads to a dead end, the algorithm backtracks by
 * restoring the cell back to an open space.
 *
 * Methods:
 *  MazeSolver(char[][] maze)
 *      Constructor that initializes the maze.
 *
 *  printMaze()
 *      Prints the current state of the maze.
 *
 *  solve()
 *      Public wrapper that finds the start position 'S' and begins
 *      the recursive solving process.
 *      Returns true if a path from S to F exists.
 *
 *  solve(int row, int col)
 *      Recursive backtracking method that explores the maze.
 *      Parameters:
 *          row - current row being explored
 *          col - current column being explored
 *      Returns true if this position leads to the finish.
 */

public class MazeSolver {

    private char[][] maze;

    /*
     * Constructor
     * @param maze A 2D char array representing the maze layout
     */
    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /*
     * Prints the maze grid to the console.
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /*
     * Finds the start position 'S' and begins the recursive search.
     * @return true if a path from S to F exists, false otherwise
     */
    public boolean solve() {

        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {

                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }

            }
        }

        if (startRow != -1) {
            return solve(startRow, startCol);
        }

        return false;
    }

    /*
     * Recursive method that explores the maze using backtracking.
     
     * @param row Current row position
     * @param col Current column position
     * @return true if this position leads to the finish 'F'
     */
    private boolean solve(int row, int col) {

        // Base case: check bounds
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false;
        }

        // Base case: wall or visited cell
        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }

        // Base case: finish found
        if (maze[row][col] == 'F') {
            return true;
        }

        // Mark current cell as part of the path (except start)
        if (maze[row][col] != 'S') {
            maze[row][col] = '.';
        }

        // Explore neighbors: North, East, South, West
        if (solve(row - 1, col)) return true;
        if (solve(row, col + 1)) return true;
        if (solve(row + 1, col)) return true;
        if (solve(row, col - 1)) return true;

        // Backtrack if no direction worked
        if (maze[row][col] != 'S') {
            maze[row][col] = ' ';
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] mazeToSolve = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', '#', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver = new MazeSolver(mazeToSolve);

        System.out.println("Original Maze:");
        solver.printMaze();

        if (solver.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }

        solver.printMaze();
    }
}