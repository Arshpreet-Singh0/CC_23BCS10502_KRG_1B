package Session_Wise_Problems.Mar_16;

import java.util.ArrayList;
import java.util.Stack;

public class CourseSchedule {
    class Solution {
    class Edge{
        int src;
        int dest;
        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public int[] findOrder(int num, int[][] prerequisites) {
        int n = prerequisites.length;
        int ans[] = new int[num];
        if(n==0){
            for(int i=0;i<num;i++){
                ans[i] = i;
            }
            return ans;
        }

        ArrayList<Edge>[] graph = new ArrayList[num];

        for(int i=0;i<num;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            graph[prerequisites[i][1]].add(new Edge(prerequisites[i][1],prerequisites[i][0]));
        }
        boolean vis[] = new boolean[num];
        boolean stack[] = new boolean[num];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<num;i++){
            if(!vis[i]){
                if(isCycle(graph,i,vis,stack,s)){
                    return new int[] {};
                }
            }
        }

        for(int i=0;i<num;i++){
            ans[i] = s.pop();
        }

        
        return ans;
    }

    public boolean isCycle(ArrayList<Edge>[] graph,int curr, boolean vis[], boolean stack[], Stack<Integer> s){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(stack[e.dest]) return true;

            if(!vis[e.dest]){
                if(isCycle(graph,e.dest,vis,stack,s)){
                    return true;
                }
            }
        }
        s.push(curr);
        stack[curr] = false;
        return false;
    }
}
}
