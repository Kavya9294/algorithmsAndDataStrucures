class Solution {
    public String validateIPv4(String queryIP){
        String[] ip = queryIP.split("\\.",-1);
        for(String x: ip){
            if(x.length() == 0 || x.length() > 3)
                return "Neither";
            if(x.charAt(0) == '0' && x.length() > 1)
                return "Neither";
            for(char ch : x.toCharArray()){
                if( !Character.isDigit(ch))
                    return "Neither";
            }
            if(Integer.parseInt(x) > 255)
                return "Neither";
        }
        return "IPv4";
    }
    
    public String validateIPv6( String queryIP){
        String[] ip = queryIP.split(":",-1);
        String hexDigits = "0123456789abcdefABCDEF";
        for(String x : ip){
            if(x.length() == 0 || x.length() > 4)
                return "Neither";
            
            for(char ch: x.toCharArray()){
                if(hexDigits.indexOf(ch) == -1)
                    return "Neither";
            }
        }
        return "IPv6";
    }
    
    public String validIPAddress(String queryIP) {
        if(queryIP.chars().filter(ch -> ch == '.').count() == 3){
            return validateIPv4(queryIP);
        }
        else if(queryIP.chars().filter(ch -> ch == ':').count() == 7){
            return validateIPv6(queryIP);
        }else{
            return "Neither";
        }
    }
}