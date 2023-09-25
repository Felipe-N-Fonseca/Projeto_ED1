import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IOFunctions {
    public static void Show_Menu() { // Realiza a leitura do menu através de um TXT
        File file = new File("Menu.txt");

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine())
                System.out.println(scan.nextLine());

            scan.close();
        } catch (FileNotFoundException err) {
            System.out.println("Error opening file:" + err.getMessage());
        }
    }

    public static int choice() { // Salva a choice(escolha) do usuario
        Show_Menu(); // Imprime o menu
        Scanner scan = new Scanner(System.in);
        System.out.print("\n                        Escolha uma opção: "); // Imprime esta mensagem solicitando uma opção ao usuário
        int choice = Integer.parseInt(scan.nextLine());
        while (choice > 5 || choice < 1) {
            Show_Menu();
            System.out.print("\nOpção inválida, digite novamente: "); // Se a escolha for menor que 1 ou maior que 5, imprime esta mensagem
            choice = Integer.parseInt(scan.nextLine());
        }
        return choice; // Retorna a choice(escolha)
    }
}
