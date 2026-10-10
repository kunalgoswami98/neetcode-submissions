class Solution {
    class Pair{
        int position;
        double time;

        Pair(int position, double time){
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        Pair[] pairs = new Pair[length];
        int index = 0;
        for(int i = 0; i < length; i++){
            pairs[index++] = new Pair(position[i], (double)(target-position[i])/speed[i]);
        }
        Arrays.sort(pairs, (a,b)-> a.position - b.position);
        int fleet = 0;
        double prevTime = 0;
        for(int i = length-1; i >= 0; i--){
            double currentTime = pairs[i].time;

            if(prevTime < currentTime){
                fleet++;
                prevTime = currentTime;
            }
        }
        return fleet;
    }
}
