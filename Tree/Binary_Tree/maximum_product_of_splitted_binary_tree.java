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
    long sum = 0;
    long maxp = 0;

    public int maxProduct(TreeNode root) {
        if(root == null) return 0;
        
        sum = totalsum(root);
        findres(root);
        return (int)(maxp % 1000000007);

    }

    public static int totalsum(TreeNode root){
        if(root == null) return 0;
        int leftsum = totalsum(root.left);
        int rightsum = totalsum(root.right);
        int sum = leftsum + rightsum + root.val;

        return sum;
    }

    public long findres(TreeNode root){
    if(root == null) return 0;

    long leftsum = findres(root.left);
    long rightsum = findres(root.right);

    long subtreesum = leftsum + rightsum + root.val;

    long remSum = sum - subtreesum;
    maxp = Math.max(maxp, subtreesum * remSum);

    return subtreesum; 
}

}