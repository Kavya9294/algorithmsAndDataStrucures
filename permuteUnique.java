class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[n];
        backtrack(nums, result, used,new ArrayList<>() );
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> result, boolean[] used, List<Integer> tmpList){
        if(tmpList.size() == nums.length){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i=0; i< nums.length;i++){
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;
            tmpList.add(nums[i]);
            used[i] = true;
            backtrack(nums, result,used,tmpList);
            used[i] = false;
            tmpList.remove(tmpList.size()-1);
        }
    }

}