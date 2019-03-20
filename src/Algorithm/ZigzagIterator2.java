package Algorithm;

import java.util.*;
/**
 * Created by apple on 10/30/18.
 */
public class ZigzagIterator2 {
    List<List<Integer>> vecs;
    boolean[] visited;
    int i = 0, j = 0;
    public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        this.vecs = vecs;
        visited = new boolean[vecs.size()];
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (!hasNext())
            return -1;

        while (visited[i])
            i = (i + 1) % vecs.size();

        if (j == vecs.get(i).size() - 1)
            visited[i] = true;

        int val = vecs.get(i).get(j);
        i++;

        while (i < vecs.size() && visited[i])
            i++;
        if (i == vecs.size()) {
            i = 0;
            j++;

        }


        return val;

    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        int cnt = 0;

        while (cnt < vecs.size() && (visited[i] || vecs.get(i).size() == 0)) {
            if (vecs.get(i).size() == 0)
                visited[i] = true;
            i = (i + 1) % vecs.size();
            cnt++;
        }
        if (cnt == vecs.size())
            return false;
        if (j == vecs.get(i).size())
            return false;
        else {

            return true;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> vecs = new ArrayList<>();
        List list = Arrays.asList(1,7,5,10,2);
        vecs.add(list);
        list = Arrays.asList();
        vecs.add(list);
        list = Arrays.asList();
        vecs.add(list);

        ZigzagIterator2 zz = new ZigzagIterator2(vecs);
        while (zz.hasNext())
            System.out.println(zz.next());

    }
}
