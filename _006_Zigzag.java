class _006_Zigzag {
    public static void main(String[] args) {
        String result = convert("PAYPALISHIRING", 4);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        boolean downFlag = true;
        int row=0, column=0, sIndex=0;

        while (sIndex < s.length()) {
            if (downFlag) {
                if (rows[row] == null) {
                    rows[row] = new StringBuilder();
                }
                rows[row].append(s.charAt(sIndex++));
                if (row == numRows - 1) {
                    downFlag = false;
                    column++;
                } else {
                    row++;
                }
            } else {
                row--;
                if (row == 0) {
                    downFlag = true;
                } else {
                    rows[row].append(s.charAt(sIndex++));
                    column++;
                }
            }
        }
        StringBuilder output = new StringBuilder();
        for (StringBuilder sbRow : rows) {
            if (sbRow != null) {
                output.append(sbRow);
            }
        }
        return output.toString();
    }
}

