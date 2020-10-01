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
    TreeNode tr = null;
    public TreeNode searchBST(TreeNode node, int val) {
        traverse(node,val);
        return tr;
    }   
    public void traverse(TreeNode node, int val){
        if (node == null) return;
        if (node.val == val) tr = node;
        traverse(node.right, val);
        traverse(node.left, val);
    }
}
