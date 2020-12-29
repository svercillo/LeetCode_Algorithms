class Node{
    public boolean red = true;
    public int val;
    public Node(int v){
        val = v;
    }
    
    @Override
    public String toString() { 
        return val +":" + red; 
    } 
}
class Solution {
    public Map<Integer, Node> map = new HashMap<>();
    public Map<Node, Set<Node>> graph = new HashMap<>();
    public Set<Integer> marked = new HashSet<>();
    
    public boolean res = true;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int [][] d = dislikes;

        for (int i =0; i<d.length; i++){    
            if (map.get(d[i][0]) == null){
                Node n = new Node(d[i][0]);
                map.put(d[i][0], n);
                graph.put(n, new HashSet<>());    
            }
            if (map.get(d[i][1]) == null){
                Node n = new Node(d[i][1]);
                map.put(d[i][1], n);
                graph.put(n, new HashSet<>());    
            }
            
            Node n1 = map.get(d[i][0]);
            Node n2 = map.get(d[i][1]);
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        
        for ( int i =1; i<=N; i++){
            if (map.get(i) != null){
                dfs(map.get(i));
            }
            
        }
        return res;
    }
    public void dfs (Node n){
        marked.add(n.val);
        for (Node r : graph.get(n)){
            if(!marked.contains(r.val)){
                r.red = !n.red;
                dfs(r);   
            } else if (r.red == n.red){
                res = false;
            }
            r.red = !n.red;
        }
    }
}


