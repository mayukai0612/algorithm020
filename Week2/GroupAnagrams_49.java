import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap();

        for(String str : strs){
            char[] chars1 = str.toCharArray();
            Arrays.sort(chars1);
            String s = String.valueOf(chars1);
            ArrayList<String> strings = map.getOrDefault(s,new ArrayList<String>());
            strings.add(str);
            map.put(s, strings);
        }

        ArrayList<List<String>> result = new ArrayList<>();
        for(String s : map.keySet()){
            result.add(map.get(s));
        }

        return result;
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, ArrayList> map = new HashMap<>();
        for(String str : strs) {
            StringBuilder sb = new StringBuilder();
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}
