class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tempList, int start){
        result.add(new ArrayList<>(tempList));
        
        for(int i=start; i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            tempList.add(nums[i]);
            backtrack(result, nums, tempList, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}