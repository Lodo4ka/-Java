package error;

public class FormatError extends Error{
    public FormatError() {
        super("Не могу распознать символ");
    }
}
