class _008_StringToInteger {
    public static void main(String[] args) {
        int result = myAtoi("-1");
        System.out.println(result);
    }

    public static int myAtoi(String s) {
        double result = 0;
        int from = 0;
        int to = 0;
        boolean isNegative = false;
        boolean signVisited = false;
        boolean digitVisited = false;

        if (s.length() == 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr >= 48 && curr <= 57) {
                from = i;
                digitVisited = true;
                break;
            }
            if (!(curr == ' ' || curr == '-' || curr == '+')) {
                return 0;
            }
            if (curr == '-' || curr == '+') {
                if (signVisited)
                    return 0;
                signVisited = true;
            }
        }
        to = from;
        for (int i = from + 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr >= 48 & curr <= 57) {
                to += 1;
            } else {
                break;
            }
        }

        if (!digitVisited) {
            return 0;
        }

        if (signVisited) {
            char curr = s.charAt(from - 1);
            if (!(curr == '-' || curr == '+'))
                return 0;
        }

        for (int i = 0; i <= (to - from); i++) {
            char curr = s.charAt(from + i);
            result+= (curr - 48) * Math.pow(10, ((to - from) - i));
        }

        if (from > 0 && '-' == s.charAt(from - 1)) {
            isNegative = true;
        }
        return (int) (isNegative ? -result : result);
    }
}

