class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows ==1){
            return s;
        }
        
        StringBuffer sb = new StringBuffer();
        
        ArrayList<StringBuilder> rows = new ArrayList<>();
                
        for(int i=0;i<Math.min(numRows, s.length());i++){
            rows.add(new StringBuilder());
        }
        
        int j = 0;
        int direction = 1;
        for(char ch: s.toCharArray()){
            if(j==numRows-1){
                direction = -1;
            }
            if(j == 0){
                direction = +1;
            }
            rows.get(j).append(ch);
            j=j+direction;
        }
        
        for(StringBuilder row: rows){
            sb.append(row);
        }
        
        return sb.toString();
    }
}