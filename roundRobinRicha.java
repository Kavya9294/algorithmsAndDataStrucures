import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      int[][] bidders = {{0,10,1},{1,2,3},{2,5,1},{3,1,1},{4,3,2},{5,3,1}};
      int numShares = 6;
      List<Integer> res = new ArrayList<>();
      boolean[] assigned = new boolean[bidders.length];
      Arrays.sort(bidders, Comparator.comparingInt((o) -> o[1]));
      for(int i = 0; i < bidders.length;i++){
          System.out.println(bidders[i][0]+" "+ bidders[i][1] + " "+ bidders[i][2]);
      }
      //round robin

      while(numShares > 0){
        for(int i=bidders.length-1;i >= 0;i--){
          //Round robin
          while(numShares >0 && i > 0 && bidders[i][1] == bidders[i-1][1]){
            if(bidders[i][2]>0){
              bidders[i][2]-=1;
              numShares -=1;
              assigned[i] = true;
            }
            i--;
          }
          if (numShares == 0) {
            break;
          }else{
            int temp = Math.min(numShares, bidders[i][2]);
            bidders[i][2] -= temp;
            numShares -=temp;
            assigned[i] = true;
          }
        }
      }

      for(int i= 0 ; i < bidders.length;i++){
        if(assigned[i])
          System.out.println("true: "+ bidders[i][0]);
        else
          System.out.println("false: "+ bidders[i][0]);
      }
    }
   
}

/*
// Include header file
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <math.h>

class MyClass
{
    public:
    static void main(std::vector<std::string> &args)
    {
        std::vector<std::vector<int>> bidders{{0, 10, 1}, {1, 2, 3}, {2, 5, 1}, {3, 1, 1}, {4, 3, 2}, {5, 3, 1}};
        int numShares = 6;
        std::vector<int> res = std::vector<>();
        std::vector<bool> assigned(bidders.size());
        Arrays.sort(bidders,Comparator.comparingInt([&] (o){
            return o[1];
        }));
        for (int i = 0; i < bidders.size(); i++)
        {
            std::cout << std::to_string(bidders[i][0]) + " " + std::to_string(bidders[i][1]) + " " + std::to_string(bidders[i][2]) << std::endl;
        }
        // round robin
        while (numShares > 0)
        {
            for (int i = bidders.size() - 1; i >= 0; i--)
            {
                // Round robin
                while (numShares > 0 && i > 0 && bidders[i][1] == bidders[i - 1][1])
                {
                    if (bidders[i][2] > 0)
                    {
                        bidders[i][2] -= 1;
                        numShares -= 1;
                        assigned[i] = true;
                    }
                    i--;
                }
                if (numShares == 0)
                {
                    break;
                }
                else 
                {
                    int temp = min(numShares,bidders[i][2]);
                    bidders[i][2] -= temp;
                    numShares -= temp;
                    assigned[i] = true;
                }
            }
        }
        for (int i = 0; i < bidders.size(); i++)
        {
            if (assigned[i])
            {
                std::cout << "true: " + std::to_string(bidders[i][0]) << std::endl;
            }
            else 
            {
                std::cout << "false: " + std::to_string(bidders[i][0]) << std::endl;
            }
        }
    }
};
int main(int argc, char **argv){
  std::vector<std::string> parameter(argv + 1, argv + argc);
  MyClass::main(parameter); 
  return 0;
};
*/