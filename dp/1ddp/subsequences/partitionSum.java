class partitionSum {
    public boolean canPartition(int[] nums) {
        if(nums.length == 1) return false;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2 == 1) {
            return false;
        }
        else{
            int k = sum/2;
            int [][] dp = new int [nums.length][k + 1];
            for(int [] rows:dp){
                Arrays.fill(rows , -1);
            }
        //return f(nums.length-1 , k , nums , dp);
        return tab(nums.length-1 , k , nums);
        }
    }
    public boolean f(int ind , int target , int [] a , int [][] dp){
        if(target == 0) return true;

        if(ind == 0) return a[0] == target;

        if(dp[ind][target] != -1){
            return dp[ind][target] == 0 ? false : true; 
        }

        boolean notTake = f(ind-1 , target , a , dp);
        boolean take = false;
        if(a[ind]<=target){
            take = f(ind-1 , target-a[ind] , a , dp);
        }
        dp[ind][target] = notTake||take ? 1:0;

        return notTake || take;
    }

    public boolean tab(int n , int k , int [] a){
        boolean [][] dp = new boolean[n][k+1];
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        if(a[0]<=k){
            dp[0][a[0]] = true;
        }
        for(int ind=1;ind<n;ind++){
            for(int target=1;target<=k;target++){
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(a[ind]<=target){
                    take = dp[ind-1][target-a[ind]];
                }
                dp[ind][target] = notTake||take;
            }
        }
        return dp[n-1][k];
    }
}