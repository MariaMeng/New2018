package Date.Nov.Nov1st2019;

/**
 * Created by apple on 11/1/19.
 */
public class Leetcode394 {

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) return  s;
        String[] strs = helper(s, 0);
        return strs[1];
    }

    public static String[] helper(String s, int pos) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;

        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                String[] strs = helper(s, i + 1);
                for (int j = 0; j < multi; j++) {
                    sb.append(strs[1]);
                }
                multi = 0;
                i = Integer.parseInt(strs[0]);
            } else if (s.charAt(i) == ']') {
                return new String[] {String.valueOf(i), sb.toString()};
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                multi = multi * 10 + Integer.parseInt(s.charAt(i) + "");
            } else
                sb.append(s.charAt(i));
        }
        return new String[] {String.valueOf(s.length()), sb.toString()};
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String res = decodeString(s);
        System.out.println(res);
    }
}
