import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String inputFromUser = reader.readLine();
        Calculator calculator = new Calculator(inputFromUser);
        System.out.println(calculator.executeExpression());
    }
}
