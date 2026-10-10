class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if(length == 0) return true;
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;
                char paranthesis = stack.pop();
                if(ch == ')' && paranthesis != '('){
                    return false;
                }
                else if(ch == '}' && paranthesis != '{'){
                    return false;
                }
                else if(ch == ']' && paranthesis != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
