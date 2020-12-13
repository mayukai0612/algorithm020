import java.util.*;

public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return Collections.EMPTY_LIST;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()){
            List<Integer> subRes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pollLast();
                subRes.add(node.val);
                if(node.children != null){
                    for (Node child : node.children){
                        queue.addFirst(child);
                    }
                }
            }
            res.add(subRes);
        }
        return res;
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
