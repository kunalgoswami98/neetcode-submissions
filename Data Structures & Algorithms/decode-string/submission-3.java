class Solution {
    private int index;

    public String decodeString(String s) {
        index = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder result = new StringBuilder();

        while (index < s.length() && s.charAt(index) != ']') {
            char ch = s.charAt(index);

            if (Character.isLetter(ch)) {
                result.append(ch);
                index++;
            } else {
                // Read the complete number
                int repeat = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    repeat = repeat * 10 + (s.charAt(index) - '0');
                    index++;
                }

                // Skip '['
                index++;

                // Decode the contents inside the brackets
                String inner = decode(s);

                // Skip ']'
                index++;

                for (int i = 0; i < repeat; i++) {
                    result.append(inner);
                }
            }
        }

        return result.toString();
    }
}