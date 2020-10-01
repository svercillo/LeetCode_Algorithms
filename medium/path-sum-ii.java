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
class Obj{
    public int sum =0;
    public List<Integer> list = new ArrayList<>();
    public Obj(int n, List<Integer> l){
        sum =n;
        list = l;
    }
}
class Solution {
    public List<List<Integer>> list = new ArrayList<>();
    public Set<Obj> set = new HashSet<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        if (root == null) return list;

        List<Integer> l = new ArrayList<>();
        traverse(root, 0, l);
        Iterator<Obj> it = set.iterator();
        
        
        while (it.hasNext()) {
            Obj o = it.next();
            if ( o.sum == sum){
                this.list.add(o.list);
            } 
        }
        return this.list;
    }
    
    public void traverse (TreeNode t, int cursum, List<Integer> li){
        // for if not null
        boolean r = false;
        boolean l = false;
        
        if (t.right != null) r = true;
        if (t.left != null) l = true;
        
        List<Integer> temp = new ArrayList<>();
        for (int n :li){
            temp.add(n);
        }
        
        if (l){
            if (r){
                temp.add(t.val);
                traverse(t.right, cursum + t.val, temp);
                traverse(t.left, cursum + t.val, temp);
            } else {
                temp.add(t.val);
                traverse(t.left, cursum + t.val, temp);
            }
        } else if (r){
            temp.add(t.val);
            traverse(t.right, cursum + t.val, temp);
        } else {
            temp.add(t.val);
            // System.out.println(temp);

            Obj obj = new Obj(cursum + t.val, temp);
            // System.out.println(obj.sum);
            set.add(obj);
            
        }
    }
}
