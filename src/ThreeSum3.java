import javax.sound.midi.Track;
import java.util.*;


public class ThreeSum3 {
    public List<List<Integer>> threeSumBrute(int[] nums){
        /*✅ Totals when i=0
             j loop → 5 times
             k loop → 10 times (4+3+2+1+0)*/
        List<List<Integer>> res = new ArrayList<>();
        int n= nums.length;;
        for (int i=0; i<n; i++){
            for (int j=i+1; j<n;j++){
                for (int k=j+1; k<n; k++){
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);//avoid dup
                        if (!res.contains(triplet)){
                            res.add(triplet);
                        }
                    }
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSumHashMapBasedTwoSum(int[] nums){
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int target = -nums[i];
            List<List<Integer>> pairs = twoSumHashMap(nums, i + 1, n - 1, target);
            for (List<Integer> pair : pairs) {
                res.add(Arrays.asList(nums[i], pair.get(0), pair.get(1))); }
        } return new ArrayList<>(res); }

    private List<List<Integer>> twoSumHashMap(int[] nums, int start, int end, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = start; j <= end; j++) {
            int diff = target - nums[j];
            if (map.containsKey(diff)) {
                pairs.add(Arrays.asList(nums[j], diff)); }
            map.put(nums[j], j);
        }
        return pairs;
    }
    public List<List<Integer>> threeSumOptimalTwoPointer(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;

    }
}

class Test3Sum{
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        ThreeSum3 threeSum3 = new ThreeSum3();
//        List<List<Integer>> lists = threeSum3.threeSumBrute(nums);
//        List<List<Integer>> lists = threeSum3.threeSumHashMapBasedTwoSum(nums);
        List<List<Integer>> lists = threeSum3.threeSumOptimalTwoPointer(nums);
        for (List<Integer> n:lists)
            System.out.print(n+ " ");
    }
}