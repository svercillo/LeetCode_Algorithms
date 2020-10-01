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
    List<Integer> list = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        traverse(root, "");
        int sum =0;
        for (int n :list)
            sum += n;
        return sum;
    }
    public void traverse(TreeNode tn, String s){
        if (tn.right == null && tn.left == null){
            s += Integer.toString(tn.val);
            list.add(Integer.parseInt(s, 2));
            System.out.println(s);
            System.out.println(Integer.parseInt(s, 2));
            return;
        }
        System.out.println(tn);
        s += Integer.toString(tn.val);
        if (tn.right != null)
            traverse(tn.right, s);
        if (tn.left != null)
            traverse(tn.left, s);
        
    }
}
