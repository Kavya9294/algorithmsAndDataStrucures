class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int last_fruit = -1;
        int last_fruit_count = 0;
        int previous_last_fruit = -1;
        int cur_max = 0;
        
        for(int fruit : fruits){
            if(fruit == last_fruit || fruit == previous_last_fruit){
                cur_max ++;
            }else{
                cur_max = last_fruit_count + 1;
            }
            
            if(fruit == last_fruit){
                last_fruit_count+=1;
            }else{
                last_fruit_count = 1;
            }
            
            if(fruit != last_fruit){
                previous_last_fruit = last_fruit;
                last_fruit = fruit;
            }
            
            max = Math.max(max, cur_max);
            
        }
        
        return max;
    }
    
}