import error.NumberError;

import java.util.*;

public class RomanNumbers {


    public static int transformationRomanToNumber(String ir) {
        Map<Character, Integer> map = new HashMap<>(7);
        {
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }
        int sum = 0;
        for (int i = 0; i < ir.length() - 1; i++) {
            if (map.get(ir.charAt(i)) < map.get(ir.charAt(i + 1))) {
                sum -= map.get(ir.charAt(i));
            } else {
                sum += map.get(ir.charAt(i));
            }
        }
        sum += map.get(ir.charAt(ir.length() - 1));
        if(sum > 10 && sum < 0) {
            throw new NumberError();
        } else {
            return sum;
        }
    }

    public static String transformNumberToRoman(Integer num) {
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
         {
            map.put(1000, "M");
            map.put(900, "CM");
            map.put(500, "D");
            map.put(400, "CD");
            map.put(100, "C");
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(1, "I");
        }
        StringBuilder roman = new StringBuilder("");
        for (Integer i: map.keySet()) {
            for (int j = 1; j <= num / i; j++) {
                roman.append(map.get(i));
            }
            num %= i;
        }
        return roman.toString();
    }

    public static Boolean checkNumber(String ir) {
        return ir.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }
}
