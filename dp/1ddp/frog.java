import java.util.* ;
import java.io.*; 
public class frog {
    public static int frogJump(int n, int heights[]) {
        int [] dp = new int [n];
        Arrays.fill(dp , -1);
        //return f(n-1 , heights ,dp);
        //return tabulation(heights , dp);
        return so(heights , heights.length);
    }
    public static int f(int ind , int [] heights , int [] dp){
        if(ind == 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int oneJump = f(ind - 1 , heights , dp) + Math.abs(heights[ind] - heights[ind-1]);
        int twoJump = Integer.MAX_VALUE;
        if(ind > 1){
            twoJump = f(ind - 2 , heights , dp) + Math.abs(heights[ind] - heights[ind-2]);
        }
        return dp[ind] = Math.min(oneJump , twoJump);
    }
    public static int tabulation(int [] heights , int [] dp){
        dp[0] = 0;
        for(int i=1;i<heights.length;i++){
            int fs = dp[i-1] + Math.abs(heights[i-1] - heights[i]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = dp[i-2] + Math.abs(heights[i-2] - heights[i]);
            }
            dp[i] = Math.min(fs , ss);
        }
        return dp[heights.length-1];
    }

    public static int so(int [] heights , int n){
        int prev = 0;
        int prev2 = 0;
        int curr;
        for(int i=1;i<n;i++){
            int fs = prev + Math.abs(heights[i-1] - heights[i]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = prev2 + Math.abs(heights[i-2] - heights[i]);
            }
            curr = Math.min(fs , ss);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

}