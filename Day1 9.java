class Solution {
public:
    bool isPalindrome(int x) {
        // Negative numbers are not palindromes.
        // Numbers ending in 0 (except 0 itself) are also not palindromes.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // When length is odd, we can get rid of the middle digit via reversedHalf / 10
        // (e.g., for 121, at the end x = 1, reversedHalf = 12, so 1 == 12 / 10)
        return x == reversedHalf || x == reversedHalf / 10;
    }
};
