class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int m = mat2[0].length;
        int l = mat2.length;
        int[][] result = new int[n][m];
        HashMap<Integer, HashMap<Integer,Integer>> aM = new HashMap<>();
        HashMap<Integer, HashMap<Integer,Integer>> bM = new HashMap<>();

        for(int i = 0;i < n;i++){
            aM.put(i, new HashMap<>());
            for(int j = 0;j<mat1[0].length;j++){
                if(mat1[i][j]==0){
                    continue;
                }
                aM.get(i).put(j, mat1[i][j]);
            }
        }
        
        for(int i = 0;i<l;i++){
            for(int j =0;j<m;j++){
                if(mat2[i][j] == 0){
                    continue;
                }
                if(!bM.containsKey(j)){
                    bM.put(j, new HashMap<>());
                }
                bM.get(j).put(i, mat2[i][j]);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!bM.containsKey(j)){
                    continue;
                }
                
                HashMap<Integer, Integer> aRow = aM.get(i);
                
                HashMap<Integer, Integer> bCol = bM.get(j);
                
                for(int col: aRow.keySet()){

                    if(bCol.containsKey(col)){
                        result[i][j] += aRow.get(col)*bCol.get(col);
                    }
                }
            }
        }
        
        return result;
    }
}