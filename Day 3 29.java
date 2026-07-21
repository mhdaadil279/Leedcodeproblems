class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        // Determine sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to negative numbers to prevent overflow when converting MIN_VALUE to positive
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Exponential subtraction using bit shifts
        while (a <= b) {
            int tempDivisor = b;
            int multiple = 1;

            // Double the divisor until it exceeds 'a' or overflows
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && a <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            a -= tempDivisor;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
