class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result,candidates,target,0, new ArrayList<>());
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, int[] nums, int remain, int start, List<Integer> tmpList){
        if(remain < 0)
            return;
        if(remain == 0){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1])continue;
            tmpList.add(nums[i]);
            backtrack(result, nums, remain - nums[i], i+1, tmpList);
            tmpList.remove(tmpList.size()-1);
        }
    }

}