import java.lang.Math;

public class Problem28 {

    public static void main(String[] args) {
        int[][] grid = new int[1001][1001];
        int startingPt = (int) (Math.ceil(grid.length / 2));
        int currentx = startingPt;
        int currenty = startingPt;
        int fillGrid = 2;
        int gridDirection = 0; // 0 is right, 1 is down, 2 is left, 3 is up
        int gridDistance = 1; // how far we go in each dir
        grid[0][grid.length - 1] = grid.length * grid[0].length; // cheating so i dont have to do the last line
        grid[startingPt][startingPt] = 1;

        while (fillGrid <= grid.length * grid[0].length && gridDistance < grid.length) {
            if (gridDirection == 0) {
                for (int i = 0; i < gridDistance; i++) {
                    currentx++;
                    grid[currenty][currentx] = fillGrid;
                    fillGrid++;
                }
                gridDirection++;
            }
            if (gridDirection == 1) {
                for (int i = 0; i < gridDistance; i++) {
                    currenty++;
                    grid[currenty][currentx] = fillGrid;
                    fillGrid++;
                }
                gridDistance++;
                gridDirection++;
            }
            if (gridDirection == 2) {
                for (int i = 0; i < gridDistance; i++) {
                    currentx--;
                    grid[currenty][currentx] = fillGrid;
                    fillGrid++;
                }
                gridDirection++;
            }
            if (gridDirection == 3) {
                for (int i = 0; i < gridDistance; i++) {
                    currenty--;
                    grid[currenty][currentx] = fillGrid;
                    fillGrid++;
                }
                gridDistance++;
                gridDirection++;
            }
            if (gridDirection == 4) {
                gridDirection = 0;
            }
        }
        System.out.println(sumDiags(grid));
    }

    static int sumDiags(int[][] sumMe) {
        int sum = 0;
        int starting2 = sumMe.length - 1;
        for (int i = 0; i < sumMe.length; i++) {
            sum += sumMe[i][i];
            sum += sumMe[starting2][i];
            starting2--;
        }
        return (sum - 1);
    }

}