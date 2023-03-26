import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    
    LinkedList<Transporte> historicoTransporte = new LinkedList<>();
    LinkedList<String> historicoConsultas = new LinkedList<>();
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
                        System.out.println("x---------------------------------------------------------x");
                        System.out.println("|                     Adicionando itens                   |");
                        System.out.println("|                                                         |");
                        System.out.println("|                                                         |");
                        System.out.println("| 1 - Adicionar item.                                     |");
                        System.out.println("| 2 - Consultar itens adicionados.                        |");
                        System.out.println("|                                                         |");
                        System.out.println("| 3 - Concluido.                                0 - Sair. |");
                        System.out.println("x---------------------------------------------------------x");
                        System.out.println(" Selecione uma opção:");

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
                                        System.out.println(transporte.getInfoItens());
                                        System.out.println("\n1 - Concluido                            0 - Sair.");

                                        try{aux = sc.nextInt();}
                                        catch(InputMismatchException e){aux = -1;}
                                        sc.nextLine();

                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                        if(aux == 1){
                                            break;
                                        }
                                        else if(aux == 0){
                                            System.exit(0);
                                        }
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

                                        try{aux = sc.nextInt();}
                                        catch(InputMismatchException e){aux = -1;}

                                        sc.nextLine();

                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                        if(aux == 1){
                                            break;
                                        }
                                        else if(aux == 0){
                                            System.exit(0);
                                        }
                                    }
                                }
                                break;
                            case 3:
                                if(transporte.getQntItens() == 0){
                                    break loopCadastro;
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
                                        System.out.println("| 4 - Concluido.                                0 - Sair. |");
                                        System.out.println("x---------------------------------------------------------x");
                                        System.out.println(" Selecione uma opção:");

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

                                                
                                                try{
                                                    aux = Integer.parseInt(nomeCidade);
                                                    if(aux == 0){
                                                        System.exit(0);
                                                    }     
                                                }catch(NumberFormatException e){aux = -1;}  

                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    
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

                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 1){
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
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

                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 1){
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
                                                        System.out.println(transporte.getTrajeto());
                                                        System.out.println("\n\n1 - Concluido                            0 - Sair.");

                                                        
                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 1){
                                                            break;
                                                        }
                                                        else if(aux == 0){
                                                            System.exit(0);
                                                        }
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

                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                        if(aux == 1){
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
                                                    System.out.println(transporte.getListaCidades());
                                                    System.out.println("\n\n1 - Concluido                            0 - Sair.");

                                                    try{aux = sc.nextInt();}
                                                    catch(InputMismatchException e){aux = -1;}

                                                    sc.nextLine();
                                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                                    if(aux == 1){
                                                        break;
                                                    }
                                                    else if(aux == 0){
                                                        System.exit(0);
                                                    }
                                                }
                                                break;
                                            case 4:
                                                if(transporte.getQntCidades() == 0){
                                                    break loopCadastro;
                                                }
                                                else{
                                                    historicoTransporte.add(transporte);
                                                    while(true){
                                                        System.out.println("x---------------------------------------------------------x");
                                                        System.out.println("|                   Cadastro de transporte                |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| O transporte foi cadastrado com sucesso!                |");
                                                        System.out.println("|                                                         |");
                                                        System.out.println("| 1 - Continuar. 2 - Visualizar.                0 - Sair. |");
                                                        System.out.println("x---------------------------------------------------------x");
        
                                                        try{aux = sc.nextInt();}
                                                        catch(InputMismatchException e){aux = -1;}

                                                        sc.nextLine();
                                                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
                                                        if(aux == 1){
                                                            break loopCadastro;
                                                        }
                                                        else if(aux == 2){
                                                            while(true){
                                                                System.out.println(transporte.getInfo());
                                                                System.out.println("\n\n1 - Concluido                            0 - Sair.");
                                                                
                                                                try{aux = sc.nextInt();}
                                                                catch(InputMismatchException e){aux = -1;}

                                                                sc.nextLine();

                                                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                                                if(aux == 1){
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
                                            case 0:
                                                System.exit(0);
                                        }
                                    }
                                }
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
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                   Consulta de Trajeto                   |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| Digite o nome da cidade de PARTIDA.                     |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                               0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println(" Nome: ");

                            nomeCidade1 = sc.nextLine();
                            
                            try{
                                aux = Integer.parseInt(nomeCidade1);
                                if(aux == 0){
                                    System.exit(0);
                                }     
                            }catch(NumberFormatException e){}  

                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
                            aux = consulta.addCidade(nomeCidade1);

                            if(aux == 2){
                                while(true){
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                   Consulta de Trajeto                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| Essa cidade nao existe! Consulte a lista completa.      |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| 1 - Continuar. 2 - Voltar.                    0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 1){
                                        break;
                                    }
                                    else if(aux == 2){
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
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                   Consulta de Trajeto                   |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| Digite o nome da cidade de DESTINO.                     |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                               0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println(" Nome: ");

                            nomeCidade2 = sc.nextLine();
                            
                            try{
                                aux = Integer.parseInt(nomeCidade2);
                                if(aux == 0){
                                    System.exit(0);
                                }     
                            }catch(NumberFormatException e){}  

                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            
                            aux = consulta.addCidade(nomeCidade2);

                            if(aux == 1){
                                while(true){
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                   Consulta de Trajeto                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| A cidade nao pode ser a mesma de partida!               |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| 1 - Continuar. 2 - Voltar.                    0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 1){
                                        break;
                                    }
                                    else if(aux == 2){
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
                                    System.out.println("x---------------------------------------------------------x");
                                    System.out.println("|                   Consulta de Trajeto                   |");
                                    System.out.println("|                                                         |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| Essa cidade nao existe! Consulte a lista completa.      |");
                                    System.out.println("|                                                         |");
                                    System.out.println("| 1 - Continuar. 2 - Voltar.                    0 - Sair. |");
                                    System.out.println("x---------------------------------------------------------x");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 1){
                                        break;
                                    }
                                    else if(aux == 2){
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
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                       Modalidade                        |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| Seleciona o tipo de modalidade do trajeto:              |");
                            System.out.println("| 1 - Caminhao de pequeno porte.                          |");
                            System.out.println("| 2 - Caminhao de medio porte.                            |");
                            System.out.println("| 3 - Caminhao de grande porte.                           |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                               0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println(" Selecione uma opção:");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            String info = "";

                            if(aux == 1){
                                while(true){
                                    info = "-----------------------------\n" +
                                    nomeCidade1.toUpperCase() + " ---> " + nomeCidade2.toUpperCase() + 
                                    "\n\nDistancia: " + consulta.getDistanciaTotal() + "km" +
                                    "\nCusto: R$" + String.format("%.2f", consulta.calculaPequeno(distancia)) +
                                    "\nModalidade: Caminhao de pequeno porte." + 
                                    "\n-----------------------------";
                                    System.out.println(info);
                                    System.out.println("\n\n1 - Concluido                            0 - Sair.");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 1){
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
                                    info = "-----------------------------\n" +
                                    nomeCidade1.toUpperCase() + " ---> " + nomeCidade2.toUpperCase() + 
                                    "\n\nDistancia: " + consulta.getDistanciaTotal() + "km" +
                                    "\nCusto: R$" + String.format("%.2f", consulta.calculaMedio(distancia)) +
                                    "\nModalidade: Caminhao de medio porte." +
                                    "\n-----------------------------";
                                    System.out.println(info);
                                    System.out.println("\n\n1 - Concluido                            0 - Sair.");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 1){
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
                                    info = "-----------------------------\n" +
                                    nomeCidade1.toUpperCase() + " ---> " + nomeCidade2.toUpperCase() + 
                                    "\n\nDistancia: " + consulta.getDistanciaTotal() + "km" +
                                    "\nCusto: R$" + String.format("%.2f", consulta.calculaGrande(distancia)) +
                                    "\nModalidade: Caminhao de grande porte." +
                                    "\n-----------------------------";
                                    System.out.println(info);
                                    System.out.println("\n\n1 - Concluido                            0 - Sair.");

                                    try{aux = sc.nextInt();}
                                    catch(InputMismatchException e){aux = -1;}

                                    sc.nextLine();
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                                    if(aux == 1){
                                        break;
                                    }
                                    else if(aux == 0){
                                        System.exit(0);
                                    }
                                }
                                historicoConsultas.add(info);
                                break loopConsulta;
                            }
                        }
                    }
                    break;
                case 3:
                    if(historicoTransporte.size() == 0){
                        while(true){
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                 Historico de Transporte                 |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| O histórico esta vazio!                                 |");
                            System.out.println("|                                                         |");
                            System.out.println("| 1 - Continuar.                                0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            if(aux == 1){
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
                            int i = 1;
                            for (Transporte objeto : historicoTransporte) {
                                System.out.println("Transporte " + i++ + ":\n");
                                System.out.println(objeto.getInfo());
                                System.out.println("\n\n");
                            }
                            System.out.println("1 - Concluido                            0 - Sair.");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            if(aux == 1){
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
                            System.out.println("x---------------------------------------------------------x");
                            System.out.println("|                 Historico de Consultas                  |");
                            System.out.println("|                                                         |");
                            System.out.println("|                                                         |");
                            System.out.println("| O histórico esta vazio!                                 |");
                            System.out.println("|                                                         |");
                            System.out.println("| 1 - Continuar.                                0 - Sair. |");
                            System.out.println("x---------------------------------------------------------x");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            if(aux == 1){
                                break;
                            }
                            else if(aux == 0){
                                System.exit(0);
                            }
                        }
                    }
                    else{
                        while(true){
                            int i = 1;
                            for (String string : historicoConsultas) {
                                System.out.println("Consulta " + i++ + ":\n");
                                System.out.println(string);
                                System.out.println("\n\n");
                            }
                            System.out.println("1 - Concluido                            0 - Sair.");

                            try{aux = sc.nextInt();}
                            catch(InputMismatchException e){aux = -1;}

                            sc.nextLine();
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            if(aux == 1){
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
            }
        }
    }
}
