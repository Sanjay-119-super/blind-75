/**
 * This class demonstrates three different approaches to search for a target
 * in a rotated sorted array.
 *
 * Approaches:
 * 1. Brute Force (O(n^2))
 * 2. Better Linear Search (O(n))
 * 3. Optimal Binary Search for Rotated Array (O(log n))
 */
public class SearchTargetInRotateSortedArray {

    /**
     * Brute Force Approach
     * --------------------
     * Time Complexity: O(n^2)
     * Logic: For each index i, check all elements from i to end.
     * Returns the index of target if found, else -1.
     *
     * @param nums   input rotated sorted array
     * @param target element to search
     * @return index of target or -1 if not found
     */
    public int searchBrute(int[] nums, int target){
        int n = nums.length;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if (nums[j] == target)
                    return j;
            }
        }
        return -1;
    }

    /**
     * Better Approach (Linear Search)
     * -------------------------------
     * Time Complexity: O(n)
     * Logic: Traverse the array once and check each element.
     * Returns the index of target if found, else -1.
     *
     * @param nums   input rotated sorted array
     * @param target element to search
     * @return index of target or -1 if not found
     */
    public int searchBetter(int[] nums, int target){
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    /**
     * Optimal Approach (Modified Binary Search)
     * -----------------------------------------
     * Time Complexity: O(log n)
     * Logic:
     * - Use binary search but handle rotation.
     * - At each step, check which half is sorted.
     * - Decide whether to search in left half or right half.
     * Returns the index of target if found, else -1.
     *
     * @param nums   input rotated sorted array
     * @param target element to search
     * @return index of target or -1 if not found
     */
    public int searchOptimalBinarySearch(int[] nums, int target){
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;

            // Check if left half is sorted
            if (nums[start] <= nums[mid]){
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            // Else right half is sorted
            else {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}

/**
 * Test class to demonstrate the search methods.
 */
class TestSearch {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        SearchTargetInRotateSortedArray searchTargetInRotateSortedArray =
                new SearchTargetInRotateSortedArray();

        // Brute force search
        System.out.println(searchTargetInRotateSortedArray.searchBrute(nums, target));

        // Uncomment to test other approaches
        // System.out.println(searchTargetInRotateSortedArray.searchBetter(nums, target));
        // System.out.println(searchTargetInRotateSortedArray.searchOptimalBinarySearch(nums, target));
    }
}
