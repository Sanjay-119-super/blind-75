/*Question: Find Minimum in Rotated Sorted Array

📦 What is Given
Ek integer array nums diya gaya hai.
Array originally sorted ascending tha.
Array ko ek pivot index par rotate kiya gaya hai.
Array mein distinct elements hain (duplicates nahi).

🎯 What We Have to Do
Array ka minimum element find karna hai.
Output ek single integer hoga jo array ka smallest element hai.
Efficient solution chahiye → Binary Search (O(log n)).

🪓 1. Brute Force Approach (O(n²))
Har element ko minimum maan kar baaki sabse compare karo.
Nested loops lagenge → time complexity O(n²).
Example: [3,4,5,1,2] → har element check karna → minimum = 1.
Drawback: Bahut slow for large arrays.

⚡ 2. Better Approach (O(n))
Ek hi loop mein traverse karo.
min = nums[0] se start karo, aur har element compare karke update karo.
Time complexity O(n).
Example: [3,4,5,1,2] → loop se minimum = 1.
Drawback: Still linear, not optimal.

🚀 3. Optimal Approach (O(log n) using Binary Search)
Use binary search to shrink search space.

Logic:
Agar nums[mid] > nums[right] → minimum right side mein hai → left = mid + 1.
Else → minimum left side mein ho sakta hai → right = mid.
Loop end hone ke baad nums[left] hi minimum hoga.
Time complexity O(log n).
Example: [4,5,6,7,0,1,2] → minimum = 0.

👉 Short Summary:
Brute Force: Compare every element → O(n²).
Better: Single pass linear scan → O(n).
Optimal: Binary search → O(log n).*/

public class FindMinimumInSortedArray {
    public int findMinBrute(int[] nums){
        int n=nums.length;
        int min=nums[0];
        for(int i=0; i<n; i++){
            boolean isMin=true;
            for (int j=0; j<n; j++){
                if(nums[j]<nums[i]) {
                    isMin = false;
                    break;
                }

            }
            if (isMin){
                min=nums[i];
                break;
            }
        }
        return min;

    }
    public int findMinBetter(int[] nums){
        int n = nums.length;
        int min = nums[0];

        for (int i=0; i<n; i++){
            if (nums[i]<min)
                min=nums[i];
        }
        return min;
    }
    public int findMinOptimal(int[] nums){
        int n=nums.length;
        int left=0;
        int right=n-1;

        //edse case
        if (n==1)
            return nums[0];

        while (left<right){
           int mid = (left+right)/2;

           if (nums[mid]>nums[right])
               left=mid+1;
           else
               right=mid;
        }
        return nums[left];
    }
}

class TestFindMin{
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        FindMinimumInSortedArray minimumInSortedArray = new FindMinimumInSortedArray();
//        System.out.println(minimumInSortedArray.findMinBrute(nums));
//        System.out.println(minimumInSortedArray.findMinBetter(nums));
        System.out.println(minimumInSortedArray.findMinOptimal(nums));
    }
}