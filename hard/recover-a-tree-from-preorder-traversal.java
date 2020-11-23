/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    
        
    private void print(Object line) {
        System.out.println(line);
    }
    
    private Map<Integer, List<Integer>> map = new TreeMap<>(); // height and list of values
    // private List<List<Integer>> list = new ArrayList<>();
    public TreeNode recoverFromPreorder(String S) {
        Queue<Pair> queue = new LinkedList<>();
        
        String dash ="";
        String value = "";
        
        boolean multiple = false;
        for (int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if (c == '-'){
                multiple = true;
                if (!value.equals("")){
                    int v = Integer.parseInt(value);
                    int h = dash.length();
                                                            
                    queue.add(new Pair(v,h));
                    
                    dash ="";
                    value = "";
                }
                dash += c;
            } else{
                value += c;
            }
        }
        int v = Integer.parseInt(value);  
        int h = dash.length();
        
        if(!multiple){
            return new TreeNode(v);    
        }

        
        queue.add(new Pair(v,h));
        
        Map<Integer, TreeNode> map = new HashMap<>();    
        TreeNode first_node = new TreeNode((int) (queue.poll().getKey()));
        
        map.put(0, first_node);
        
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            TreeNode tn = map.get((int) p.getValue()-1);
            TreeNode current = new TreeNode((int) p.getKey());
            
            if (tn.left == null){
                tn.left = current;
            } else {
                tn.right = current;
            }
            map.put((int) p.getValue(), current);
        }
        
        
        return map.get(0);
    }
    


}
