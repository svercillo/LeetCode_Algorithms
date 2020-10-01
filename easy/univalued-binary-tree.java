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
    int first;
    public boolean isUnivalTree(TreeNode root) {
        first = root.val;
        traverse (root);
        return first == -999999 ? false: true;
    }
    public void traverse (TreeNode node){
        if (node ==null) return;
        if (node.val != first){
             first = -999999;
        } else {
            traverse(node.right);
            traverse (node.left);
        }
        
    }
}
