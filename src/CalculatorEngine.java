import Interfaces.Engine;
import error.ZeroNumberError;

public class CalculatorEngine implements Engine {
    @Override
    public int applyExpression(String operat, Integer a, Integer b) {
        switch (operat) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0 || a == 0)
                    throw new ZeroNumberError();
                return a / b;
        }
        return 0;
    }
}
