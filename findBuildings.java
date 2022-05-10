class Solution {
    public int[] findBuildings(int[] heights) {
        int max = heights[heights.length-1];
        //Use List only instead
        Stack<Integer> list = new Stack<>();
        list.add(heights.length-1);
        for(int i = heights.length-2;i>=0;i--){
            if(heights[i]>max){
                list.push(i);
                max = heights[i];
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        while(!list.isEmpty()){
            result[i++] = list.pop();
        }
        
        return result;
    }
}