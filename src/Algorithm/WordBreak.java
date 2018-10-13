package Algorithm;

import java.util.*;

/**
 * Created by apple on 10/11/18.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) return true;
        int n = s.length();
        Map<String, Boolean> map = new HashMap<>();
        return backTrack(s, dict, map);
    }
    public static boolean backTrack(String s, Set<String> dict, Map<String, Boolean> map) {
        if (s.length() == 0) return true;
        if (map.containsKey(s))
            return map.get(s);

        boolean res = false;
        for (String d : dict) {
            if (!s.startsWith(d)) continue;
            if (backTrack(s.substring(d.length()), dict, map)) {
                res = true;
                break;
            }
        }
        map.put(s, res);
        return res;
    }

    public static boolean wordBreak_B(String s, Set<String> wordDict) {
        int a[] = new int[s.length()];
        if(helper(s,wordDict,a,0)==2) return true;
        return false;
    }

    public static int helper(String s, Set<String> wordDict, int a[], int i){
        if(i>=s.length()) return 2;
        if(a[i]>0) return a[i];
        for(String chec : wordDict){
            if(isSame(s,i,chec)){
                if(helper(s,wordDict,a,i+chec.length())==2){
                    a[i]=2;
                    return 2;
                }
            }
        }
        a[i]=1;
        return 1;
    }
    public static boolean isSame(String a,int i, String b){
        if(i==a.length()) return true;
        if(i+b.length()>a.length()) return false;
        for(int j = 0;j<b.length();j++){
            if(a.charAt(i+j)!=b.charAt(j)) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "pinapplepinapple";
        Set<String> dict = new HashSet<>();
        dict.add("pin");
        dict.add("apple");
        System.out.println(wordBreak(s, dict));
        System.out.println(s.startsWith(""));
        int a = 'a';
        int A = 'A';
        System.out.println("a = " + a);
        System.out.println("A = " + A);
        System.out.println(a - A);
    }

}
