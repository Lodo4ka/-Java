import Interfaces.CalcExecutor;
import error.DifferentNumberError;
import error.FormatError;
import error.NewLIneError;
import error.NumberError;

import java.util.*;

public class Calculator implements CalcExecutor {

    private String expression = "";
    Stack<String> operators = new Stack<>();
    List<Integer> valuesArabian = new ArrayList<>();
    List<Integer> valuesRoman = new ArrayList<>();
    CalculatorEngine engine = new CalculatorEngine();


    public Calculator(String expression) {
        this.expression = expression;
    }

    @Override
    public String executeExpression() {

        if (expression.contains("\n") || expression.contains("\\n")) throw new NewLIneError();
        String result = "";
        String[] stringsSplit = expression.split(" ");

        for (String string : stringsSplit) {
            try {
                int digit = Integer.parseInt(string);
                if (1 <= digit && digit <= 10) {
                    valuesArabian.add(digit);
                } else {
                    throw new NumberError();
                }
            } catch (NumberFormatException e) {
                if (string.equals("/") || string.equals("+") || string.equals("-") || string.equals("*")) {
                    operators.add(string);
                } else if (RomanNumbers.checkNumber(string)) {
                    valuesRoman.add(RomanNumbers.transformationRomanToNumber(string));
                } else {
                    throw new FormatError();
                }
            }
        }

        if (valuesRoman.size() == 1 || valuesArabian.size() == 1) {
            throw new DifferentNumberError();
        }

        while (!operators.empty()) {
            if (valuesArabian.size() != 0) {

                for (int i = 0; i < valuesArabian.size() - 1; i++) {
                    if (valuesArabian.get(i + 1) != null) {
                        result = Integer.toString(engine.applyExpression(operators.pop(),
                                valuesArabian.get(i), valuesArabian.get(i + 1)));
                    } else continue;
                }

            } else if (valuesRoman.size() != 0) {

                for (int i = 0; i < valuesRoman.size() - 1; i++) {
                    if (valuesRoman.get(i + 1) != null) {
                        result = RomanNumbers.transformNumberToRoman(engine.applyExpression(operators.pop(),
                                valuesRoman.get(i), valuesRoman.get(i + 1)));
                    } else continue;
                }

            }

        }
        return result;
    }
}
