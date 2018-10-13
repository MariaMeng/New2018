package Algorithm;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by apple on 10/4/18.
 */
public class Prior {
    public String findSmallest(String[] strs, int n) {
        // write code here
        if (strs.length == 1) return strs[0];
        if (strs.length == 0) return null;

        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String o1, String o2) {
                String O1 = o1 + o2;
                String O2 = o2 + o1;
                return O1.compareTo(O2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            sb.append(s);

        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "a";

    }

}
