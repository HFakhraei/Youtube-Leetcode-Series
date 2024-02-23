
public class _125_ValidPalindrome {
    public static void main(String[] args) {
        boolean result = isPalindrome("race a car");
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while ( left <= right ) {
            char currLeft = s.charAt(left);
            char currRight = s.charAt(right);
            if ( !isDigitOrLetter(currLeft) ) {
                left++;
            } else {
                if ( !isDigitOrLetter(currRight) ) {
                    right--;
                } else {
                    if ( toLowerCase(currLeft) != toLowerCase(currRight)) {
                        return false;
                    }
                    left++;
                    right--;
                }
            }
        }
        return true;
    }

    private static char toLowerCase(char chr) {
        if (chr > 64 && chr < 91)
            return (char) (chr + 32);
        return chr;
    }

    private static boolean isDigitOrLetter(char chr) {
        if ( chr < 48 || chr > 122 ||
            (chr > 57 && chr < 65) ||
            (chr > 90 && chr < 97))
            return false;
        return true;
    }
}
