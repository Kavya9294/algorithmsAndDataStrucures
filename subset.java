class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return result;
    }
    
    public void dfs(int start, int[] nums, List<Integer> tempArray){
        result.add(new ArrayList<>(tempArray));
        for(int i=start;i<nums.length;i++){
            tempArray.add(nums[i]);
            dfs(i+1, nums, tempArray);
            tempArray.remove(tempArray.size()-1);
        }
    }
        
}