public class DirectedGraph<E> extends UndirectedGraph<E> {

    @Override
    public void addEdge(E source, E destination){
        if(!graph.containsKey(source) || !graph.containsKey(destination)){
            System.out.println("One or both of the vertices do not exist in graph.");
            return;
        }
        if(graph.get(source).contains(destination)){
            System.out.println("Edge from " +source+ " to " + destination + " already exists.");
            return;
        }
        else{
            Edge newEdge = new Edge(source,destination,1);
            graph.get(source).add(newEdge);
        }
    }
}
