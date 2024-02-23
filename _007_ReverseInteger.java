class _007_ReverseInteger {
    public static void main(String[] args) {
        int result = reverse(-2147483648);
        System.out.println(result);
    }

    public static int reverse(int x) {
        double result = 0;
        int length = 0;
        int tmp = x;
        int i = 1;

        while (tmp != 0) {
            tmp = tmp / 10;
            length++;
        }

        do {
            tmp = x % ((int) Math.pow(10, i));
            int digit = (int) (tmp / Math.pow(10, i - 1));
            i++;
            result += digit * Math.pow(10, --length);
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        } while (tmp != x);
        return (int) result;
    }
}

