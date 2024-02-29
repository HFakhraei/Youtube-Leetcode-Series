import java.util.Arrays;

class _392_IsSubsequence {
    public static void main(String[] args) {
        boolean result = isSubsequence("abc", "adrbhjcr");
        System.out.println(result);
    }

    private static boolean isSubsequence(String s, String t) {
        int tP = 0;
        int sP = 0;
        while (sP < s.length() && tP < t.length()) {
            if (s.charAt(sP) == t.charAt(tP)) {
                sP++;
                tP++;
            } else {
                tP++;
            }
        }

        if (sP < s.length())
            return false;
        return true;
    }
}

