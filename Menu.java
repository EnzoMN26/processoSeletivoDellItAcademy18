import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    
    LinkedList<Transporte> historicoTransporte = new LinkedList<>();
    LinkedList<Transporte> historicoConsultas = new LinkedList<>();
    int aux;

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
                                    while(true){
                                        System.out.println(transporte.getInfoItens());
                                        System.out.println("\n\n1 - Concluido                            0 - Sair.");
                                        aux = sc.nextInt();
                                        if(aux == 1){
                                            break;
                                        }
                                        else if(aux == 0){
                                            System.exit(0);
                                        }
                                        System.out.println("\n\n\n\n\n\n\n\n\n");
                                    }
                                }
                                else{
                                    while(true){
                                        System.out.println("x---------------------------------------------------------x");
                                        System.out.println("|                     Adicionando itens                   |");
                                        System.out.println("|                                                         |");
                                        System.out.println("|                                                         |");
                                        System.out.println("| A lista esta vazia!                                     |");
                                        System.out.println("|                                                         |");
                                        System.out.println("| 1 - Continuar.                                0 - Sair. |");
                                        System.out.println("x---------------------------------------------------------x");
                                        aux = sc.nextInt();
                                        if(aux == 1){
                                            break;
                                        }
                                        else if(aux == 0){
                                            System.exit(0);
                                        }
                                        System.out.println("\n\n\n\n\n\n\n\n\n");
                                    }
                                }
                                break;
                            case 0:
                                System.exit(0);
                                break;
                        } 

                        if(opcao2 == 3){
                            if(transporte.getQntItens() == 0){
                                break;
                            }
                            else{
                                while(true){
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                   Adicionando cidades                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| 1 - Adicionar cidade.                                   |");
                                    System.out.println("| 2 - Consultar trajeto atual.                            |");
                                    System.out.println("| 3 - Consultar lista de cidades completas.               |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| 4 - Concluido.                                0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println(" Selecione uma opção:");

                                    opcao2 = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n");

                                    switch(opcao2){

                                        case 1:
                                            System.out.println("x---------------------------------------------------------x");
                                            System.out.println("|                   Adicionando cidades                   |");
                                            System.out.println("|                                                         |");
                                            System.out.println("|                                                         |");
                                            System.out.println("| Digite o nome da cidade a ser adicionada.               |");
                                            System.out.println("|                                                         |");
                                            System.out.println("|                                               0 - Sair. |");
                                            System.out.println("x---------------------------------------------------------x");
                                            System.out.println(" Nome: ");
                            
                                            String nomeCidade = sc.nextLine();
            
                                            if(nomeCidade == "0"){
                                                System.exit(0);
                                            }
                                            System.out.println("\n\n\n\n\n\n\n\n\n");

                                            int retorno = transporte.addCidade(nomeCidade);

                                            if(retorno == 1){
                                                while(true){
                                                    System.out.println("x---------------------------------------------------------x");
                                                    System.out.println("|                   Adicionando cidades                   |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("| Essa cidade ja faz parte do trajeto!                    |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("| 1 - Continuar.                                0 - Sair. |");
                                                    System.out.println("x---------------------------------------------------------x");
                                                    aux = sc.nextInt();
                                                    if(aux == 1){
                                                        break;
                                                    }
                                                    else if(aux == 0){
                                                        System.exit(0);
                                                    }
                                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                                }
                                            }
                                            else if(retorno == 2){
                                                while(true){
                                                    System.out.println("x---------------------------------------------------------x");
                                                    System.out.println("|                   Adicionando cidades                   |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("| Essa cidade nao existe! Consulte a lista completa.      |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("| 1 - Continuar.                                0 - Sair. |");
                                                    System.out.println("x---------------------------------------------------------x");
                                                    aux = sc.nextInt();
                                                    if(aux == 1){
                                                        break;
                                                    }
                                                    else if(aux == 0){
                                                        System.exit(0);
                                                    }
                                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                                }
                                            }

                                            System.out.println("\n\n\n\n\n\n\n\n\n");
                                            break;
                                        case 2:                                        
                                            if(transporte.getQntCidades() > 0){
                                                while(true){
                                                    System.out.println(transporte.getTrajeto());
                                                    System.out.println("\n\n1 - Concluido                            0 - Sair.");
                                                    aux = sc.nextInt();
                                                    if(aux == 1){
                                                        break;
                                                    }
                                                    else if(aux == 0){
                                                        System.exit(0);
                                                    }
                                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                                }
                                            }
                                            else{
                                                while(true){
                                                    System.out.println("x---------------------------------------------------------x");
                                                    System.out.println("|                     Adicionando cidades                 |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("| O trajeto esta vazio!                                   |");
                                                    System.out.println("|                                                         |");
                                                    System.out.println("| 1 - Continuar.                                0 - Sair. |");
                                                    System.out.println("x---------------------------------------------------------x");
                                                    aux = sc.nextInt();
                                                    if(aux == 1){
                                                        break;
                                                    }
                                                    else if(aux == 0){
                                                        System.exit(0);
                                                    }
                                                    System.out.println("\n\n\n\n\n\n\n\n\n");
                                                }
                                            }
                                            break;
                                        case 3: 
                                            while(true){
                                                System.out.println(transporte.getListaCidades());
                                                System.out.println("\n\n1 - Concluido                            0 - Sair.");
                                                aux = sc.nextInt();
                                                if(aux == 1){
                                                    break;
                                                }
                                                else if(aux == 0){
                                                    System.exit(0);
                                                }
                                                System.out.println("\n\n\n\n\n\n\n\n\n");
                                            }
                                            break;
                                    }
                                }
                            }
                        }
                    }
            }
        }
    }
}
