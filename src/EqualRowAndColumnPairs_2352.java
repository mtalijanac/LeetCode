import java.util.Arrays;

public class EqualRowAndColumnPairs_2352 {

    public int equalPairs(int[][] grid) {
        int[][] gridT = transpose(grid);
        
        int pairCount = 0;
        for (int i = 0; i < grid.length; i++) {
        	int[] a = grid[i];
        	
        	for (int j = 0; j < gridT.length; j++) {
        		int[] b = gridT[j];
        		
        		boolean equals = Arrays.equals(a, b);
        		if (equals) pairCount++;
        	}
        }
        
        return pairCount;
    }
    
    
    public static int[][] transpose(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a new matrix with transposed dimensions
        int[][] result = new int[cols][rows];

        // Perform the transposition
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = grid[i][j];
            }
        }

        return result;
    }
    
}
