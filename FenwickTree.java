public class FenwickTree{
    public void update(int[] biTree, int val, int index){
        while(index < biTree.length){
            biTree[index]+=val;
            index = getNext(index);
        }
    }

    public int getNext(int index){
        return index + (index & -index);
    }

    public int getParent(int index){
        return index - (index & -index);
    }

    public int getSum(int[] biTree, int index){
        index = index+1;
        int sum=0;
        while(index>0){
            sum+=biTree[index];
            index=getParent(index);
        }
        return sum;
    }

    public int[] createBinaryIndexedTree(int[] values){
        int n= values.length;
        int biTree[]=new int[n+1];

        for(int i=1;i<=n;i++){
            update(values,values[i-1],i);
        }

        return biTree;
    }

    public static void main(String args[]){
        int input[] = {1,2,3,4,5,6,7};
        FenwickTree ft = new FenwickTree();
        int binaryIndexedTree[] = ft.createBinaryIndexedTree(input);
        assert 1 == ft.getSum(binaryIndexedTree, 0);
        assert 3 == ft.getSum(binaryIndexedTree, 1);
        assert 6 == ft.getSum(binaryIndexedTree, 2);
        assert 10 == ft.getSum(binaryIndexedTree, 3);
        assert 15 == ft.getSum(binaryIndexedTree, 4);
        assert 21 == ft.getSum(binaryIndexedTree, 5);
        assert 28 == ft.getSum(binaryIndexedTree, 6);
    }

}