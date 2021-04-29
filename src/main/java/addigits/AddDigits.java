package addigits;

public class AddDigits {

    public int addDigits(String input) {
        int result = 0;
        String num = null;
        if (input == null || input.length() == 0) {
            result = -1;
        } else {
             if (input.length() > 0) {
                for (Character c : input.toCharArray()) {
                    if (Character.isDigit(c)) {
                        num = c.toString();
                        result = result + Integer.parseInt(num);
                    }
                }
            }
        }
        return result;
    }

}
