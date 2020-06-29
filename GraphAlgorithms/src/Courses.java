import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;

public class Courses {
    public static boolean isCycle(HashMap<Integer,LinkedList<Integer>> prereq, int start, boolean[] visiting, boolean[] visited){
        if(visiting[start]) return true;
        visiting[start] = true;
        LinkedList<Integer> temp = prereq.get(start);
        for(int ele: temp){
                if(!visited[ele]){
                    boolean res = isCycle(prereq,ele,visiting,visited);
                    if(res==true)
                        return true;
                }
        }
        visiting[start] = false;
        visited[start] = true;

    return false;
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length==0)
            return true;
        HashMap<Integer, LinkedList<Integer>> prereq = new HashMap<>();
        for(int i = 0; i<numCourses;i++)
            prereq.put(i,new LinkedList<Integer>());
        for(int i = 0; i<prerequisites.length; i++){
                int key = prerequisites[i][0];
                int val = prerequisites[i][1];

                prereq.get(key).add(val);
        }

    boolean[] visiting = new boolean[numCourses];
    boolean[] visited = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]) {
                if(isCycle(prereq,i,visiting,visited)) return false;
            }
        }
    return true;
    }

    public static void main(String[] args){

        int[][] pre = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        System.out.println(canFinish(4,pre));

    }

}
