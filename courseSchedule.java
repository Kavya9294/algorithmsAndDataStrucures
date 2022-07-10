class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        for(int i = 0;i < prerequisites.length;i++){
            int dest = prerequisites[i][0];
            int source = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(source, new ArrayList<>());
            lst.add(dest);
            adjList.put(source, lst);
            indegree[dest] += 1;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i< numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int i=0;
        while(!q.isEmpty()){
            int node = q.poll();
            topologicalOrder[i++] = node;
            
            if(adjList.containsKey(node)){
                for(Integer neighbor : adjList.get(node)){
                    indegree[neighbor]--;
                    if(indegree[neighbor]==0){
                        q.add(neighbor);
                    }
                }
            }
        }
        if( i == numCourses){
            return topologicalOrder;
        }
        return new int[0];
    }
}