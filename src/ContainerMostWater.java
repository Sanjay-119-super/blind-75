public class ContainerMostWater {
    public int maxArea(int[] height){
        int n=height.length;
        int maxArea=0;
        for (int i=0;i<n-1; i++){ // left boundry
            for (int j=i+1; j<n; j++){ //all possible right boundary
                int h=Math.min(height[i],height[j]);
                int w=j-i;
                int area=h*w;
                maxArea=Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
    public int maxAreaOptimal(int[] nums){
        int n=nums.length;
        int start=0, end=n-1,maxArea=0;
        while (start<end){
            int h=Math.min(nums[start],nums[end]);
            int w = end-start;
            int area=w*h;
            maxArea=Math.max(area,maxArea);
            if (nums[start]<=nums[end])
                start++;
            else
                end--;
        }
        return maxArea;
    }
}

class TestMostWater{
    public static void main(String[] args) {
        int[] height ={1,8,6,2,5,4,8,3,7};
        ContainerMostWater mostWater = new ContainerMostWater();
//        System.out.println(mostWater.maxArea(height));
        System.out.println(mostWater.maxAreaOptimal(height));
    }
}