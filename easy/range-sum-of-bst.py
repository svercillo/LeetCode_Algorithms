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
    int sum =0;
    int left =0;
    int right =0;
    
    public int rangeSumBST(TreeNode root, int L, int R) {        
        left = L;
        right = R;
        traverse(root);
        return sum; 
    } 
    
    public void traverse(TreeNode n){
        if (n==null) return;
        if (n.val >= left && n.val <=right)
            sum += n.val; 
        traverse(n.right);
        traverse(n.left);
    }
}
