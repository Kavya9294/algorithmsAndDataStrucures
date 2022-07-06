/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */
/*
Cant do this with a queue because
static stores across session
*/
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    char[] local_buf = new char[4];
    int size = 0;
    int prevIndex = 0;
    
    public int read(char[] buf, int n) {
        
        for(int i=0;i<n;i++){
            if(prevIndex == size){
                size = read4(local_buf);
                prevIndex = 0;
                if(size == 0){
                    return i;
                }
            }
            buf[i] = local_buf[prevIndex++];
        }
        return n;
    }
}