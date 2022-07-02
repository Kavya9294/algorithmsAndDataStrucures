class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for(String email: emails){
            String name = email.split("@")[0];
            String domain = "@"+email.split("@")[1];
            name = name.replaceAll("\\.","");
            name = name.replaceAll("\\+.*", "");
            uniqueEmails.add(name+domain);
        }
        
        return uniqueEmails.size();
    }
}