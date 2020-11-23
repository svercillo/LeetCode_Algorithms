class Coords{
    public int i; 
    public int j;

    public Coords(int i, int j){
        this.i = i; 
        this.j = j; 
    }
    public Coords(){}
}


class  Node{
    public static int[][] goal = {{1,2,3}, {4,5,0}};
    public int[][] arr; 
    public int height;
    public Coords zero = new Coords();

    public Node(int [][] arr, int height, Coords z){
        this.height = height;
        this.arr = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[0].length; j++)
                this.arr[i][j] = arr[i][j];
        zero = z;
    }
    public Node(int [][] arr, int height, Coords z, int dir){
        this.height = height;
        this.arr = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[0].length; j++)
                this.arr[i][j] = arr[i][j];
        
        int i = z.i;
        int j = z.j;
        
        switch (dir) {
            case 0:
                int t = this.arr[i][j];
                this.arr[i][j] = this.arr[i-1][j];
                this.arr[i-1][j] = t;
                zero.i = i-1;
                zero.j = j;
                break;
            
            case 1:
                t = this.arr[i][j];
                this.arr[i][j] = this.arr[i][j+1];
                this.arr[i][j+1] = t;
                zero.i = i;
                zero.j = j+1;
                break;
            case 2:
                t = this.arr[i][j];
                this.arr[i][j] = this.arr[i+1][j];
                this.arr[i+1][j] = t;
                zero.i = i+1;
                zero.j = j;
                break;
            case 3: 
                t = this.arr[i][j];
                this.arr[i][j] = this.arr[i][j-1];
                this.arr[i][j-1] = t;
                zero.i = i;
                zero.j = j-1;
                break;
        }
    }

    public boolean checkDone(){
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[0].length; j++)
                if (arr[i][j] != goal[i][j])
                    return false;
        return true;   
    }

}

class Solution {
    
    class Array{
    
        public int[][] arr;

        public Array (int[][] array){
            arr =array;
        }

        
        @Override
		public int hashCode() {
        
		}

        @Override
		public boolean equals(Object obj) {
            Array array = (Array) obj;
            for (int i=0; i< arr.length; i++)
                for (int j=0; j< arr[0].length; j++)
                    if (arr[i][j] != array.arr[i][j])
                        return false;
            return true;        
        }
    }
    
    public int[][] goal = {{1,2,3}, {4,5,0}};
    public Set<Array> used = new HashSet<>();
    public Queue<Node> queue = new LinkedList<>();

    public int slidingPuzzle(int[][] board) {
        used.add(new Array(board));
        queue.add(new Node(board, 0, new Coords(1,2)));
        int count = 0;
        while(!queue.isEmpty()){
            Node n = queue.poll();

            for (int w = 0; w< 4; w++){
                int i = n.zero.i;
                int j = n.zero.j;

                if ((w ==0 && i ==0) || (w==1 && j ==2) ||
                    (w==2 && i==1) || (w == 3 && j ==0)) continue; // invalid moves
                
                Node next = new Node(n.arr, n.height+1, n.zero, w);  // for int 0,1 ,2 ,3  u, r, d, l respectively 
                
                
                if (used.contains(new Array(next.arr))){
                    continue;
                } else {
                    count ++;
                    if (count >= 820) break; 

                    if (next.checkDone()){
                        for (Array ar : used){
                            System.out.println(Arrays.deepToString(ar.arr));            
                        }
                        return next.height;
                    }
                    queue.add(next);
                    used.add(new Array(next.arr));
                }
            }
        }
        
        
                        for (Array ar : used){
                            System.out.println(Arrays.deepToString(ar.arr));            
                        }
        return -1;
    }
}
