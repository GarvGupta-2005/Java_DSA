package TwoPointer_SlidingWindows.Medium;

public class ContainerWithMaxWater {
    //Use two pointer approach to calculate height accordingly and calculate width
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int n = height.length;
        int r = n-1;
        while(l<r){
            int h = Math.min(height[l],height[r]);
            int w = r-l;
             maxArea = Math.max(maxArea,h*w);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
