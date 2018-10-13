package Test;

/**
 * Created by apple on 10/13/18.
 */
import java.util.*;

public class TestNestedLoop {
    public static void main(String[] args) throws Exception{
        int n = 100, m = 1000, i = 0, j = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (i == 1 && j == 1)  {
                    System.out.println(i);
                    System.out.println(j);

//                    Thread.sleep(3000);
                    break;
                }
            }
        }
        System.out.println(i);
        System.out.println(j);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(0, 99);
        list.add(0, 98);
        System.out.println(list);
    }

}
