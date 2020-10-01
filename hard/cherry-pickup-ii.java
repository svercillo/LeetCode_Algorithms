class Solution {
    public int cherryPickup(int[][] grid) {
        int [][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        int n = grid.length;
        int c = grid[0].length;
        for (int i=0; i<c; i++){
            for (int j=0; j<c; j++){
                if(i==j){
                    dp[n-1][i][j] = grid[n-1][i];
                } else {
                    dp[n-1][i][j] = grid[n-1][i] + grid[n-1][j];
                }
            }
        }
        for (int r=grid.length-2; r>=0; r--){
            for (int i=0; i<c; i++){
                for (int j=0; j<c; j++){
                    int max = -1;
                    for (int y=-1; y<2; y ++){
                        int ii  = i;
                        switch(y){
                            case-1:
                                ii--;
                                if (ii < 0) continue;     
                                for (int w=-1; w<2; w ++){
                                    int jj = j;
                                    switch(w){
                                        case-1:
                                            jj--;
                                            if (jj <0) continue;
                                            if (i == j){
                                                int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            }
                                        case 0:
                                           if (i == j){
                                                int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            }
                                        case 1: 
                                            jj++;
                                            if (jj>=c) continue;
                                            if (i == j){
                                            int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            }
                                    }
                                }
                            case 0:
                                for (int w=-1; w<2; w ++){
                                    int jj = j;
                                    switch(w){
                                        case-1:
                                            jj--;
                                            if (jj <0) continue;
                                            if (i == j){
                                                int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            }
                                        case 0:
                                           if (i == j){
                                                int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            }
                                        case 1: 
                                            jj++;
                                            if (jj>=c) continue;
                                            if (i == j){
                                            int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            }
                                    }
                                }
                            case 1:
                                ii++;
                                if (ii >= c) continue;
                                for (int w=-1; w<2; w ++){
                                    int jj = j;
                                    switch(w){
                                        case-1:
                                            jj--;
                                            if (jj <0) continue;
                                            if (i == j){
                                                int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                    max = val > max ? val : max;
                                            }
                                        case 0:
                                           if (i == j){
                                                int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            }
                                        case 1: 
                                            jj++;
                                            if (jj>=c) continue;
                                            if (i == j){
                                            int val = (grid[r][i]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            } else {
                                                int val = (grid[r][i] + grid[r][j]+ dp[r+1][ii][jj]);
                                                max = val > max ? val : max;
                                            }
                                    }
                                }
                        }
                    }
                    dp[r][i][j] = max;
                }
            }
        }
        return dp[0][0][c-1];
    }
}
