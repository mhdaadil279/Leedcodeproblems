class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        
        for (int num : nums) {
            // Count the number of digits using Math.log10
            int digits = (int) Math.log10(num) + 1;
            
            // Check if digit count is even
            if (digits % 2 == 0) {
                count++;
            }
        }
        
        return count;
    }
}
