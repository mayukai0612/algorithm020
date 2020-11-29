import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder_589 {
    public List<Integer> preorder(Node root) {
        //recursion
        //时间复杂度 O(N) 空间复杂度 O(logN)
        List<Integer> res = new ArrayList<>();
        recursion(res, root);
        return res;
    }

    //iterate 迭代
    public List<Integer> preorder2(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()){
            root = stack.pop();
            if(root != null){
                res.add(root.val);
            }else{
                continue;
            }

            if(root.children != null){
                for (int i = root.children.size() - 1; i >= 0; i--){
                    stack.add(root.children.get(i));
                }
            }

        }

        return res;
    }

    private void recursion(List list, Node root){
        if(root.children != null){
            list.add(root.val);
            for (Node child : root.children) {
                recursion(list, root);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
