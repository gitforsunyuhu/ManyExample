package algorithm.niukewang;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class TreeToSequence {
    public static ArrayList<Integer> arrayList;
    int[][] ans;

    public int[][] convert(TreeNode root) {
        // write code here
        if(root == null ){
            return null;
        }
        firstHelper(root);
        int len = arrayList.size();
        ans = new int[3][len];
        for(int i= 0; i< len ; i++){
            ans[0][i] = arrayList.get(i);
        }
        arrayList = new ArrayList<Integer>();
        b(root);
        for(int i= 0; i< len ; i++){
            ans[1][i] = arrayList.get(i);
        }
        arrayList = new ArrayList<Integer>();
        c(root);
        for(int i= 0; i< len ; i++){
            ans[2][i] = arrayList.get(i);
        }
        return ans;
    }

    public void firstHelper(TreeNode root){
        if(root != null) {
            arrayList.add(root.val);
            firstHelper(root.left);
            firstHelper(root.right);
        }
    }
    public void b(TreeNode root){
        if(root != null) {
            b(root.left);
            arrayList.add(root.val);
            b(root.right);
        }
    }
    public void c(TreeNode root){
        if(root != null) {
            c(root.left);
            c(root.right);
            arrayList.add(root.val);
        }
    }


}