import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int ar[] : prerequisites) {
            adj.get(ar[1]).add(ar[0]);
        }
        
        int[] topoSort = new int[numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
    
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int idx = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topoSort[idx++] = node;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        
        return (idx == numCourses) ? topoSort : new int[0];
    }
}
