import java.util.Stack;

/**
 *  Name: Stephen Carragher Kelly
 *  Class Group: GD2A
 */

/*
Direction enum used to indicate direction.
 */
enum DIRECTION {NORTH, SOUTH,EAST,WEST};

public class CA3_Question9
{
    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++)
        {
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }
    public void solve(int[][] maze, int startx, int starty, int exitx, int exity)
    {
        Stack<int[]> path = new Stack<>();
        path.push(new int[]{startx, starty});
        while(!path.isEmpty())
        {
            int[] currentposition = path.pop();
            int x = currentposition[0];
            int y = currentposition[1];

            if(x==exitx && y==exity)
            {
                System.out.println("You have found the exist");
                return;
            }

            for(DIRECTION dir: DIRECTION.values())
            {
                int newx = x;
                int newy = y;
                switch(dir)
                {
                    case NORTH:
                        newx--;
                        break;
                    case SOUTH:
                        newx++;
                        break;
                    case EAST:
                        newy++;
                        break;
                    case WEST:
                        newy--;
                        break;
                }

                if(newx >= 0 && newx < maze.length && newy >= 0 && newy < maze[0].length && maze[newx][newy] == 0)
                {
                    path.push(new int[]{newx, newy});
                    maze[newx][newy] = 2;
                }

            }
        }

        System.out.println("No path their");

    }

    public static void main(String[] args)
    {
        int[][] maze = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        CA3_Question9 mazeSolver = new CA3_Question9();
        mazeSolver.solve(maze, 1, 1, 3, 3);
        display(maze);
    }

}
