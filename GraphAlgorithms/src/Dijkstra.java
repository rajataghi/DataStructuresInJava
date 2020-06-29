import java.util.*;

public class Dijkstra <E> {
    public static int[] distance;
    public static int v = 6;
    public static Queue<Node> heap = new PriorityQueue<Node>(v, new Node());
    public static HashSet<Integer> finalized = new HashSet<>();
    public static void dijkstra(List<List<Node>> graph, int start){
      heap.add(new Node(start,0));

      while(finalized.size()!=v){
          Node r = heap.remove();
          //System.out.println("adding shortest: " + r.node+ " " + r.cost);
          distance[r.node] = r.cost;
          finalized.add(r.node);

          scan(graph,r);

      }
    System.out.println("Heap Size!" + heap.size());
    }

    public static void scan(List<List<Node>> graph,Node v){
        System.out.println("Value passed:" + v.node);
        for(Node u: graph.get(v.node)){
            if(!finalized.contains(u.node)) {
                int newDist = distance[v.node] + u.cost;
                if (newDist<distance[u.node]) {
                    distance[u.node] = newDist;
                    heap.add(new Node(u.node, distance[u.node]));
                }
            }
        }

    }



    public static void main(String[] args){

       distance = new int[v];

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i<v; i++) {
            graph.add(new ArrayList<Node>());
            distance[i] = 50;
        }

        graph.get(0).add(new Node(1,4));
        graph.get(0).add(new Node(2,1));
        graph.get(0).add(new Node(3,1));
        graph.get(1).add(new Node(5,1));
        graph.get(1).add(new Node(2,2));
        graph.get(2).add(new Node(3,4));
        graph.get(2).add(new Node(4,3));
        graph.get(2).add(new Node(5,4));
        graph.get(3).add(new Node(4,2));
        graph.get(4).add(new Node(5,1));

        dijkstra(graph, 0);
        for(int i = 0; i<v; i++)
            System.out.println(0 + "to " + i +": "+ distance[i]);

    }
}
