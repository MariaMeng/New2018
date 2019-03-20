package Test;
import java.util.*;

/**
 * Created by apple on 10/10/18.
 */
public class testList {
    public List<List<Integer>> testList() {
        List<List<Integer>> list  = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        return list;
    }
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        char a = 'a';
        System.out.println((int)a);
        System.out.println((char)(a + 32));
        StringBuilder s = new StringBuilder();
        s.append("a->b");
        s.deleteCharAt(s.length() - 1);
        System.out.println(s.toString());
        s.deleteCharAt(s.length() - 1);
        System.out.println(s.toString());

    }

}
