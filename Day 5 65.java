class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } 
            else if (c == '+' || c == '-') {
                // Sign is only allowed at the beginning
                // or immediately after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            else if (c == '.') {
                // Dot can appear only once and before exponent
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } 
            else if (c == 'e' || c == 'E') {
                // Exponent can appear only once and only after a digit
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false; // Must see a digit after exponent
            } 
            else {
                return false;
            }
        }

        return seenDigit;
    }
}
