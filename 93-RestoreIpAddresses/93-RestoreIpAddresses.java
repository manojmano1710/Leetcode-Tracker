// Last updated: 09/07/2026, 15:08:54
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts,
                           StringBuilder current,
                           List<String> result) {

        if (parts == 4 && index == s.length()) {
            result.add(current.toString());
            return;
        }

        if (parts == 4 || index == s.length()) {
            return;
        }

        int len = current.length();

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            int value = Integer.parseInt(part);

            if (value <= 255) {
                if (len != 0) {
                    current.append('.');
                }

                current.append(part);

                backtrack(s, index + i, parts + 1, current, result);

                current.setLength(len);
            }
        }
    }
}