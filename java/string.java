import java.util.*;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int n = num1.length();
        int m = num2.length();
        // The maximum possible length of the product is n + m
        int[] res = new int[n + m];

        // Multiply each digit and add to the corresponding position
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;     // Carry position
                int p2 = i + j + 1; // Current position
                
                int sum = mul + res[p2];

                res[p2] = sum % 10;   // Units place
                res[p1] += sum / 10;  // Carry to the next place
            }
        }

        // Convert the integer array back to a string using StringBuilder
        StringBuilder result = new StringBuilder();
        for (int num : res) {
            // Skip leading zeros
            if (!(result.length() == 0 && num == 0)) {
                result.append(num);
            }
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
