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
            System.out.println("| 3 - Transportes cadastrados.                            |");
            System.out.println("| 4 - Historico de consultas.                             |");
            System.out.println("| 5 - Consultar lista de cidades completa.                |");
            System.out.println("| 0 - Sair.                                               |");
            System.out.println("x---------------------------------------------------------x");
            System.out.println(" Selecione uma opção:");
            
            int opcao1 = sc.nextInt();
            System.out.println("\n\n\n\n\n\n\n\n\n");

            switch(opcao1){

                case 1:
                    Transporte transporte = new Transporte();
                    while(true){
                        System.out.println("x---------------------------------------------------------x");
                        System.out.println("|                     Adicionando itens                   |");
                        System.out.println("|                                                         |");
                        System.out.println("|                                                         |");
                        System.out.println("| 1 - Adicionar item.                                     |");
                        System.out.println("| 2 - Consultar itens adicionados.                        |");
                        System.out.println("|                                                         |");
                        System.out.println("|                                                         |");
                        System.out.println("| 3 - Concluido.                                0 - Sair. |");
                        System.out.println("x---------------------------------------------------------x");
                        System.out.println(" Selecione uma opção:");

                        int opcao2 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("\n\n\n\n\n\n\n\n\n");

                        switch(opcao2){
                            case 1: 
                                System.out.println("x---------------------------------------------------------x");
                                System.out.println("|                     Adicionando itens                   |");
                                System.out.println("|                                                         |");
                                System.out.println("|                                                         |");
                                System.out.println("| Digite o nome do item a ser adicionado.                 |");
                                System.out.println("|                                                         |");
                                System.out.println("|                                               0 - Sair. |");
                                System.out.println("x---------------------------------------------------------x");
                                System.out.println(" Nome: ");
                
                                String nomeItem = sc.nextLine();

                                if(nomeItem == "0"){
                                    System.exit(0);
                                }
                                System.out.println("\n\n\n\n\n\n\n\n\n");

                                System.out.println("x---------------------------------------------------------x");
                                System.out.println("|                     Adicionando itens                   |");
                                System.out.println("|                                                         |");
                                System.out.println("|                                                         |");
                                System.out.println("| Digite a quantidade desse item.                         |");
                                System.out.println("|                                                         |");
                                System.out.println("|                                               0 - Sair. |");
                                System.out.println("x---------------------------------------------------------x");
                                System.out.println(" Quantidade: ");

                                int qntItem = sc.nextInt();

                                if(qntItem == 0){
                                    System.exit(0);
                                }
                                System.out.println("\n\n\n\n\n\n\n\n\n");

                                System.out.println("x---------------------------------------------------------x");
                                System.out.println("|                     Adicionando itens                   |");
                                System.out.println("|                                                         |");
                                System.out.println("|                                                         |");
                                System.out.println("| Digite o peso desse item. (kg)                          |");
                                System.out.println("|                                                         |");
                                System.out.println("|                                               0 - Sair. |");
                                System.out.println("x---------------------------------------------------------x");
                                System.out.println(" Peso: ");
                                
                                double pesoItem = sc.nextDouble();

                                if(pesoItem == 0){
                                    System.exit(0);
                                }

                                transporte.addItem(nomeItem, qntItem, pesoItem);

                                System.out.println("\n\n\n\n\n\n\n\n\n");

                                break;

                            case 2:      
                                if(transporte.getQntItens() > 0){
                                    System.out.println(transporte.getInfoItens());
                                    System.out.println("\n\n1 - Concluido");
                                    while(true){
                                        if(sc.nextInt() == 1){
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 0:
                                System.exit(0);
                        } 

                        if(opcao2 == 3){
                            if(transporte.getQntItens() == 0){
                                break;
                            }
                            else{

                            }
                        }
                    }
            }
        }

    }
}
