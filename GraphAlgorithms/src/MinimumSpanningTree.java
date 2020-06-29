import sun.awt.image.ImageWatched;

import javax.jws.Oneway;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinimumSpanningTree extends UndirectedGraph {

    public static void primMST(UndirectedGraph graph, int start){
        int nvertices = graph.getSize();
        boolean[] isInTree = new boolean[nvertices];
        int[] distance = new int[nvertices];
        int[] parent = new int[nvertices];

        for(Object key: graph.getKeys()){
            isInTree[(Integer)key] = false;
            distance[(Integer)key] = Integer.MAX_VALUE;
            parent[(Integer)key] = -1;

        }

        int v = start;
        while(!isInTree[v]){
            isInTree[v] = true;
             LinkedList<Edge> p = graph.getAdjacencyList(v);
            for(int i = 0; i<p.size();i++){
                Object w = p.get(i).getDestination();
                int weight = graph.getEdgeWeight(v,p.get(i));
                if(weight<distance[(Integer)w] && isInTree[(Integer)w]==false){
                    distance[(Integer)w] = weight;
                    parent[(Integer)w] = v;
                }
            }

            v = 1;
            int minDistance = Integer.MAX_VALUE;
            for(int i = 0; i<nvertices; i++){
                if(distance[i]<minDistance&& isInTree[i]==false) {
                    minDistance = distance[i];
                    v = i;
                }
            }

        }

        for(int i = 0; i<parent.length; i++){
            System.out.println(i + " " + parent[i]);
        }

    }


    public static void main(String[] args){
            UndirectedGraph<Integer> graph = new UndirectedGraph<>();
            graph.addVertex(0);
            graph.addVertex(1);
            graph.addVertex(2);
            graph.addVertex(3);


            graph.addEdge(0,1,1);
            graph.addEdge(1,2,2);
            graph.addEdge(2,3,5);
            graph.addEdge(3,0,4);
            graph.addEdge(0,2,3);

            System.out.println(graph.toString());

           primMST(graph,1);

    }
}
