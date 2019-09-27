package error;

public class NumberError extends Error {
    public NumberError() {
        super("числа выходят за данный диапазон");
    }
}
