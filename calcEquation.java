class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];
            if(!graph.containsKey(dividend))
                graph.put(dividend, new HashMap<>());
            if(!graph.containsKey(divisor))
                graph.put(divisor, new HashMap<>());
            graph.get(dividend).put(divisor,quotient);
            graph.get(divisor).put(dividend,1/quotient);
        }
        double[] result = new double[queries.size()];
        for(int i=0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            if(!graph.containsKey(divisor) || !graph.containsKey(dividend)){
                result[i] = -1.0;
            }else if( divisor == dividend){
                result[i] = 1.0;
            }else{
                HashSet<String> visited = new HashSet<>();
                result[i] = DFS(graph, dividend, divisor, 1, visited);
            }
        }
        return result;
    }
    
    private double DFS(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode, double accProduct, Set<String> visited){
        visited.add(currNode);
        double ret = -1.0;
        Map<String, Double> neighbors = graph.get(currNode);
        if(neighbors.containsKey(targetNode)){
            return accProduct*neighbors.get(targetNode);
        }else{
            for(Map.Entry<String, Double> pair: neighbors.entrySet()){
                String nextNode = pair.getKey();
                if(visited.contains(nextNode))
                    continue;
                ret = DFS(graph, nextNode, targetNode, accProduct*pair.getValue(), visited);
                if(ret != -1.0)
                    break;
            }
        }
        visited.remove(currNode);
        return ret;
    }
}