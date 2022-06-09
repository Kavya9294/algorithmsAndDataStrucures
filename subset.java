class Solution {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return result;
    }
    
    public void dfs(int i, int[] nums){
        if(i >= nums.length){
            result.add((ArrayList)subset.clone());
            return;
        }
        
        subset.add(nums[i]);
        dfs(i+1, nums);
        subset.remove(subset.size()-1);
        dfs(i+1, nums);
    }
        
}