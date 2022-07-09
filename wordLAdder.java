class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
                
        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        Set<String> localList = new HashSet<>();
        int length = 1;
        
        for(int i=0;i<wordList.size();i++){
            localList.add(wordList.get(i));
        }
        
        if(!localList.contains(endWord)){
            return 0;
        }

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int j = 0;j < qSize;j++){
                String word = q.poll();
                char[] wordArr = word.toCharArray();
                for(int i=0;i<wordArr.length;i++){
                    char cur = wordArr[i];
                    for(char c='a'; c <='z'; c++){
                        if(wordArr[i] == c)
                            continue;
                        wordArr[i] = c;
                        String newWord = String.valueOf(wordArr);
                        if(newWord.equals(endWord)){
                            return length +1;
                        }
                        if(localList.contains(newWord)){
                            localList.remove(newWord);
                            q.offer(newWord);
                        }
                    }
                    wordArr[i] = cur;
                }
            }
            length++;
        }
        return 0;
    }
}