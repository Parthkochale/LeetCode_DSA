class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; // count of unmatched '('
        int add = 0;  // count of insertions needed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else { // c == ')'
                if (open > 0) {
                    open--; // match with previous '('
                } else {
                    add++; // need an extra '('
                }
            }
        }

        // add remaining unmatched '(' that need ')'
        return add + open;
    }
}
