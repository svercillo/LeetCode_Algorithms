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
    // level, value
    public Map<Integer, Integer> map = new HashMap<>();    
    public int level;
    public List<Integer> largestValues(TreeNode root) {
        traverse(root);
        
        List<Integer> li = new ArrayList<>();
        
        
            
        
        for (int n : map.keySet()){
            li.add(map.get(n));
        }
        
        return li;
    }
    public void traverse (TreeNode t){
        if (t == null) return;
        level++;
        if (map.get(level) == null){
            map.put(level, t.val);
        } else if (t.val > map.get(level)){
            map.put(level, t.val);
        }
        int d = level;
        traverse(t.right);
        level = d;
        traverse(t.left);
    }
}
