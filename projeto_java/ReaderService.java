import java.util.Scanner;

public class ReaderService {

    private Scanner scanner = new Scanner(System.in);

    public String nextLine() {
        return scanner.nextLine();
    }

    public int nextInt() {
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

}
