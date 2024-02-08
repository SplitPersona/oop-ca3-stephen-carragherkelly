import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Stephen Carragher Kelly
 *  Class Group: GD2A
 */
public class CA3_Question2
{
    static class Pair {
        int row, col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
        return arr;
    }

    /*
        Helper function to display the image
     */

    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        Stack<Pair> RowNCol = new Stack<>();

        int fillNumber = 1;
        RowNCol.push(new Pair(r, c));

        while(!RowNCol.isEmpty())
        {
            Pair current = RowNCol.pop();
            int row = current.row;
            int col = current.col;

            if(arr[row][col] == 0)
            {
                arr[row][col] = fillNumber++;
                if(row - 1 >= 0)
                {
                    RowNCol.push(new Pair(row -1 , col));
                }
                if(col + 1 < 10)
                {
                    RowNCol.push(new Pair(row, col +1));
                }
                if(row + 1 < 10)
                {
                    RowNCol.push(new Pair(row +1 , col));
                }
                if(col - 1 >= 0)
                {
                    RowNCol.push(new Pair(row, col-1));
                }
            }
        }


    }

    /*public static void start()
    {
       int[][] arr = floodFillStart();
    }*/
    public static void main(String[] args) {
        //start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Row: ");
        int row = scanner.nextInt();
        System.out.println("Enter Colume: ");
        int col = scanner.nextInt();
        int[][] arr = floodFillStart();
        fill(row,col,arr);
        display(arr);
    }

}