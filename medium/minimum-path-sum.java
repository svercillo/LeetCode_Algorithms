class Node {
    
    public int path_val =0;
    public int val; 
    
    public Node(int v){
        this.val = v;
        this.path_val = v;
    }
    public Node (){
        
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        
        Node [][] arr = new Node[grid.length][grid[0].length];
        
        for (int i =0; i< grid.length; i++){
            for (int j =0; j< grid[0].length; j++){
                if (i ==0){
                    if (j==0){
                        arr[0][0] = new Node(grid[0][0]);
                    } else { 
                        arr[i][j] = new Node(grid[i][j]);
                        arr[i][j].path_val += arr[i][j-1].path_val;
                    }
                } else if (j ==0){
                    arr[i][j] = new Node(grid[i][j]);
                    arr[i][j].path_val += arr[i-1][j].path_val;
                } else {
                    arr[i][j] = new Node(grid[i][j]);
                    int p1 = arr[i-1][j].path_val;
                    int p2 = arr[i][j-1].path_val;
                
                    arr[i][j].path_val += p1 <p2  ? p1 : p2;
                }
            }
        }
        
        return arr[grid.length-1][grid[0].length-1].path_val;
    }
}
