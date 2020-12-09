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
    
    boolean isValid = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        recurse(p, q);
        
        return isValid;
        
    }
    
    public void recurse(TreeNode n1, TreeNode n2){
        if (!isValid || n1 == null && n2 == null){
            return;
        }
        
        if (n1 == null && n2 != null  || n1!= null && n2 == null  || n1.val != n2.val){
            isValid= false;
            return;
        }
            
        recurse(n1.right, n2.right);
        recurse(n1.left, n2.left);
    }
}
