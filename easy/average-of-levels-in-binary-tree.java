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
    List<Pair<Double, Integer>> list = new ArrayList<>();
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> l = new ArrayList<>();
        traverse(root, 0);
        for ( Pair<Double, Integer> p : list){
            l.add(p.getKey());
        }
        System.out.println(list);
        return l;
    }
    
    public void traverse(TreeNode n, int level){
        if (n == null) return;
        if (level >= list.size()){
            Pair<Double, Integer> p = new Pair<Double, Integer>((double)n.val, 1);
            list.add(p);
        } else {
            Double d = list.get(level).getKey();
            d *= list.get(level).getValue();
            d +=n.val;
            d /= list.get(level).getValue()+1;
            Pair<Double, Integer> p = new Pair<>(d, list.get(level).getValue()+1);
            list.set(level, p);
        }
        traverse(n.right, level+1);
        traverse(n.left, level+1);
    }
}
