class Solution {
    class Pair{
        int value;
        int index;

        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        if(length == 0) return new int[0];

        int[] result = new int[length];
        Stack<Pair> stack = new Stack<>();
        for(int i = 0; i < length; i++){
            int currentTemperature = temperatures[i];
            while(!stack.isEmpty() && currentTemperature > stack.peek().value){
                Pair p = stack.pop();
                result[p.index] = i - p.index;
            }
            stack.push(new Pair(currentTemperature, i));
        }
        return result;
    }
}
