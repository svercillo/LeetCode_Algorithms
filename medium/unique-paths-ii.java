class Solution {
    public int uniquePathsWithObstacles(int[][] map) {
        int[][] grid = new int[map.length][map[0].length];
        if (map[0][0] == 1){
            return 0;
        }
        grid[0][0] = 1;
        
        
        for (int i =0; i<grid.length; i++){
            if (map[i][0] == 1){
                grid[i][0] = 0;
            } else {
                try{
                    grid[i][0] = grid[i-1][0];    
                } catch (Exception ex){ // pass 
                }
                
            }
        }

        
        for (int i =0; i<grid[0].length; i++){
            if (map[0][i] == 1){
                grid[0][i] = 0;
            } else {
                
                try{
                    grid[0][i] = grid[0][i-1];    
                } catch (Exception ex){ // pass 
                }
            }
        }
        
        for ( int i =0; i<grid.length; i++){
            for (int j =0; j<grid[0].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println(" ");
        }
                        
        for (int i =1; i<grid.length; i++){
            for (int j=1; j<grid[0].length; j++){
                if (map[i][j]  == 1){
                    grid[i][j] =0;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[grid.length-1][grid[0].length -1 ];
    }
}
