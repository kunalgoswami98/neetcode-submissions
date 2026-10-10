class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int pilesLength = piles.length;
        Arrays.sort(piles);
        int minSpeed = 1;
        int maxSpeed = piles[pilesLength-1];

        while(minSpeed <= maxSpeed){
            int currentSpeed = minSpeed + (maxSpeed-minSpeed)/2;

            if(canEat(currentSpeed, piles, h)) maxSpeed = currentSpeed-1;
            else minSpeed = currentSpeed + 1;
        }
        return minSpeed;
    }

    private boolean canEat(int speed, int[] piles, int totalHours){
        int length = piles.length;
        int hoursTaken = 0;
        for(int i = 0; i < length; i++){
            int timeTaken = piles[i]/speed;
            hoursTaken += timeTaken;
            if(piles[i]%speed != 0) hoursTaken += 1;
        }
        return hoursTaken <= totalHours;
    }
}
