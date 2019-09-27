package error;

public class NewLIneError extends Error{
    public NewLIneError() {
        super("строка начинается с новой строки");
    }
}
