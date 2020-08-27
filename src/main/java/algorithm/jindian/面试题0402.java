package algorithm.jindian;


import java.lang.reflect.Array;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
}

public class 面试题0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int len =nums.length;
        TreeNode root = new TreeNode(nums[len/2]);
        TreeNode left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len/2));
        TreeNode right = sortedArrayToBST(Arrays.copyOfRange(nums, len/2 +1, len));
        root.left =left;
        root.right = right;
        return root;
    }
}
