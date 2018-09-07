public class RomanToInteger {
	public int romanToInt(String s) {
		if (null == s || s.length() == 0) {
            throw new IllegalArgumentException("Wrong parameter!");
        }
        int result = 0;
        if (s.indexOf("IV") != -1) { result -= 2;}
        if (s.indexOf("IX") != -1) { result -= 2;}
        if (s.indexOf("XL") != -1) { result -= 20;}
        if (s.indexOf("XC") != -1) { result -= 20;}
        if (s.indexOf("CD") != -1) { result -= 200;}
        if (s.indexOf("CM") != -1) { result -= 200;}

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'I') { result += 1;}
            if (charArray[i] == 'V') { result += 5;}
            if (charArray[i] == 'X') { result += 10;}
            if (charArray[i] == 'L') { result += 50;}
            if (charArray[i] == 'C') { result += 100;}
            if (charArray[i] == 'D') { result += 500;}
            if (charArray[i] == 'M') { result += 1000;}
        }
        if (result < 1 || result > 3999) {
            throw new IllegalArgumentException("Wrong parameter!");
        }
        return result;
    }
}