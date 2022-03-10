class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length ==0){
            return res;
        }
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++){
            if(i==0 || nums[i]!=nums[i-1]){
                threesome(nums,i,res);
            }
        }
        return res;  
    }
    
    public void threesome(int[] nums, int i, List<List<Integer>> res){
        Set<Integer> seen = new HashSet<>();

        for(int j=i+1; j<nums.length;j++){
            int sum = -(nums[i]+nums[j]);
            if(seen.contains(sum)){
                res.add(Arrays.asList(nums[i],nums[j],sum));
                while(j+1 < nums.length && nums[j] == nums[j+1]){
                    ++j;
                }
            }
                seen.add(nums[j]);
            }
        }
}