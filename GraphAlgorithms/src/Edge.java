import java.util.LinkedList;

public class Edge<E> {

    E source;
    E destination;
    int weight;

    Edge(E source, E destination, int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    E getDestination(){
        return this.destination;
    }

    E getSource(){
        return this.source;
    }

    int getWeight(){
        return this.weight;
    }

}