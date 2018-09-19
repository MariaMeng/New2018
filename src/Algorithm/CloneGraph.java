package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by apple on 9/4/18.
 */
public class CloneGraph {
    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }

    }

//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if (node == null) return null;
//
//        UndirectedGraphNode src = new UndirectedGraphNode(0);
//
//        Queue<UndirectedGraphNode> queue = new LinkedList<>();
//
//        src.label = node.label;
//
//        queue.add(node);
//
//        while(!queue.isEmpty()) {
//            UndirectedGraphNode tmp = queue.poll();
//
//
//        }
//    }
}
