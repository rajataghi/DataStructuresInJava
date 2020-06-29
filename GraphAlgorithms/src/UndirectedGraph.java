

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class UndirectedGraph<E> {


    public HashMap<E, LinkedList<Edge>> graph;

    UndirectedGraph(){
        graph = new HashMap<E, LinkedList<Edge>>();
    }

    public void addVertex(E key){
        if(graph.containsKey(key)){
            System.out.println("Vertex already present in graph, cannot add duplicate.");
            return;
        }
        else{
            graph.put(key, new LinkedList<Edge>());
        }
    }

    public void addEdge(E source, E destination, int weight){
        if(!graph.containsKey(source) || !graph.containsKey(destination)){
            System.out.println("One or both of the vertices do not exist in graph.");
            return;
        }
        if(graph.get(source).contains(destination)){ //since graph is undirected, reverse check is not needed.
            System.out.println("Edge from " +source+ " to " + destination + " already exists.");
            return;
        }
        else{
            Edge newEdge = new Edge(source,destination,weight);
            Edge newEdge2 = new Edge(destination,source,weight);
            graph.get(source).add(newEdge);
            graph.get(destination).add(newEdge2);
        }
    }

    public void addEdge(E source, E destination){
        this.addEdge(source,destination,1);
    }

    public int getEdgeWeight(E source, Edge destination){
        for(Edge ele: getAdjacencyList(source)){
            if(ele.getDestination()==destination.getDestination())
                return ele.getWeight();
        }
        return Integer.parseInt(null);
    }



    public int getSize(){
        return graph.size();
    }

    public boolean hasVertex(E key){
        if(graph.containsKey(key))
            return true;
        else
            return false;
    }

    public Set<E> getKeys(){
        return graph.keySet();
    }

    public LinkedList<Edge> getAdjacencyList(E key){
        if(graph.containsKey(key))
            return graph.get(key);
        else{
            throw new NullPointerException("Key not found in graph");
        }
    }


    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (E v: graph.keySet()){
            builder.append(v.toString() + ": ");
            LinkedList<Edge> tempHead = graph.get(v);
            for(Edge ele: tempHead){
                builder.append(ele.getDestination() + " ");
            }
            builder.append("\n");
            }
            return builder.toString();
        }

}
