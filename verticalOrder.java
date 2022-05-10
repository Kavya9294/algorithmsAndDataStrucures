**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root==null){
            return output;
        }
        
        Map<Integer, List<Integer>> columnMapping = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        int column = 0;
        
        queue.offer(new Pair(root,column));
        int minColumn = 0;
        int maxColumn = 0;
        
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> current = queue.poll();
            root = current.getKey();
            column = current.getValue();
            
            if(root!=null){
                if(!columnMapping.containsKey(column)){
                    columnMapping.put(column, new ArrayList<>());
                }
                columnMapping.get(column).add(root.val);
                minColumn = Math.min(minColumn,column);
                maxColumn = Math.max(maxColumn, column);
            
                queue.offer(new Pair(root.left, column-1));
                queue.offer(new Pair(root.right,column+1));
            }
        }
        
        for(int i=minColumn;i<=maxColumn;i++){
            output.add(columnMapping.get(i));
        }

        return output;
        
    }
}