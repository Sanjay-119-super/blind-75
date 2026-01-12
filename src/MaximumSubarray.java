public class MaximumSubarray {
    public int maxSubArrayBrute(int[] nums){
        int n=nums.length;
        int maxi = Integer.MIN_VALUE;
        for (int i =0; i<n; i++){

            for (int j=i; j<n; j++){
                int sum=0;
                for (int k =i; k<=j; k++){
                    sum+=nums[k];
                    maxi = Math.max(maxi,sum);

                }
            }
        }
        return maxi;
    }

    public  int maxSubArrayBetter(int[] nums){
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        int maxi = Integer.MIN_VALUE;

        for (int i=0; i<n; i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }
        for (int i=0; i<n; i++){
            for (int j =i; j<n; j++){
                int sum = prefixSum[j+1] - prefixSum[i];
                maxi=Math.max(sum,maxi);
            }
        }
        return maxi;
    }
/*
  Kadane’s Algo....Core Idea
  current: har step par decide karta hai ki subarray continue kare (current + arr[i]) ya restart kare (arr[i]).
  maxi: har step par ab tak ka sabse bada sum track karta hai.
  Negative sum ko carry forward nahi karte, isliye restart option hota hai.
*/
    public int maxSubArrayOptimalKadansAlgo(int[] nums){
        int n=nums.length;
        int current=nums[0];
        int maxi = nums[0];

        for (int i=1; i<n; i++){
            current=Math.max(nums[i], current+nums[i]);
            maxi=Math.max(current,maxi);
        }
        return maxi;
    }
}

class TestMaximumSubArray{
    public static void main(String[] args) {
        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
//        System.out.println(maximumSubarray.maxSubArrayBrute(nums));
//        System.out.println(maximumSubarray.maxSubArrayBetter(nums));
        System.out.println(maximumSubarray.maxSubArrayOptimalKadansAlgo(nums));
    }
}