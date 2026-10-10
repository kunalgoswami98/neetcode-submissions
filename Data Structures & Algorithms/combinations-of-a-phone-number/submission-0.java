class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> numberMapper = new HashMap<>();
        numberMapper.put('2',"abc");
        numberMapper.put('3',"def");
        numberMapper.put('4',"ghi");
        numberMapper.put('5',"jkl");
        numberMapper.put('6',"mno");
        numberMapper.put('7',"pqrs");
        numberMapper.put('8',"tuv");
        numberMapper.put('9',"wxyz");

        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        solve(digits,new StringBuilder(), 0, result, numberMapper);
        return result;
    }
    private void solve(String digits, StringBuilder str, int index, List<String> result,
    Map<Character,String> numberMapper){
        if(str.length() == digits.length()){
            result.add(str.toString());
            return;
        }
        String word = numberMapper.get(digits.charAt(index));
        for(int i = 0; i < word.length(); i++){
            str.append(word.charAt(i));
            solve(digits,str,index+1,result,numberMapper);
            str.deleteCharAt(str.length()-1);
        }
    }
}
