import practice.TreeNode;

public class LowestCommonAncestor {

    //left 为空说明左子树没有
    //left 有，两种情况 1. 存在p或者q中一个 2. p，q都在一边
    //right 同理
    //left 和 right都存在则返回root

    //看左右子树有没有碰到p或q
    //用后序遍历的方法，判断左右两边的结果。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        //这里已经求出解
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}
