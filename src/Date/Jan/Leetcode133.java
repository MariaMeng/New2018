package Date.Jan;

import java.util.*;

/**
 * Created by apple on 20/1/17.
 */

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
public class Leetcode133 {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node n1 = new Node(node.val, new ArrayList<>());
        map.put(node, n1);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node nei: curr.neighbors) {
                Node tmp = map.get(nei);
                if (tmp == null) {
                    tmp = new Node(nei.val, new ArrayList<>());
                    map.put(nei, tmp);
                }
                map.get(curr).neighbors.add(tmp);
                queue.add(nei);
            }
        }
        return n1;
    }
}
