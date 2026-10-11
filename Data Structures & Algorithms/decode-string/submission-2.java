class Solution {
    public String decodeString(String s) {
        int length = s.length();
        return decodeStringRecur(s,0);
    }

    private String decodeStringRecur(String s, int index) {
        if(index >= s.length()) return "";
        
        int i = index;
        StringBuilder builder = new StringBuilder();
        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch == ']') return builder.toString();
            if(Character.isDigit(ch)){
                StringBuilder number = new StringBuilder();
                while(Character.isDigit(s.charAt(i))){
                    number.append(s.charAt(i));
                    i++;
                }
                int iterations = Integer.parseInt(number.toString());
                String str = decodeStringRecur(s, i+1);
                for(int j = 0; j < iterations; j++){
                    builder.append(str);
                }
                i++;
                Stack<Character> stack = new Stack<>();
                stack.push(s.charAt(i));
                i++;
                while(i < s.length() && !stack.isEmpty()){
                    char c = s.charAt(i);
                    if(c == '[') stack.push(c);
                    else if(c == ']') stack.pop();
                    i++;
                }

            }
            else{
                builder.append(ch);
                i++;
            }
        }
        return builder.toString();
    }
}