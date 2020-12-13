package practice;

import java.util.Stack;

public class IsValidBst {

    //1.BST 左边所有儿子小于父亲，右边所有儿子大于父亲
    //  BST 中序遍历是递增的

    Integer previous = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }

        if(previous != null){
            if(previous < root.val){
                previous = root.val;
            }else {
                return false;
            }
        }else {
            previous = root.val;
        }

        if(!isValidBST(root.right)){
            return false;
        }

        return true;
    }




    //2. iterative inorder traversal using stack
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }


    //3.
    public boolean isValidBST3(TreeNode root) {
        return isValidBST3(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST3(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST3(root.left, minVal, root.val) && isValidBST3(root.right, root.val, maxVal);
    }




}
