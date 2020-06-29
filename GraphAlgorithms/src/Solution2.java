import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution2 {

    private static boolean isCycle = false;

    public static void dfs(HashMap<Integer, LinkedList<Integer>> graph, boolean[] visited, boolean[] visiting, int v, Stack<Integer> topological){
        if(visited[v])
            return;
        visiting[v] = true;
        for(int e: graph.get(v)){
            if(!visiting[e]){
                dfs(graph,visited, visiting, e, topological);
            }
            else{
                System.out.println("Cycle!");
                isCycle = true;
                System.out.print(isCycle);
                break;
            }
        }
        visited[v] = true;
        visiting[v] = false;
        topological.add(v);
        //System.out.println(v);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        int[] order = new int[numCourses];

        if(numCourses==0)
            return order;

        if(len==0){
            for(int i = 0; i<numCourses; i++)
                order[i] = i;

            return order;
        }

        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
        for(int i = 0; i<len; i++){
            if(graph.get(prerequisites[i][0])==null)
                graph.put(prerequisites[i][0],new LinkedList<Integer>());

            if(graph.get(prerequisites[i][1])==null)
                graph.put(prerequisites[i][1],new LinkedList<Integer>());


            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[] marked = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        Stack<Integer> topological = new Stack<>();
        for(int i = 0; i<graph.size(); i++){
            if(!marked[i])
            {   System.out.print("Calling dgs!");
                dfs(graph, marked, visiting, i, topological);
        }}
        System.out.println(isCycle);
        if(isCycle==true)
            return new int[0];

        int n = order.length-1;
        while(!topological.isEmpty()){
            int val = topological.pop();
            order[n] = val;
            n--;
        }


        return order;
    }

    public static void main(String[] args){
        int[][] ord = {{1,0},{0,1}};
        int[] order = findOrder(4, ord);
        for(int ele: order)
            System.out.print(ele);

    }
}