class Solution {

    public String encode(List<String> input) {
        int inputLength = input.size();

        StringBuilder encodedStringBuilder = new StringBuilder();
        // List<Integer> sizesOfEachString = new ArrayList<>();

        for(String inputSubString : input){
            // sizesOfEachString.add(inputSubString.length());
            encodedStringBuilder.append(inputSubString.length()).append(',');
        }
        encodedStringBuilder.append('*');
        for(String inputSubString: input){
            encodedStringBuilder.append(inputSubString);
        }
        return encodedStringBuilder.toString();
    }

    public List<String> decode(String encodedString) {
        int length = encodedString.length();
        List<String> decodedStrings = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int index = 0;
        while(encodedString.charAt(index) != '*'){
            StringBuilder strBuild = new StringBuilder();
            while(encodedString.charAt(index) != ','){
                strBuild.append(encodedString.charAt(index));
                index++;
            }
            sizes.add(Integer.parseInt(strBuild.toString()));
            index++;
        }
        index++;

        for(Integer size : sizes){
            decodedStrings.add(encodedString.substring(index, index+size));
            index += size;
        }
        return decodedStrings;
    }
}
