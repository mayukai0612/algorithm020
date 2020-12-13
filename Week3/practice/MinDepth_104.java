package practice;

public class MinDepth_104 {
    //思路就是转化为求每一个子节点的最小深度

    public int minDepth(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = minDepth(node.left);
        int right = minDepth(node.right);

        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    public int minDepth1(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;

        if(root.left != null) {
            min_depth = Math.min(minDepth1(root.left), min_depth);
        }

        if(root.right != null) {
            min_depth = Math.min(minDepth1(root.right), min_depth);
        }

        return min_depth + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null) return minDepth(root.right) + 1;
        else if (root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    public int minDepth3(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }
}
