class Solution {
    public int evalRPN(String[] tokens) {
        int length = tokens.length;
        if(length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(token.equals("+")){
                    stack.push(num1+num2);
                }
                else if(token.equals("-")){
                    stack.push(num2-num1);
                }
                else if(token.equals("*")){
                    stack.push(num1 * num2);
                }
                else if(token.equals("/")){
                    stack.push(num2/num1);
                }
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
