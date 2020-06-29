import java.util.HashSet;
import java.util.Set;

public class RedundantConnection2 {

    public static int[] parent;


    public static int find(int ele){
        if(parent[ele]!=ele)
            return find(parent[ele]);

        return parent[ele];
    }

    public static void union(int x, int y){
        parent[x]=y;
    }

    public static int[] findRedundantConnection(int[][] edges) {

        Set<Integer> vertices = new HashSet<Integer>();
        for(int i = 0; i<edges.length; i++){
            vertices.add(edges[i][0]);
            vertices.add(edges[i][1]);
        }

        parent = new int[vertices.size()+1];
        for(int i = 1; i<parent.length;i++)
            parent[i]=i;

        for(int[] edge: edges){ ;
            int x = edge[0];
            int y = edge[1];
            //System.out.print(x + " "+y);
            if(!(find(x)==find(y))){
                union(x,y);
            }
            else{
                return edge;
            }
        }

        throw new AssertionError();

    }

    public static void main(String[] args){

        int[][] edges = {{1,2}, {1,3}, {2,3}};
        int[] a = findRedundantConnection(edges);
        System.out.print(a[0]+" "+a[1]);

    }


}
