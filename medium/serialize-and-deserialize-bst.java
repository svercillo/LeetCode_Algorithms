/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    
    public String serial;
    public String serialize(TreeNode root) {
        serial = "";
        traverse(root);
        System.out.println(serial);
        return serial;
    }
    
    public void traverse(TreeNode root){
        if (root == null){
            return;   
        }
        
        serial += Integer.toString(root.val);
        serial += '-';
        
        if (root.left == null){
            serial += 'w';
            serial += '-';
        } else {
            serial += Integer.toString(root.left.val);   
            serial += '-';
        }
        if (root.right == null){
            serial += 'w';
            serial += '-';
        } else {
            serial += Integer.toString(root.right.val);
            serial += '-';
        }
        serial += '&';
        traverse(root.left);
        traverse(root.right);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] substrings = data.split("&");
        TreeNode root = null;
        Map<Integer, TreeNode> map = new HashMap<>();

        for (int i =0; i<substrings.length; i++){
            String [] sub = substrings[i].split("-");
            // System.out.println(Arrays.toString(sub));
            TreeNode tn;
            if (root == null){
                if(sub[0].length() == 0){
                    return null;
                }
                root  = new TreeNode(Integer.parseInt(sub[0]));   
                tn = root;
            } else {
                tn= map.get(Integer.parseInt(sub[0]));
            }   
            if (!sub[1].equals("w")){
                int l = Integer.parseInt(sub[1]);
                tn.left = new TreeNode(l);
                map.put(l, tn.left);
            } else {
                tn.left = null;
            }
            
            if (!sub[2].equals("w")){
                int r = Integer.parseInt(sub[2]);
                tn.right = new TreeNode(r);
                map.put(r, tn.right);
            } else {
                tn.right = null;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
