// Concept of Lowest Common Anc


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
    Map<Integer, Integer> map = new HashMap<>();
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root.left == null && root.right == null) return root;

        findDepth(root, 0);

        return lowestCommonAncestor(root);
    }

    public TreeNode lowestCommonAncestor(TreeNode root) {

        if(root == null || map.get(root.val) == maxDepth){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left);
        TreeNode right = lowestCommonAncestor(root.right);

        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }
        return right;
    }

    public void findDepth(TreeNode root, int d){
        if(root == null) return; 

        maxDepth = Math.max(maxDepth, d);
        map.put(root.val, d);
        findDepth(root.left, d+1);
        findDepth(root.right, d+1);
    }
}