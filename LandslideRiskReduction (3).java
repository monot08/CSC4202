package algo;
import java.util.Arrays;

public class LandslideRiskReduction {
    
    // Function to find the minimum risk path
    public static int findMinRisk(int[][] terrain) {
        int rows = terrain.length;
        int cols = terrain[0].length;
        
        // Create a dp array to store the minimum risk at each cell
        int[][] dp = new int[rows][cols];
        
        // Initialize the dp array with maximum possible values
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Start from the top-left corner
        dp[0][0] = terrain[0][0];
        
        // Fill the dp array with the minimum risk values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + terrain[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + terrain[i][j]);
                }
            }
        }
        
        // Return the minimum risk to reach the bottom-right corner
        return dp[rows-1][cols-1];
    }
    
    public static void main(String[] args) {
        // Example terrain grid
        int[][] terrain = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        
        // Find and print the minimum risk
        int minRisk = findMinRisk(terrain);
        System.out.println("The minimum risk path has a risk of: " + minRisk);
    }
}
