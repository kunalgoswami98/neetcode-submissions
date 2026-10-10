class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if(length1 > length2) return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int high = length1;

        while(low <= high){
            int partitionX = (high+low)/2;
            int partitionY = (length1 + length2 + 1)/2 - partitionX;

            int maxLeftX = partitionX <= 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = partitionX >= length1 ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY <= 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = partitionY >= length2 ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((length1+length2) % 2 == 0){
                    return (double)(Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/(double)2;
                }
                else{
                    return (double)Math.max(maxLeftX,maxLeftY);
                }
            }
            else if(maxLeftX > minRightY){
                high = partitionX - 1;
            }
            else low = partitionX + 1;
        }
        return -1;
    }
}
