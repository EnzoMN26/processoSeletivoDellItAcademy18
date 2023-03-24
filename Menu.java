import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    
    LinkedList<Transporte> historicoTransporte = new LinkedList<>();
    LinkedList<Transporte> historicoConsultas = new LinkedList<>();

    public void start(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("x---------------------------------------------------------x");
            System.out.println("|                   Menu de Transporte                    |");
            System.out.println("|                                                         |");
            System.out.println("|                                                         |");
            System.out.println("| 1 - Cadastrar um transporte.                            |");
            System.out.println("| 2 - Consultar custo de trajeto.                         |");
            System.out.println("| 3 - Histórico de transportes.                           |");
            System.out.println("| 0 - Sair.                                               |");
            System.out.println("|                                                         |");
            System.out.println("| Selecione uma opção:                                    |");
            System.out.println("x---------------------------------------------------------x");
            
            int opcao1 = sc.nextInt();

            switch(opcao1){

                case 1:
                    Transporte transporte = new Transporte();
                    System.out.println("x---------------------------------------------------------x");
                    System.out.println("|                   Menu de Transporte                    |");
                    System.out.println("|                                                         |");
                    System.out.println("|                                                         |");
                    System.out.println("| 1 - Cadastrar um transporte.                            |");
                    System.out.println("| 2 - Consultar custo de trajeto.                         |");
                    System.out.println("| 3 - Histórico de transportes.                           |");
                    System.out.println("| 0 - Sair.                                               |");
                    System.out.println("|                                                         |");
                    System.out.println("| Selecione uma opção:                                    |");
                    System.out.println("x---------------------------------------------------------x");
            }
        }

    }
}
