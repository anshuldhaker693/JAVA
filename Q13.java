class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Remove leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        long result = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            result = result * 10 + digit;

            // Overflow check
            if (sign * result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign * result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(sign * result);
    }
}