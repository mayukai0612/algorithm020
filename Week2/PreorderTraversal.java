import java.util.*;

public class PreorderTraversal {


    //solution 1:
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    void dfs(TreeNode root, List<Integer> res) {
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }

    //solution 2:

    public List<Integer> preorderTravesal2(TreeNode node){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (node != null){
            res.add(node.val);

            if(node.right != null){
                stack.push(node.right);
            }

            node = node.left;
            //左节点为空，则弹出
            if(node == null && !stack.isEmpty()){
                node = stack.pop();
            }
        }

        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode node) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while(node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
