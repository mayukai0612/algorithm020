package practice;

import java.lang.reflect.Array;
import java.util.*;

public class LetterCombinations {
    private static HashMap<Character,String> digitsMap = new HashMap<>();
    static {
        digitsMap.put('2', "abc");
        digitsMap.put('3', "def");
        digitsMap.put('4', "ghi");
        digitsMap.put('5', "jkl");
        digitsMap.put('6', "mno");
        digitsMap.put('7', "pqrs");
        digitsMap.put('8', "tuv");
        digitsMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return Collections.EMPTY_LIST;
        }

        List<String> res = new ArrayList<>();
        String s = "";
        search(s, digits, 0, res, digitsMap);
        return res;
    }

    public void search(String s, String digits, int i, List<String> res, HashMap<Character, String> map){
        if(s.length() == digits.length()) {
            res.add(s);
        }

        char digit = digits.charAt(i);
        String str = map.get(digit);
        for (int j = 0; j < str.length(); j++) {
            search(s + str.charAt(j), digits,i + 1, res, map);
        }
    }
}
