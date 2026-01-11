import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean isContainsDuplicateBrute(int[] nums){
        int n = nums.length;

        for (int i= 0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (nums[i]==nums[j])
                    return true;
            }
        }

        return false;
    }
    public boolean isContainsDuplicateBetter(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=1; i<n; i++){
            if (nums[i]==nums[i-1])
                return true;
        }
        return false;
    }
    public boolean isContainsDuplicateOptimal(int[] nums){
        Set<Integer> seen = new HashSet<>();
        for(int num: nums){
            if (seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;
    }
}

class TestDuplicate{
    public static void main(String[] args) {
        int[] nums = {1,2, 1,5};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
//        System.out.println(containsDuplicate.isContainsDuplicateBrute(nums));
//        System.out.println(containsDuplicate.isContainsDuplicateBetter(nums));
        System.out.println(containsDuplicate.isContainsDuplicateOptimal(nums));
    }
}