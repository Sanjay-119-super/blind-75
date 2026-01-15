import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum_2
 *
 * Problem: Given an sorted array of integers nums and a target integer,
 * return the indices (1-based) of the two numbers such that they add up to target.
 *
 * Approaches implemented:
 * 1. Brute Force
 * 2. Better (Binary Search)
 * 3. Optimal (Two Pointer)
 * 4. Better (HashMap)
 */
public class TwoSum_2 {

    /**
     * Brute Force Approach
     * --------------------
     * Idea: Check all possible pairs (i, j).
     *
     * Time Complexity: O(n^2) → double loop checks all pairs.
     * Space Complexity: O(1) → no extra space used.
     *
     * Problem: Very slow for large arrays.
     */
    public int[] twoSum2Brute(int[] nums, int target){
        int n = nums.length;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (nums[i] + nums[j] == target)
                    return new int[]{i + 1, j + 1}; // 1-based indices
            }
        }
        return null;
    }

    /**
     * Better Approach: Binary Search
     * ------------------------------
     * Idea: For each element nums[i], search for (target - nums[i]) using binary search.
     *
     * Time Complexity: O(n log n) → outer loop O(n), binary search O(log n).
     * Space Complexity: O(1) → no extra space used.
     *
     * Problem: Requires sorted array. If not sorted, must sort first (O(n log n)).
     */
    public int[] twoSum2BetterBinarySearch(int[] nums, int target){
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int start = i + 1;
            int end = n - 1;
            int diff = target - nums[i];

            while (start <= end){
                int mid = start + (end - start) / 2;

                if (nums[mid] == diff)
                    return new int[]{mid + 1, i + 1}; // 1-based indices
                else if (nums[mid] < diff)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return null;
    }

    /**
     * Optimal Approach: Two Pointer
     * -----------------------------
     * Idea: Use two pointers (start, end) on sorted array.
     * - If sum > target → move end left.
     * - If sum < target → move start right.
     * - If sum == target → return indices.
     *
     * Time Complexity: O(n) → single pass.
     * Space Complexity: O(1) → no extra space.
     *
     * Problem: Works only if array is sorted.
     */
    public int[] twoSum2OptimalTwoPointer(int[] nums, int target){
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start < end){
            int sum = nums[start] + nums[end];
            if (sum == target)
                return new int[]{start + 1, end + 1}; // 1-based indices
            else if (sum > target)
                end--;
            else
                start++;
        }
        return null;
    }

    /**
     * Better Approach: HashMap
     * ------------------------
     * Idea: Store elements in HashMap while iterating.
     * - For each nums[i], check if (target - nums[i]) exists in map.
     * - If yes → return indices.
     * - If no → put nums[i] in map.
     *
     * Time Complexity: O(n) → single pass.
     * Space Complexity: O(n) → HashMap stores elements.
     *
     * Advantage: Works on unsorted arrays.
     */
    public int[] twoSumBetterHashMap(int[] nums, int target){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                return new int[]{i + 1, map.get(diff) + 1}; // 1-based indices
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

/**
 * Test Class
 * ----------
 * Demonstrates usage of different approaches.
 */
class TestTwoSum2 {
    public static void main(String[] args) {
        TwoSum_2 twoSum2 = new TwoSum_2();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Uncomment to test different approaches:
        // int[] result = twoSum2.twoSum2Brute(nums, target);
        // int[] result = twoSum2.twoSum2BetterBinarySearch(nums, target);
        // int[] result = twoSum2.twoSum2OptimalTwoPointer(nums, target);
        int[] result = twoSum2.twoSumBetterHashMap(nums, target);

        for (int index : result)
            System.out.print(index + " ");
    }
}
