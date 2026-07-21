class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }

        // Case 1: all lowercase
        // Case 2: all uppercase
        // Case 3: only first letter uppercase
        return upperCount == 0 ||
               upperCount == word.length() ||
               (upperCount == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
