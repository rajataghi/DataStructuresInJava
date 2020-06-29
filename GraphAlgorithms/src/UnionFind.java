import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class UnionFind { //kruskal

    static int[] parent;
    public static int find(int ele){
        if(parent[ele]!=ele)
            return find(parent[ele]);

        return parent[ele];
    }

    public static void union(int x, int y){
        parent[x]=y;
    }

    public static void kruskal(int[][] edges){
        int vertices = 3;
        parent = new int[vertices+1];
        for(int i = 1; i<=vertices;i++)
            parent[i]=i;

        for(int[] edge: edges){

            if(!(find(edge[0])==find(edge[1]))){
                union(edge[0],edge[1]);
                System.out.println(edge[0]+" "+edge[1]); //this edge is in the minimum spanning tree
            }

        }


    }

    public static void main(String[] args){

        int[][] edges = {{1,2}, {2,3}, {1,3}}; //if the edges had weights, they should be sorted by weights for kruskal. Weight is 1 here.

        kruskal(edges);

    }

}
