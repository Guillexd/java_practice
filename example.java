import java.util.Scanner;

public class example {

    public static void main(String[] args) {
        System.out.println("Escribe algo ...");
        Scanner console = new Scanner(System.in);
        var message = console.nextLine();
        System.out.println(message);
        console.close();
    }
}