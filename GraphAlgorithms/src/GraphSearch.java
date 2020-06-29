import sun.awt.image.ImageWatched;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;

public class GraphSearch {

    private static boolean isCycle = false;
    private static int time = 0;
    private static int componentCount = 0;

    private static void processEdge(Object v1, Object v2){
        //System.out.println("Processing edge " +v1+ " to "+v2);
    }

    private static void processVertex(Object v1){
        //System.out.println("Processing vertex "+v1);
    }

    private static void bfs(UndirectedGraph graph, Object start){
        //boolean[] processed = new boolean[graph.getSize()];
        HashMap<Object,Boolean> processed = new HashMap<>();
        //boolean[] discovered = new boolean[graph.getSize()];
        HashMap<Object,Boolean> discovered = new HashMap<>();
        HashMap<Object,Object> parent = new HashMap<>();
        Queue<Object> queue = new LinkedList<>();

        for(Object key: graph.getKeys()){
            processed.put(key,false);
            discovered.put(key,false);
            parent.put(key,-1); //no vertex has a parent initially.
        }

        queue.add(start);
        discovered.replace(start,true);

        while(!queue.isEmpty()){
            Object v = queue.remove();
            processed.replace(v,true);
            processVertex(v);
            for(Object ele: graph.getAdjacencyList(v)){
                if(!processed.get(ele)){
                    processEdge(v,ele);
                }

                if(!discovered.get(ele)){
                    queue.add(ele);
                    discovered.replace(ele,true);
                    parent.replace(ele,v);
                }

            }

        }

    }

    public static void dfsVisit(UndirectedGraph graph, LinkedList<Object> adjacencyList, Object key, HashMap parent,HashMap startTime, HashMap endTime){
        processVertex(key);
        time++;
        startTime.put(key, time);
        for(Object ele: adjacencyList){
            if(!parent.containsKey(ele)) {
                parent.put(ele, key);
                dfsVisit(graph, graph.getAdjacencyList(ele), ele, parent,startTime,endTime);
            }
        }
    time++;
    endTime.put(key,time);
    }

    public static void dfsVisit(UndirectedGraph graph, LinkedList<Object> adjacencyList, Object key, HashMap parent, HashMap<Object,Boolean> recStack){
        processVertex(key);
        recStack.replace(key,true);

        for(Object ele: adjacencyList){
            if(recStack.get(ele)){
                isCycle = true;
            }
            if(!parent.containsKey(ele)) {
                parent.put(ele, key);
                dfsVisit(graph, graph.getAdjacencyList(ele), ele, parent,recStack);
            }

        }
    recStack.replace(key,false);
    }


    public static void dfs(UndirectedGraph graph, Object start){
        HashMap<Object,Object> parent = new HashMap<>();
        HashMap<Object,Integer> startTime = new HashMap<>();
        HashMap<Object,Integer> endTime = new HashMap<>();
        parent.put(start,-1);
        componentCount++;
        dfsVisit(graph,graph.getAdjacencyList(start),start,parent, startTime, endTime); //to start from given start, not first node always
        for (Object key: graph.getKeys()){
            if(!parent.containsKey(key)) {
                componentCount++;
                //System.out.println("Connected Component 2+");
                parent.put(key, -1);
                dfsVisit(graph, graph.getAdjacencyList(key),key,parent,startTime,endTime);
            }
        }
//        for(Object end: endTime.keySet()){                        //needed for topological sort
//            System.out.println(end + " " + endTime.get(end));
//        }

    }

    public static void dfs(DirectedGraph graph, Object start, HashMap recStack){
        HashMap<Object,Object> parent = new HashMap<>();
        parent.put(start,-1);
        dfsVisit(graph,graph.getAdjacencyList(start),start,parent,recStack); //to start from given start, not first node always
//        for (Object key: graph.getKeys()){ //Assume graph has only 1 connected component for now
//            if(!parent.containsKey(key)) {
//                parent.put(key, -1);
//                dfsVisit(graph, graph.getAdjacencyList(key),key,parent,recStack);
//            }
//        }

    }

    public static boolean cycleCheck(DirectedGraph graph, Object start){
        int size = graph.getSize();
        HashMap<Object,Boolean> recStack = new HashMap<Object, Boolean>();
        for(Object key: graph.getKeys())
            recStack.put(key,false);

        dfs(graph,start,recStack);
        return isCycle;
    }

    public static void topologicalSort(DirectedGraph graph, Object start){
        if(cycleCheck(graph,start))
            throw new IllegalArgumentException("Graph has a cycle, cannot sort.");
        else{
            dfs(graph,start);
        }
    }

    public static int getComponentCount(UndirectedGraph graph, Object start){
        dfs(graph,start);
        return componentCount;
    }


    public static void main(String[] args){
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
       // graph.addEdge(2,1); //duplicate 1
        graph.addEdge(1,3);
        graph.addEdge(4,5);
       // graph.addEdge(5,2); //duplicate 3
       // graph.addEdge(5,4); //duplicate 4
      //  graph.addEdge(5,3); //duplicate 5
      //  graph.addEdge(6,3); //duplicate 6
        //System.out.println(graph.toString()) ;
//        System.out.println("BFS....");
//        bfs(graph,1);
//        System.out.println("DFS....");
//        dfs(graph,1);

        DirectedGraph<Character> graph2 = new DirectedGraph<>();
        graph2.addVertex('A');
        graph2.addVertex('B');
        graph2.addVertex('C');
        graph2.addVertex('D');
        graph2.addVertex('E');
        graph2.addVertex('F');
        graph2.addVertex('G');
        graph2.addEdge('A','B');
        graph2.addEdge('B','C');
        graph2.addEdge('A','C');
        graph2.addEdge('G','A');
        graph2.addEdge('G','F');
        graph2.addEdge('C','F');
        graph2.addEdge('C','E'); //E->C for cycle
        graph2.addEdge('F','E');
        graph2.addEdge('E','D');
        graph2.addEdge('B','D');

        //System.out.println(graph2.toString());
        //dfs(graph2,'G');
        //System.out.println(cycleCheck(graph2,'A'));
        //topologicalSort(graph2,'G');

        System.out.println(getComponentCount(graph,1));

    }
}
