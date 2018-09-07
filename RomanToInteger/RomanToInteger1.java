public class RomanToInteger1 {
    public static final Map<Character, Integer> romanMap = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };
    
    public int romanToInt(String s) {
        if(null == s || s.length() == 0) {
            throw new IllegalArgumentException("Wrong parameter!");
        }
        int len = s.length(), result = romanMap.get(s.charAt(len - 1));
        for(int i = len - 2; i >= 0; i--) {
            if(romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i + 1))) {
                result += romanMap.get(s.charAt(i));
            } else {
                result -= romanMap.get(s.charAt(i));
            }
        }
        return result;
    }
}
