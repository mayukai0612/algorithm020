package practice;


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;

public class Codec_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }

        ArrayList<String> ans = new ArrayList<>();
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        ans.add(String.valueOf(root.val));
        while (!deque.isEmpty()){
            TreeNode cur = deque.pollFirst();

            if(cur.left == null){
                ans.add("X");
            }else {
                ans.add(String.valueOf(cur.left.val));
                deque.add(cur.left);
            }

            if(cur.right == null){
                ans.add("X");
            }else {
                ans.add(String.valueOf(cur.right.val));
                deque.add(cur.right);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str :  ans){
            sb.append(str).append(",");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }

        String[] arr = data.split(",");

        int cursor = 1;
        LinkedList<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        deque.add(root);

        while(cursor < arr.length){
            TreeNode node = deque.pollFirst();

            if(!arr[cursor].equals("X")){
                node.left = new TreeNode(Integer.valueOf(arr[cursor]));
                deque.add(node.left);
            }

            cursor = cursor + 1;

            if(!arr[cursor].equals("X")){
                node.right = new TreeNode(Integer.valueOf(arr[cursor]));
                deque.add(node.right);
            }

            cursor++;
        }

        return root;

    }

}
