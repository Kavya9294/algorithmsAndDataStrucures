class Solution {
  public void backtrack(int[] nums,List<List<Integer>> output, List<Integer> tempSet) {
    if(tempSet.size() == nums.length){
        output.add(new ArrayList(tempSet));
    }
      for(int i=0;i< nums.length;i++){
          if(tempSet.contains(nums[i]))
              continue;
          tempSet.add(nums[i]);
          backtrack(nums, output,tempSet);
          tempSet.remove(tempSet.size()-1);
      }
  }

  public List<List<Integer>> permute(int[] nums) {
    int n = nums.length;
      List<List<Integer>> result = new ArrayList<>();

      backtrack(nums, result, new ArrayList<>());
      return result;
  }
}