import java.util.*;
public class MyClass {
    public static List<List<Integer>> commonAncestor1(int[][] pairs){
    // assume non-empty input 2-d array, and each pair contains 2 elements with parent-child order
    List<Integer> zero_ancestor = new ArrayList<>(), one_ancestor = new ArrayList<>();
    Map<Integer,List<Integer>> numOfAncestors = new HashMap<>();
    for(int[] pair : pairs){
        List<Integer> list = numOfAncestors.getOrDefault(pair[1], new ArrayList<>());
        list.add(pair[0]);
        numOfAncestors.put(pair[1], list);
        
        numOfAncestors.put(pair[0], numOfAncestors.getOrDefault(pair[0], new ArrayList<>()));
    }
    for(int node : numOfAncestors.keySet()){
        if(numOfAncestors.get(node).size() == 0) zero_ancestor.add(node);
        if(numOfAncestors.get(node).size() == 1) one_ancestor.add(node);
    }
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(zero_ancestor);
    ans.add(one_ancestor);
    hasCommonAncestor(numOfAncestors, 6, 7);
    findEarliestAncestor(6, numOfAncestors);
    return ans;
}

    public static void hasCommonAncestor(Map<Integer,List<Integer>> numOfAncestors, int p, int q){
        Set<Integer> pParents = new HashSet<>();
        Set<Integer> qParents = new HashSet<>();
        findCommonAncestors(pParents, p, numOfAncestors);
        findCommonAncestors(qParents, q, numOfAncestors);
        System.out.println("all P: "+pParents);
        pParents.retainAll(qParents);
        boolean flag = pParents.size() > 0;
        // System.out.println(flag);
        
    }
    
    public static void findCommonAncestors(Set<Integer> parents, int node,Map<Integer,List<Integer>> numOfAncestors ){
        List<Integer> nodeParents = numOfAncestors.get(node);
        for(int parent: nodeParents){
            parents.add(parent);
            findCommonAncestors(parents, parent, numOfAncestors);
        }
    }
    
    
    public static void findEarliestAncestor(int node,Map<Integer,List<Integer>> numOfAncestors){
        if(numOfAncestors.get(node).size() == 0){
            System.out.println("p in order: -1");
            return;
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.add(node);
        Set<Integer> res = new HashSet<>();
        int cur = -1;
        while(!q.isEmpty()){
            cur = q.poll();
            List<Integer> parents = numOfAncestors.get(cur);
            if(!parents.isEmpty()){
                for(int p : parents){
                    if(!res.contains(p)){
                        res.add(p);
                        q.offer(p);
                    }
                }
            }
        }
        System.out.println("p in order: "+cur);
        // System.out.println(res.get(res.size()-1));
    }
    
    public static void main(String args[]) {
      int[][] parentChildPairs = {  {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {8, 10}, {11, 2}  }; 
    List<List<Integer>> ans = commonAncestor1(parentChildPairs);
        // for(List<Integer> parents: ans ){
        //     System.out.println(parents);
        // }
        
        
    }
    
    
    
}