/*
               Estruturas de Dados I

                  INTEGRANTES:
        NOME                            TIA
Anderson Nicodemo                       32285671
Felipe do Nascimento Fonseca            42215366
Giovanni Alves Lavia                    42218365
Gustavo Garabetti Munhoz                42211956
Turma: 03N12

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IOFunctions {
    public static void Show_Menu() { // Realiza a leitura do menu através de um TXT
        File file = new File("Menu.txt");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) System.out.println(scan.nextLine());
            scan.close();
        } catch (FileNotFoundException err) {
            System.out.println("Error opening file:" + err.getMessage());
        }
    }

    public static int choice() {
        Show_Menu(); // Imprime o menu
        Scanner scan = new Scanner(System.in);
        System.out.print("\n                        Escolha uma opção: ");
        int choice = Integer.parseInt(scan.nextLine()); // Recebe a escolha do usuário
        while (choice > 5 || choice < 1) {
            Show_Menu();
            System.out.print("\nOpção inválida, digite novamente: "); // Se a escolha for inválida, a mensagem é impressa novamente
            choice = Integer.parseInt(scan.nextLine());
        }
        return choice; // Retorna a escolha válida
    }
}
