class Two {
    public int row =0;
    public int col =0;
    public char last = 'r';
    
    public void right(){
        col++;
        last = 'r';
    }
    public void down(){
        row++;
        last ='d';
    }
    public void left(){
        col--;;
        last  = 'l';
    }
    public void up(){
        row--;
        last = 'u';
    }

}

class Solution {
    public int[][] generateMatrix(int n) {
        int [][] arr = new int [n][n];
        Two pair = new Two();        
        arr[0][0] = 1;
        for (int i =2; i<n*n+1; i++){
            if (pair.last == 'r'){
                if(pair.col < n-1 && arr[pair.row][pair.col+1] ==0){
                    arr[pair.row][pair.col+1] =i;
                    pair.right();
                } else {
                    // go down
                    arr[pair.row+1][pair.col] =i;
                    pair.down();
                }
            }
            else if (pair.last == 'd'){
                if(pair.row < n-1 && arr[pair.row+1][pair.col] ==0){
                    arr[pair.row+1][pair.col] =i;
                    pair.down();
                } else {
                    // go left
                    arr[pair.row][pair.col-1] =i;
                    pair.left();
                }
            }
            else if (pair.last == 'l'){
                if(pair.col > 0 && arr[pair.row][pair.col-1] ==0){
                    arr[pair.row][pair.col-1] =i;
                    pair.left();
                } else {
                    // go up
                    arr[pair.row-1][pair.col] =i;
                    pair.up();
                }
            }
            else if (pair.last == 'u'){
                if(pair.row > 0 && arr[pair.row-1][pair.col] ==0){
                    arr[pair.row-1][pair.col] =i;
                    pair.up();
                } else {
                    // go right
                    arr[pair.row][pair.col+1] =i;
                    pair.right();
                }
            } 
            
        } 
        return arr;

    }
}
