public class ProductOfArrayExceptSelf {
    public int[] productOfExceptSelfBrute(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int product=1;
            for (int j=0; j<n; j++){
                if (i != j)
                    product *=nums[j];
            }
            ans[i]=product;

        }
        return ans;
    }
    public int[] productOfExceptSelfBetter(int[] nums){
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        int[] ansProduct = new int[n];

        prefixProduct[0]=1;
        suffixProduct[n-1]=1;

        //1. Build Prefix Product mtlb left side ka product
        for(int i=1; i<n; i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }
        //1. Build suffix Product mtlb right side ka product
        for(int i=n-2; i>=0; i--){
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
        }
        //1. Build Ans Product mtlb left side + right side ka product
        for(int i=0; i<n; i++){
            ansProduct[i] = prefixProduct[i] * suffixProduct[i];
        }
        return ansProduct;
    }

    public int[] productOfExceptSelfOptimal(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];

        //store prefix produc in ans
        ans[0]=1;

        for(int i=1; i<n; i++)
            ans[i]= ans[i-1] * nums[i-1];

        //create a suffix variable
        int suffix =1;
        for (int i=n-1; i>=0; i--){
            ans[i] = ans[i]*suffix;
            suffix*=nums[i];
        }
        return ans;
    }


}

class TestProduct{
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
//        int[] ans = product.productOfExceptSelfBrute(nums);
//        int[] ans = product.productOfExceptSelfBetter(nums);
        int[] ans = product.productOfExceptSelfOptimal(nums);
        for (int num : ans)
            System.out.print(num + " ");
    }
}