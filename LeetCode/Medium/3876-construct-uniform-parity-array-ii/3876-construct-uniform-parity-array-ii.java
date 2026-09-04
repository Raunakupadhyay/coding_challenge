class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;

        for(int num : nums1) {
            if(num %2 == 1) {
                minOdd = Math.min(minOdd,num); 
            }
        }
        for(int num : nums1) {
            if(num %2 == 0 && minOdd != Integer.MAX_VALUE && num < minOdd) {
                return false;
            }
        }
        return true;
    }
}