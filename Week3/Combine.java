import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        if(n < 1 || k < 1){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(n,k, 1 , res, path);

        return res;
    }

    private void dfs(int n, int k, int begin, List<List<Integer>> res, ArrayDeque<Integer> path) {
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.add(i);
            System.out.println("递归前： " + path.toString());
            dfs(n, k, i + 1, res, path);
            path.removeLast();
            System.out.println("递归后： " + path.toString());
        }
    }
}
