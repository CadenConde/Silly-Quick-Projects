import java.io.File;
import java.util.Scanner;

public class Solve83 {
    public static void main(String[] args) {

        //initialize matrix from .txt file
        int[][] matrix = new int[80][80];
        try { //import text file
            File file = new File("0083_matrix.txt");
            Scanner inputScanner = new Scanner(file);
            int row = 0;
            while (inputScanner.hasNext()) {
                String rawLine = inputScanner.nextLine();
                String[] line = rawLine.split(",");
                for (int i = 0; i < line.length; i++) {
                    matrix[row][i] = Integer.parseInt(line[i]);
                }
                row++;
            }
            inputScanner.close();
        } catch (Exception e) {
            System.out.println("Text File Error!!!!");
        }

        //array of distance to each cell
        int[][] distance = new int[80][80];

        //initialize ever cell to infinity
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 80; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        //initialize starting distance
        distance[0][0] = matrix[0][0];

        //var to check if we have finished
        boolean found = false;

        //implementation of dijkstra's algorithm
        while (!found) {
            int[] closestIndex = closestUnvisited(distance); //get closest node

            int x = closestIndex[0];
            int y = closestIndex[1];
            if (x == 79 && y == 79) {
                //last node is found!
                found = true;
                System.out.println(distance[x][y]);
            }

            //check adjacent cells, one case for each direction to avoid out of index error
            if (x > 0) {
                if (distance[x - 1][y] != -1
                        && distance[x - 1][y] > distance[x][y] + matrix[x - 1][y]) {
                    distance[x - 1][y] = distance[x][y] + matrix[x - 1][y];
                }
            }
            if (x < 79) {
                if ((distance[x + 1][y] != -1)
                        && (distance[x + 1][y] > distance[x][y] + matrix[x + 1][y])) {
                    distance[x + 1][y] = distance[x][y] + matrix[x + 1][y];
                }
            }
            if (y > 0) {
                if (distance[x][y - 1] != -1
                        && distance[x][y - 1] > distance[x][y] + matrix[x][y - 1]) {
                    distance[x][y - 1] = distance[x][y] + matrix[x][y - 1];
                }
            }
            if (y < 79) {
                if (distance[x][y + 1] != -1
                        && distance[x][y + 1] > distance[x][y] + matrix[x][y + 1]) {
                    distance[x][y + 1] = distance[x][y] + matrix[x][y + 1];
                }
            }
            distance[x][y] = -1; //set self as visited
        }
    }

    //looks at the whole array and finds the closest unvisited cell
    static int[] closestUnvisited(int[][] distance) {
        int[] bestNode = new int[2];
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 80; i++) {
            for (int j = 0; j < 80; j++) {
                if (distance[i][j] < Integer.MAX_VALUE && distance[i][j] != -1) {
                    if (distance[i][j] < minValue) {
                        bestNode[0] = i;
                        bestNode[1] = j;
                        minValue = distance[i][j];
                    }
                }
            }
        }
        return bestNode;
    }
}
