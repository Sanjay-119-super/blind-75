public class MaximumProductSubarray {

    public int maxProductBrute(int[] nums){
        int maxP=nums[0];
        int n = nums.length;

        for (int i =0; i<n; i++){
            for(int j=i; j<n; j++){
                int product=1;
                for (int k=i; k<=j; k++){
                   product*=nums[k];

                }
                maxP=Math.max(product,maxP);
            }
        }
        return maxP;
    }
    public int maxProductBetter(int[] nums){
        int maxP=nums[0];
        int n = nums.length;

        for (int i =0; i<n; i++){
            int product=1;
            for(int j=i; j<n; j++){
                product*=nums[j];
                maxP=Math.max(product,maxP);

            }
        }
        return maxP;
    }
    public int maxProductBetterDP(int[] nums){
        int n=nums.length;
        int maxSoFar=nums[0];
        int minSoFar=nums[0];
        int res = nums[0];

        for(int i=1; i<n; i++){
            //3 option
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(maxSoFar*current, minSoFar*current));
            minSoFar=Math.min(current, Math.min(maxSoFar*current, minSoFar*current));
            maxSoFar=tempMax;

            res = Math.max(res,maxSoFar);
        }
        return res;
    }

}

class TestProductSub{
    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        MaximumProductSubarray productSubarray = new MaximumProductSubarray();
//        System.out.println(productSubarray.maxProductBrute(nums));
//        System.out.println(productSubarray.maxProductBetter(nums));
        System.out.println(productSubarray.maxProductBetterDP(nums));
    }
}
