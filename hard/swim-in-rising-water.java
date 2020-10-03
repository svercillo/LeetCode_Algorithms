
class Pair {

    static final Pair origin = new Pair(0,0);
    public Pair (int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getKey(){
        return this.a;
    }

    public int getValue(){
        return this.b;
    }

    int a;
    int b;

    // @Override
    public boolean equals (Pair  p){
        if (p == this) return true;

        if (this.a == p.a && this.b == p.b){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return "(" + this.a + " , " + this.b + ")";
    }

}



class Node implements Comparable<Node> {
    public Node(int x, Node prev, Pair coords){
        
        this.prev = prev;
        this.value = x;
        if (prev != null){
            this.max = Math.max(value, prev.max);
        } else {
            this.max = value;
        }
        this.coords = coords;
        this.visited = false;
    }

    public Node() {
        this.max = Integer.MIN_VALUE;
        this.coords = new Pair(-1, -1);
        this.value = -1;
        this.visited = false;
        this.prev = null;
    }
    
    public void visit(){
        visited = true;
    }

    public void setQueueInd(int ind){
        this.queueind = ind;
    }
    
    public final static Node smallest = new Node(Integer.MIN_VALUE, null, null);
    public Node prev = null;
    public int value =-1;
    public int max =-1;
    public Pair coords= null;
    public int queueind = -1;
    public boolean visited = false;
    
    // private int queueind;
    

    /* Operator Overriders */
    @Override
    public int compareTo(Node b){
        int diff;
        diff = this.max -b.max;
        // if (diff <= 0){
        //     // swimming anyways
        //     diff = -(((Integer) this.coords.getKey() * (Integer) this.coords.getKey() + 
        //                 (Integer) this.coords.getValue() * (Integer) this.coords.getValue())
        //             - ((Integer) b.coords.getKey() * (Integer) b.coords.getKey() + 
        //                 (Integer) b.coords.getValue() * (Integer) b.coords.getValue()));
        // }
        return diff;
    }
    
    @Override
    public String toString(){
        return "Node: m: " + max +  " v: " + value + " c: " + coords + " p: " + prev.coords;
    }
}

class priorityqueue {

    public priorityqueue(){
        this.list = new ArrayList<Node>();
    }

    public void add(Node t){
        
        this.list.add(t);
    }

    public Node poll(){
        if (this.list.size()==0) return null;

        Node smallest = Node.smallest;
        int smallestind = -1;
        for (int i=0; i<this.list.size(); i++){
            if ( this.list.get(i).compareTo(smallest) < 0 ){
                smallest = this.list.get(i);
                smallestind = i;
            }
        }

        this.list.remove(smallestind);

        return smallest;
    }

    public int lastind (){
        return this.list.size()-1;
    }

    public void remove (int ind ){
        for(int i=ind; i<this.list.size()-1; i++){
            Node t = this.list.get(i+1);
            this.list.set(i+1, this.list.get(i));
            this.list.set(i, t);

            this.list.get(i).setQueueInd(i);
            this.list.get(i+1).setQueueInd(i+1);
        }
        this.list.remove(this.list.size()-1);
    }
    
    public List<Node> list;
    
    public void print(){
        System.out.println(this.list);
    }
}
class Solution {

    public int swimInWater(int[][] grid) {
        int i = grid.length -1;
        int j = grid[0].length -1;
        
        // min priority queue
        priorityqueue pq = new priorityqueue();
        Map<String, Node> map = new HashMap<>();
        
        Node minus1th = new Node();
        Node first = new Node(grid[i][j], minus1th, new Pair(i, j));

        
        pq.add(first);    

        map.put(String.valueOf(new Pair(i,j)), first);
        

        while (pq.list.size() != 0){
            
            Node top = pq.poll();
            System.out.println(top.coords + " "  +  top.value );
            // if ( top.value == 19 ) return 1;
            
            map.get(String.valueOf(top.coords)).visit();
            i = (Integer) top.coords.getKey();
            j = (Integer) top.coords.getValue();

            // up
            try {
                Pair p = new Pair(i-1, j);
                int v = grid[i-1][j];
                if (map.get(String.valueOf(p)) == null){                           
                    Node n = new Node(v, top, p);
                    pq.add(n);
                    n.setQueueInd(pq.lastind());
                    map.put(String.valueOf(p), n);    
                } else {
                    if ( !map.get(String.valueOf(p)).visited){

                        // delete previous node and place new node
                        Node n = new Node(v, top, p);
                        if (n.max < map.get(String.valueOf(p)).max){
                            pq.remove(map.get(String.valueOf(p)).queueind);
                            map.put(String.valueOf(p),n);
                            pq.add(n);
                            n.setQueueInd(pq.lastind());
                        }
                    }
                }
                if (p.equals(Pair.origin)) break;
            } catch (Exception ex){
                // pass
            }

            // down
            try {
                Pair p = new Pair(i+1, j);
                int v = grid[i+1][j];
                if (map.get(String.valueOf(p)) == null){                           
                Node n = new Node(v, top, p);
                    pq.add(n);
                    n.setQueueInd(pq.lastind());
                    map.put(String.valueOf(p), n);    
                } else {
                    if (!map.get(String.valueOf(p)).visited){

                        // delete previous node and place new node
                        Node n = new Node(v, top, p);
                        if (n.max < map.get(String.valueOf(p)).max){
                            pq.remove(map.get(String.valueOf(p)).queueind);
                            map.put(String.valueOf(p),n);
                            pq.add(n);
                            n.setQueueInd(pq.lastind());
                        }
                    }
                }
                if (p.equals(Pair.origin)) break;
            } catch (Exception ex){
                // pass
            }

            
            // right
            try {
                Pair p = new Pair(i, j+1);
                int v = grid[i][j+1];
                if (map.get(String.valueOf(p)) == null){                           
                Node n = new Node(v, top, p);
                    pq.add(n);
                    n.setQueueInd(pq.lastind());
                    map.put(String.valueOf(p), n);    
                } else {
                    if (map.get(String.valueOf(p)).visited){

                        // delete previous node and place new node
                        Node n = new Node(v, top, p);
                        if (n.max < map.get(String.valueOf(p)).max){
                            pq.remove(map.get(String.valueOf(p)).queueind);
                            map.put(String.valueOf(p),n);
                            pq.add(n);
                            n.setQueueInd(pq.lastind());
                        }
                    }
                }
                if (p.equals(Pair.origin)) break;
            } catch (Exception ex){
                // pass
            }

            // left 
            try {
                Pair p = new Pair(i, j-1);
                int v = grid[i][j-1];
                if (map.get(String.valueOf(p)) == null){                           
                Node n = new Node(v, top, p);
                    pq.add(n);
                    n.setQueueInd(pq.lastind());
                    map.put(String.valueOf(p), n);    
                } else {
                    if (map.get(String.valueOf(p)).visited){
                        
                        // delete previous node and place new node
                        Node n = new Node(v, top, p);
                        if (n.max < map.get(String.valueOf(p)).max){
                            pq.remove(map.get(String.valueOf(p)).queueind);
                            map.put(String.valueOf(p),n);
                            pq.add(n);
                            n.setQueueInd(pq.lastind());
                        }
                    }
                }
                if (p.equals(Pair.origin)) break;
            } catch (Exception ex){
                // pass
            }

        }
        // System.out.println(map);
        return map.get(String.valueOf(new Pair(0,0))).max;
    }
}





