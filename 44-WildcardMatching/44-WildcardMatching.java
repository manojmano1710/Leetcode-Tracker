// Last updated: 09/07/2026, 15:11:21
class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0;      // pointer for s
        int j = 0;      // pointer for p
        int star = -1;  // last '*' position in p
        int match = 0;  // position in s corresponding to '*'

        while (i < s.length()) {

            // Characters match or '?'
            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {

                i++;
                j++;
            }

            // Found '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }

            // Mismatch, try to use previous '*'
            else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }

            // No match possible
            else {
                return false;
            }
        }

        // Remaining characters in pattern must all be '*'
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}