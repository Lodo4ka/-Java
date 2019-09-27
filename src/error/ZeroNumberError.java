package error;

public class ZeroNumberError extends Error {
    public ZeroNumberError() {
        super("Нельзя быть нулем так и делить на ноль");
    }
}
