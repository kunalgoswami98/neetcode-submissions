class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<>();
        result = new ArrayList<>();
        generateParanthesisRecur(0,0,n,new StringBuilder());
        return result;
    }
    private void generateParanthesisRecur(int openParanthesis, int closedParanthesis, 
        int n, StringBuilder strBuild){
        if(openParanthesis == closedParanthesis &&
            openParanthesis == n){
            result.add(strBuild.toString());
            return;
        }
        if(openParanthesis < n){
            strBuild.append('(');
            generateParanthesisRecur(openParanthesis+1, 
            closedParanthesis, n, strBuild);
            strBuild.deleteCharAt(strBuild.length()-1);
        }
        if(closedParanthesis < openParanthesis){
            strBuild.append(')');
            generateParanthesisRecur(openParanthesis, closedParanthesis+1,
            n, strBuild);
            strBuild.deleteCharAt(strBuild.length()-1);
        }
        
    }
}
