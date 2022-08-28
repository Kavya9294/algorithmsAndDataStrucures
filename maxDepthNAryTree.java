class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int cur = 0;
        for(Node child: root.children){
            cur = Math.max(cur, maxDepth(child));
        }
        return cur + 1;
    }
}