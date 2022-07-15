class Solution {
   public List<String> crawl(String startUrl, HtmlParser htmlParser) {
       String hostUrl = startUrl.split("/")[2];
       Set<String> visited = new HashSet<>();
       ArrayDeque<CompletableFuture<List<String>>> q = new ArrayDeque<>();
       q.add(CompletableFuture.supplyAsync(() -> htmlParser.getUrls(startUrl) ));
       visited.add(startUrl);
       
       try{
       while(!q.isEmpty()){
           
           for(String url: q.poll().get()){
               if(visited.contains(url) || url.indexOf(hostUrl) == -1)
                   continue;
               visited.add(url);
               q.add(CompletableFuture.supplyAsync( () -> htmlParser.getUrls(url)));
           }
       }
       }catch(Exception e){
               
           }
       
       return new ArrayList<String>(visited);

    }
}