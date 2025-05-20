package daily;

/*
 * First know about Difference Array
 * invest(i , j , v) ---> g[i] = g[i] + v & g[j + 1] = g[j + 1] - v
 * 
 */
import java.util.Arrays;
class ZeroArrayTransformation1 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int [] diff = new int [nums.length+1];
        for(int [] a: queries){
            diff[a[0]] += 1;
            diff[a[1]+1] -= 1;
        }
        for(int i=1;i<diff.length;i++){
            diff[i] += diff[i-1]; 
        }
        for(int i=0;i<nums.length;i++){
            if(diff[i] < nums[i]) return false;
        }
        return true;
    }
}