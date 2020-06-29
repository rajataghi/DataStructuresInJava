import java.util.*;

public class RedundantConnection {
    public static Set<Integer> seen = new HashSet();

    public static boolean dfs(HashMap<Integer,ArrayList<Integer>> graph,int source, int destination){
        if(!seen.contains(source)) {
            seen.add(source);
            for (int ele : graph.get(source)) {
                if (ele == destination) return true;
                if(dfs(graph,ele,destination)) return true;
            }
        }
        return false;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Set<Integer> vertices = new HashSet<>();
        for(int i = 0;i<n;i++){
            vertices.add(edges[i][0]);
            vertices.add(edges[i][1]);
        }

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int v: vertices)
            graph.put(v,new ArrayList<Integer>());
        
        for(int i = 0; i<n; i++){
            seen.clear();
            if(dfs(graph,edges[i][0],edges[i][1]))
                return edges[i];
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

//        for(int v: graph.keySet()){
//            System.out.print(v+": ");
//            for(int e: graph.get(v)){
//                System.out.print(e+" ");
//            }
//            System.out.println();
//        }
        throw new AssertionError();
    }

    public static void main(String[] args){
        int[][] edges = {{0,1}, {0,2}, {1,2}};
        int[] a = findRedundantConnection(edges);
        System.out.print((a[0]+1)+ ","+ (a[1]+1));
    }
}
