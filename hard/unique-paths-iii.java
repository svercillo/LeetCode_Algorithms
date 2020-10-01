class Node {
    public Map<Pair, Integer> set = new TreeMap<>();
    public Pair last;
    
    public Node(Map<Pair, Integer> s, Pair l){
        set = s;
        last =l;
    }
    
    @Override 
    public String toString(){
        return last + ":     " + set; 
    }
}

class Solution {
    public int COUNT =1;
    // public Set<Set<Pair>> paths = new HashSet<>();
    public Stack<Node> stack = new Stack<>();
    public int numways =0;
    public int[][] grid;
    
    public int uniquePathsIII(int[][] grid){
        int starti =-1;
        int startj = -1;
        this.grid = grid;
        for (int i =0; i<grid.length; i++){
            for (int j =0; j<grid[0].length; j++){
                if (grid[i][j] == 0){
                    COUNT ++;   
                } else if ( grid[i][j] ==1){
                    starti = i;
                    startj = j;
                    
                    COUNT++;    // do I need this line
                }
            }
        }
        
        Map<Pair, Integer> s = new HashMap<>();
        s.put(new Pair(starti, startj), 0);
        Node node = new Node(s, new Pair(starti, startj));
        traverse(node);

        return numways;
    }
    
    public void traverse(Node path){
        List<Pair> valid = new ArrayList<>();
        int i = (int) path.last.getKey();
        int j = (int) path.last.getValue();

        // up
        if (i-1 >= 0){
            if (this.grid[i-1][j] ==0 || this.grid[i-1][j]  == 2){
                Pair next = new Pair(i-1, j);
                if (path.set.get(next) == null) valid.add(next);
            }
        }
        
        // down
        if (i+1< this.grid.length){
            if (this.grid[i+1][j] ==0 || this.grid[i+1][j]  == 2){
                Pair next = new Pair(i+1, j);
                if (path.set.get(next) == null) valid.add(next);
            }
        }
        
        // left 
        if (j-1 >= 0){
            if (this.grid[i][j-1] ==0 || this.grid[i][j-1]  == 2){
                Pair next = new Pair(i, j-1);
                if (path.set.get(next) == null) valid.add(next);
            }
        }
            
        // right
        if (j +1< this.grid[0].length){
            if (this.grid[i][j+1] ==0 || this.grid[i][j+1]  == 2){
                Pair next = new Pair (i, j+1);
                if (path.set.get(next) == null) valid.add(next);
            }
        }

        for (Pair p : valid){
            // System.out.println(p);
            if (this.grid[(int) p.getKey()][ (int) p.getValue()] == 2 ){
                if (path.set.size() +1  == COUNT){
                    numways ++;
                    System.out.println(path.set);
                    return;
                } else if (path.set.size() > COUNT){
                    return;
                }
            }else {
                
                Map<Pair, Integer> m = new HashMap<>();

                for (Pair key : path.set.keySet()){
                    m.put(key, path.set.get(key));
                }
                m.put(p, path.set.get(path.last)+1);
                Node n = new Node(m, p);    
                this.traverse(n);

            }
        }
    }
}
