package error;

public class DifferentNumberError extends Error{
    public DifferentNumberError() {
        super("Числа разного формата");
    }
}
