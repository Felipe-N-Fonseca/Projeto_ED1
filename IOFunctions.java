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

    public static int choice() { // Salva a choice do usuario
        Show_Menu();
        Scanner scan = new Scanner(System.in);
        System.out.print("\n                        Escolha uma opção: ");
        int choice = Integer.parseInt(scan.nextLine());
        while (choice > 5 || choice < 1) {
            Show_Menu();
            System.out.print("\nOpção inválida, digite novamente: ");
            choice = Integer.parseInt(scan.nextLine());
        }
        return choice;
    }

}