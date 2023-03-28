import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/*Essa classe possui todas as telas e tratamentos necessarios para a nao geracao de erros no programa.
 *Ela foi muito bem trabalhada e pensada para nao atrapalhar a experiencia do usuario,
 e servir como um menu de facil interacao e entendimento.
*/

public class Menu {
    
    LinkedList<Transporte> historicoTransporte = new LinkedList<>(); //Armazena os transportes cadastrados.
    LinkedList<String> historicoConsultas = new LinkedList<>(); //Armazena as consultas efetuadas.
    int aux; //Variavel para armazenamento das opcoes selecionadas.

    //Metodo para inicializacao do menu.
    public void start(){
        Scanner sc = new Scanner(System.in);

        while(true){
            //Menu principal da aplicacao.
            System.out.println("x---------------------------------------------------------x");
            System.out.println("|                   Menu de Transporte                    |");
            System.out.println("|                                                         |");
            System.out.println("|                                                         |");
            System.out.println("| 1 - Cadastrar um transporte.                            |");
            System.out.println("| 2 - Consultar custo de trajeto.                         |");
            System.out.println("| 3 - Transportes cadastrados.                            |");
            System.out.println("| 4 - Historico de consultas.                             |");
            System.out.println("|                                               0 - Sair. |");
            System.out.println("x---------------------------------------------------------x");
            System.out.println(" Selecione uma opcao:");
            
            int opcao1 = -1;

            try{opcao1 = sc.nextInt();}
            catch(InputMismatchException e){opcao1 = -1;}

            sc.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            switch(opcao1){

                case 1:
                    Transporte transporte = new Transporte();
                    loopCadastro:
                    while(true){
                        //Menu de adicao de itens ao transporte.
                        System.out.println("x---------------------------------------------------------x");
                        System.out.println("|                     Adicionando itens                   |");
                        System.out.println("|                                                         |");
                        System.out.println("|                                                         |");
                        System.out.println("| 1 - Adicionar item.                                     |");
                        System.out.println("| 2 - Consultar itens adicionados.                        |");
                        System.out.println("|                                                         |");
                        System.out.println("| 5 - Concluido.   6 - Cancelar.                0 - Sair. |");
                        System.out.println("x---------------------------------------------------------x");
                        System.out.println(" Selecione uma opcao:");

                        int opcao2 = -1;

                        try{opcao2 = sc.nextInt();}
                        catch(InputMismatchException e){opcao2 = -1;}

                        sc.nextLine();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                        switch(opcao2){
                            case 1: 
                                String nomeItem;
                                int qntItem = -1;
                                double pesoItem = -1;

                                //Requisicao do nome do item a ser adicionado.
                                System.out.println("x---------------------------------------------------------x");
                                System.out.println("|                     Adicionando itens                   |");
                                System.out.println("|                                                         |");
                                System.out.println("|                                                         |");
                                System.out.println("| Digite o nome do item a ser adicionado.                 |");
                                System.out.println("|                                                         |");
                                System.out.println("|                                               0 - Sair. |");
                                System.out.println("x---------------------------------------------------------x");
                                System.out.println(" Nome: ");

                                nomeItem = sc.nextLine();

                                try{
                                    aux = Integer.parseInt(nomeItem);
                                    if(aux == 0){
                                        System.exit(0);
                                    }     
                                }catch(NumberFormatException e){aux = -1;}            
                                
                                while(true){
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    
                                    //Requisicao da quantidade do item a ser adicionado.
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                     Adicionando itens                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| Digite a quantidade desse item.                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                               0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println(" Quantidade: ");
                                
                                    try{
                                        qntItem = sc.nextInt();
                                        if(qntItem == 0){
                                            System.exit(0);
                                        }
                                        break;
                                    }
                                    catch(InputMismatchException e){qntItem = -1;}  
                                    sc.nextLine();
                                }
                                while(true){
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    //Requisicao do peso do item a ser adicionado.
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                     Adicionando itens                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| Digite o peso desse item. (kg)                          |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                               0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println(" Peso: ");
                                    
                                    try{
                                        pesoItem = sc.nextDouble();
                                        if(pesoItem == 0){
                                            System.exit(0);
                                        }
                                        break;
                                    }
                                    catch(InputMismatchException e){pesoItem = -1;} 
                                    sc.nextLine(); 
                                    
                                }
                                transporte.addItem(nomeItem, qntItem, pesoItem);

                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                break;

                            case 2:      
                                if(transporte.getQntItens() > 0){
                                    while(true){

                                        //Tela para mostrar as informacoes dos itens adicionados ate o momento.
                                        System.out.println(transporte.getInfoItens());
                                        System.out.println("\n5 - Concluido                            0 - Sair.");

                                        try{aux = sc.nextInt();}
                                        catch(InputMismatchException e){aux = -1;}
                                        sc.nextLine();

                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                        if(aux == 5){
                                            break;
                                        }
                                        else if(aux == 0){
                                            System.exit(0);
                                        }
                                    }
                                }
                                else{
                                    while(true){

                                        //Erro de visualizacao dos itens caso nao haja nenhum.
                                        System.out.println("x---------------------------------------------------------x");
                                        System.out.println("|                     Adicionando itens                   |");
                                        System.out.println("|                                                         |");
                                        System.out.println("|                                                         |");
                                        System.out.println("| A lista esta vazia!                                     |");
                                        System.out.println("|                                                         |");
                                        System.out.println("| 5 - Continuar.                                0 - Sair. |");
                                        System.out.println("x---------------------------------------------------------x");

                                        try{aux = sc.nextInt();}
                                        catch(InputMismatchException e){aux = -1;}

                                        sc.nextLine();

                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                        if(aux == 5){
                                            break;
                                        }
                                        else if(aux == 0){
                                            System.exit(0);
                                        }
                                    }
                                }
                                break;
                            case 5:
                                if(transporte.getQntItens() == 0){
                                    while(true){

                                        //Erro caso o transporte tente ser criado sem nenhum item a ser transportado.
                                        System.out.println("x---------------------------------------------------------x");
                                        System.out.println("|                     Adicionando itens                   |");
                                        System.out.println("|                                                         |");
                                        System.out.println("|                                                         |");
                                        System.out.println("| Adicione no minimo um item para continuar!              |");
                                        System.out.println("|                                                         |");
                                        System.out.println("| 5 - Continuar.                                0 - Sair. |");
                                        System.out.println("x---------------------------------------------------------x");

                                        try{aux = sc.nextInt();}
                                        catch(InputMismatchException e){aux = -1;}

                                        sc.nextLine();

                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                        if(aux == 5){
                                            break;
                                        }
                                        else if(aux == 0){
                                            System.exit(0);
                                        }
                                    }
                                    break;
                                }
                                else{
                                    while(true){

                                        //Menu para a adicao de cidades ao transporte.
                                        System.out.println("x---------------------------------------------------------x");
                                        System.out.println("|                   Adicionando cidades                   |");
                                        System.out.println("|                                                         |");
                                        System.out.println("|                                                         |");
                                        System.out.println("| 1 - Adicionar cidade.                                   |");
                                        System.out.println("| 2 - Consultar trajeto atual.                            |");
                                        System.out.println("| 3 - Consultar lista de cidades completas.               |");
                                        System.out.println("|                                                         |");
                                        System.out.println("| 5 - Concluido.   6 - Cancelar.                0 - Sair. |");
                                        System.out.println("x---------------------------------------------------------x");
                                        System.out.println(" Selecione uma opcao:");

                                        try{
                                            opcao2 = sc.nextInt();
                                            if(opcao2 == 0){
                                                System.exit(0);
                                            }
                                        }
                                        catch(InputMismatchException e){opcao2 = -1;}  

                                        sc.nextLine();
                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    
                                        switch(opcao2){
    
                                            case 1:

                                                //Requisicao do nome da cidade a ser adicionada.
                                                System.out.println("x---------------------------------------------------------x");
                                                System.out.println("|                   Adicionando cidades                   |");
                                                System.out.println("|                                                         |");
                                                System.out.println("|                                                         |");
                                                System.out.println("| Digite o nome da cidade a ser adicionada.               |");
                                                System.out.println("|                                                         |");
                                                System.out.println("| 6 - Cancelar                                  0 - Sair. |");
                                                System.out.println("x---------------------------------------------------------x");
                                                System.out.println(" Nome: ");
                                
                                                String nomeCidade = sc.nextLine();

                                                
                                                try{
                                                    aux = Integer.parseInt(nomeCidade);
                                                    if(aux == 0){
                                                        System.exit(0);
                                                    }
                                                    else if(aux == 6){
                                                        break;
                                                    }    
                                                }catch(NumberFormatException e){aux = -1;}  

                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    
                                                int retorno = transporte.addCidade(nomeCidade);
    
                                                if(retorno == 1){
                                                    while(true){

                                                        //Erro caso a cidade ja tenha sido adicionada anteriormente.
                                                        System.out.println("x---------------------------------------------------------x");
                                                        System.out.println("|                  Adicionando cidades                    |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| Essa cidade ja faz parte do trajeto!                    |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| 5 - Continuar.                                0 - Sair. |");
                                                        System.out.println("x---------------------------------------------------------x");

                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 5){
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
                                                    }
                                                }
                                                else if(retorno == 2){
                                                    while(true){

                                                        //Erro caso o nome da cidade nao tenha sido identificado na lista de cidades existentes.
                                                        System.out.println("x---------------------------------------------------------x");
                                                        System.out.println("|                  Adicionando cidades                    |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| Essa cidade nao existe! Consulte a lista completa.      |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| 5 - Continuar.                                0 - Sair. |");
                                                        System.out.println("x---------------------------------------------------------x");

                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 5){
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
                                                    }
                                                }
                                                else if(retorno == 0 && transporte.getQntCidades() > 1 && transporte.getQntItens() > 0){
                                                    excluiItens:
                                                    while(true){

                                                        //Tela de confirmacao de descarregamento de item.
                                                        System.out.println("x---------------------------------------------------------x");
                                                        System.out.println("|                  Adicionando cidades                    |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| Deseja descarregar algum item nessa cidade?             |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| 5 - Sim.   6 - Nao                            0 - Sair. |");
                                                        System.out.println("x---------------------------------------------------------x");

                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 5){
                                                            while(true){

                                                                //Tela para mostrar os itens disponiveis para serem descarregados.
                                                                System.out.println("Selecione o item que deseja descarregar:\n");
                                                                System.out.println(transporte.getExcluirItens());
                                                                System.out.println("\n\n                                       0 - Sair.");
        
                                                                int indexItemExcluir;

                                                                try{indexItemExcluir = sc.nextInt();}
                                                                catch(InputMismatchException e){indexItemExcluir = -1;}
        
                                                                sc.nextLine();
                                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
                                                                if(indexItemExcluir > 0 && indexItemExcluir <= transporte.getQntItens()){
                                                                    int qntItemExcluir;
                                                                    while(true){

                                                                        //Requisicao da quantidade que deve ser descarregada do item.
                                                                        System.out.println("x---------------------------------------------------------x");
                                                                        System.out.println("|                  Descarregando itens                    |");
                                                                        System.out.println("|                                                         |");
                                                                        System.out.println("|                                                         |");
                                                                        System.out.println("| Digite a quantidade que deseja descarregar.             |");
                                                                        System.out.println("|                                                         |");
                                                                        System.out.println("|                                               0 - Sair. |");
                                                                        System.out.println("x---------------------------------------------------------x");

                                                                        try{
                                                                            qntItemExcluir = sc.nextInt();
                                                                            if(qntItemExcluir == 0){
                                                                                System.exit(0);
                                                                            }
                                                                            sc.nextLine();
                                                                            transporte.removeItem(indexItemExcluir-1, qntItemExcluir);
                                                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    
                                                                            break;
                                                                        }
                                                                        catch(InputMismatchException e){qntItemExcluir = -1;}
                                                                        sc.nextLine();
                                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                                    }
                                                                    if(transporte.getQntItens()>0){
                                                                        while(true){

                                                                            //Confirmacao se mais algum item deseja ser descarregado na cidade adicionada.
                                                                            System.out.println("x---------------------------------------------------------x");
                                                                            System.out.println("|                  Descarregando itens                    |");
                                                                            System.out.println("|                                                         |");
                                                                            System.out.println("|                                                         |");
                                                                            System.out.println("| Deseja descarregar mais algum item?                     |");
                                                                            System.out.println("|                                                         |");
                                                                            System.out.println("| 5 - Sim.   6 - Nao.                           0 - Sair. |");
                                                                            System.out.println("x---------------------------------------------------------x");
                    
                                                                            try{aux = sc.nextInt();}
                                                                            catch(InputMismatchException e){aux = -1;}
                    
                                                                            sc.nextLine();
                                                                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    
                                                                            if(aux == 5){
                                                                                break;
                                                                            }
                                                                            else if(aux == 6){
                                                                                break excluiItens;
                                                                            }
                                                                            else if(aux == 0){
                                                                                System.exit(0);
                                                                            }
                                                                        }
                                                                    }
                                                                    else{
                                                                        break excluiItens;
                                                                    }
                                                                }
                                                                else if (indexItemExcluir == 0){
                                                                    System.exit(0);
                                                                }
                                                            }
                                                        }
                                                        else if(aux == 6){
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
                                                    }
                                                }
    
                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                break;
                                            case 2:                                        
                                                if(transporte.getQntCidades() > 0){
                                                    while(true){

                                                        //Tela que apresenta o trajeto construido ate o momento.
                                                        System.out.println(transporte.getTrajeto());
                                                        System.out.println("\n\n5 - Concluido                            0 - Sair.");

                                                        
                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 5){
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
                                                    }
                                                }
                                                else{
                                                    while(true){

                                                        //Erro caso tente verificar o trajeto sem nenhuma cidade adicionada.
                                                        System.out.println("x---------------------------------------------------------x");
                                                        System.out.println("|                   Adicionando cidades                   |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| O trajeto esta vazio!                                   |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| 5 - Continuar.                                0 - Sair. |");
                                                        System.out.println("x---------------------------------------------------------x");

                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 5){
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
                                                    }
                                                }
                                                break;
                                            case 3: 
                                                while(true){

                                                    //Tela que apresenta a lista completa de cidades.
                                                    System.out.println(transporte.getListaCidades());
                                                    System.out.println("\n\n5 - Concluido                            0 - Sair.");

                                                    try{aux = sc.nextInt();}
                                                    catch(InputMismatchException e){aux = -1;}

                                                    sc.nextLine();
                                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                    if(aux == 5){
                                                        break;
                                                    }
                                                    else if(aux == 0){
                                                        System.exit(0);
                                                    }
                                                }
                                                break;
                                            case 5:
                                                if(transporte.getQntCidades()  < 2){
                                                    while(true){

                                                        //Erro caso um transporte tente ser criado com menos de duas cidades.
                                                        System.out.println("x---------------------------------------------------------x");
                                                        System.out.println("|                     Adicionando cidades                 |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| Adicione no minimo duas cidades para continuar!         |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| 5 - Continuar.                                0 - Sair. |");
                                                        System.out.println("x---------------------------------------------------------x");
                
                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}
                
                                                        sc.nextLine();
                
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                
                                                        if(aux == 5){
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
                                                    }
                                                    break;
                                                }
                                                else{
                                                    historicoTransporte.add(transporte);
                                                    while(true){

                                                        //Mensagem para informar o sucesso no cadastro do transporte.
                                                        System.out.println("x---------------------------------------------------------x");
                                                        System.out.println("|                   Cadastro de transporte                |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| O transporte foi cadastrado com sucesso!                |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| 5 - Continuar.   6 - Visualizar.              0 - Sair. |");
                                                        System.out.println("x---------------------------------------------------------x");
        
                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
                                                        if(aux == 5){
                                                            break loopCadastro;
                                                        }
                                                        else if(aux == 6){
                                                            while(true){

                                                                //Tela que apresenta as informacoes do transporte entao cadastrado.
                                                                System.out.println(transporte.getInfo());
                                                                System.out.println("\n\n5 - Concluido                            0 - Sair.");
                                                                
                                                                try{aux = sc.nextInt();}
                                                                catch(InputMismatchException e){aux = -1;}

                                                                sc.nextLine();

                                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                                if(aux == 5){
                                                                    break;
                                                                }
                                                                else if(aux == 0){
                                                                    System.exit(0);
                                                                }
                                                            }
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
                                                    }
                                                    break loopCadastro;
                                                }
                                            case 6:
                                                break loopCadastro;
                                            case 0:
                                                System.exit(0);
                                        }
                                    }
                                }
                            case 6:
                                break loopCadastro;
                            case 0:
                                System.exit(0);
                                break;
                        } 
                    }
                    break;
                case 2:
                    Transporte consulta = new Transporte();
                    String nomeCidade1;
                    String nomeCidade2;
                    loopConsulta:
                    while(true){
                        while(true){

                            //Requisicao do nome da cidade de partida da consulta de trajeto.
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                   Consulta de Trajeto                   |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| Digite o nome da cidade de PARTIDA.                     |");
                            System.out.println("|                                                         |");
                            System.out.println("| 6 - Cancelar.                                 0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println(" Nome: ");

                            nomeCidade1 = sc.nextLine();
                            
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            try{
                                aux = Integer.parseInt(nomeCidade1);
                                if(aux == 0){
                                    System.exit(0);
                                }     
                                if(aux == 6){
                                    break loopConsulta;
                                }
                            }catch(NumberFormatException e){}  
        
                            aux = consulta.addCidade(nomeCidade1);

                            if(aux == 2){
                                while(true){

                                    //Erro caso a cidade mencionada nao esteja na lista de cidades existentes.
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                   Consulta de Trajeto                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| Essa cidade nao existe! Consulte a lista completa.      |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| 5 - Continuar.   6 - Cancelar.                0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 5){
                                        break;
                                    }
                                    else if(aux == 6){
                                        break loopConsulta;
                                    }
                                    else if(aux == 0){
                                        System.exit(0);
                                    }
                                }
                            }
                            else{
                                break;
                            }
                        }
                        while(true){

                            //Requisicao do nome da cidade de destino da consulta de trajeto.
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                   Consulta de Trajeto                   |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| Digite o nome da cidade de DESTINO.                     |");
                            System.out.println("|                                                         |");
                            System.out.println("| 6 - Cancelar.                                 0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println(" Nome: ");

                            nomeCidade2 = sc.nextLine();
                            
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            try{
                                aux = Integer.parseInt(nomeCidade2);
                                if(aux == 0){
                                    System.exit(0);
                                }
                                else if(aux == 6){
                                    break loopConsulta;
                                }
                            }catch(NumberFormatException e){}  
                            
                            aux = consulta.addCidade(nomeCidade2);

                            if(aux == 1){
                                while(true){

                                    //Erro caso a cidade de destino seja a mesma que a de partida.
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                   Consulta de Trajeto                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| A cidade nao pode ser a mesma de partida!               |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| 5 - Continuar.   6 - Cancelar.                0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 5){
                                        break;
                                    }
                                    else if(aux == 6){
                                        break loopConsulta;
                                    }
                                    else if(aux == 0){
                                        System.exit(0);
                                    }
                                }
                                break;
                            }
                            else if(aux == 2){
                                while(true){

                                    //Erro caso a cidade mencionada nao esteja na lista de cidades existentes.
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                   Consulta de Trajeto                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| Essa cidade nao existe! Consulte a lista completa.      |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| 5 - Continuar.   6 - Cancelar.                0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 5){
                                        break;
                                    }
                                    else if(aux == 6){
                                        break loopConsulta;
                                    }
                                    else if(aux == 0){
                                        System.exit(0);
                                    }
                                }
                            }
                            else{
                                break;
                            }
                        }
                        int distancia = consulta.getDistanciaTotal();

                        while(true){

                            //Requisicao do tipo de modalidade que deve ser feita a consulta.
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                       Modalidade                        |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| Seleciona o tipo de modalidade do trajeto:              |");
                            System.out.println("| 1 - Caminhao de pequeno porte.                          |");
                            System.out.println("| 2 - Caminhao de medio porte.                            |");
                            System.out.println("| 3 - Caminhao de grande porte.                           |");
                            System.out.println("|                                                         |");
                            System.out.println("| 6 - Cancelar.                                 0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println(" Selecione uma opcao:");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            String info = "";

                            if(aux == 1){
                                while(true){

                                    //Tela que apresenta as informacoes da consulta de trajeto solicitada.
                                    info = "-----------------------------\n" +
                                    nomeCidade1.toUpperCase() + " ---> " + nomeCidade2.toUpperCase() + 
                                    "\n\nDistancia: " + consulta.getDistanciaTotal() + "km" +
                                    "\nCusto: R$" + String.format("%.2f", consulta.calculaPequeno(distancia)) +
                                    "\nModalidade: Caminhao de pequeno porte." + 
                                    "\n-----------------------------";
                                    System.out.println(info);
                                    System.out.println("\n\n5 - Concluido                            0 - Sair.");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 5){
                                        break;
                                    }
                                    else if(aux == 0){
                                        System.exit(0);
                                    }
                                }
                                historicoConsultas.add(info);
                                break loopConsulta;
                            }
                            else if(aux == 2){
                                while(true){

                                    //Tela que apresenta as informacoes da consulta de trajeto solicitada.
                                    info = "-----------------------------\n" +
                                    nomeCidade1.toUpperCase() + " ---> " + nomeCidade2.toUpperCase() + 
                                    "\n\nDistancia: " + consulta.getDistanciaTotal() + "km" +
                                    "\nCusto: R$" + String.format("%.2f", consulta.calculaMedio(distancia)) +
                                    "\nModalidade: Caminhao de medio porte." +
                                    "\n-----------------------------";
                                    System.out.println(info);
                                    System.out.println("\n\n5 - Concluido                            0 - Sair.");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 5){
                                        break;
                                    }
                                    else if(aux == 0){
                                        System.exit(0);
                                    }
                                }
                                historicoConsultas.add(info);
                                break loopConsulta;
                            }
                            else if(aux == 3){
                                while(true){

                                    //Tela que apresenta as informacoes da consulta de trajeto solicitada.
                                    info = "-----------------------------\n" +
                                    nomeCidade1.toUpperCase() + " ---> " + nomeCidade2.toUpperCase() + 
                                    "\n\nDistancia: " + consulta.getDistanciaTotal() + "km" +
                                    "\nCusto: R$" + String.format("%.2f", consulta.calculaGrande(distancia)) +
                                    "\nModalidade: Caminhao de grande porte." +
                                    "\n-----------------------------";
                                    System.out.println(info);
                                    System.out.println("\n\n5 - Concluido                            0 - Sair.");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 5){
                                        break;
                                    }
                                    else if(aux == 0){
                                        System.exit(0);
                                    }
                                }
                                historicoConsultas.add(info);
                                break loopConsulta;
                            }
                            else if(aux == 6){
                                break loopConsulta;
                            }
                        }
                    }
                    break;
                case 3:
                    if(historicoTransporte.size() == 0){
                        while(true){

                            //Erro caso tente ver os transportes cadastrados e nao haja nenhum.
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                 Transportes Cadastrados                 |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| Nenhum transporte cadastrado!                           |");
                            System.out.println("|                                                         |");
                            System.out.println("| 5 - Continuar.                                0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            if(aux == 5){
                                break;
                            }
                            else if(aux == 0){
                                System.exit(0);
                            }
                        }
                        break;
                    }
                    else{
                        while(true){

                            //Tela que apresenta os transportes cadastrados ate entao.
                            int i = 1;
                            for (Transporte objeto : historicoTransporte) {
                                System.out.println("Transporte " + i++ + ":\n");
                                System.out.println(objeto.getInfo());
                                System.out.println("\n\n");
                            }
                            System.out.println("5 - Concluido                            0 - Sair.");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            if(aux == 5){
                                break;
                            }
                            else if(aux == 0){
                                System.exit(0);
                            }
                        }
                    }
                    break;
                case 4: 
                    if(historicoConsultas.size() == 0){
                        while(true){

                            //Erro caso o historico de consultas esteja vazio.
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                 Historico de Consultas                  |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| O historico esta vazio!                                 |");
                            System.out.println("|                                                         |");
                            System.out.println("| 5 - Continuar.                                0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            if(aux == 5){
                                break;
                            }
                            else if(aux == 0){
                                System.exit(0);
                            }
                        }
                    }
                    else{
                        while(true){

                            //Tela que apresenta as consultas efetuadas ate entao.
                            int i = 1;
                            for (String string : historicoConsultas) {
                                System.out.println("Consulta " + i++ + ":\n");
                                System.out.println(string);
                                System.out.println("\n\n");
                            }
                            System.out.println("5 - Concluido                            0 - Sair.");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            if(aux == 5){
                                break;
                            }
                            else if(aux == 0){
                                System.exit(0);
                            }
                        }
                    }
                    break;
                case 0: 
                System.exit(0);
                sc.close();
            }
        }
    }
}
