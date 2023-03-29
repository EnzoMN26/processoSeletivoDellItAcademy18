import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Transporte {
    
    private double pesoTotal; //Peso total dos itens.
    private double custoTotal;  //Custo total do transporte.
    private int distanciaTotal; //Distancia total do transporte
    private int qntTotalItens; //Quantidade total de itens transportados.
    private ArrayList<String> cidades; //Armazena todas as cidades do trajeto;
    private ArrayList<String[]> itens; //Armazena todos os itens, com suas quantidades e pesos.
    private ArrayList<Double[]> custoTrechos; //Armazena o custo de cada caminhao e o custo total de cada trecho.
    private ArrayList<ArrayList<String>> itensPorTrecho; //Armazena os itens que sao levados em cada trecho.
    private ArrayList<Integer[]> caminhoesPorTrecho; //Armazena a quantidade de caminhoes em cada trecho.
    private Caminhao caminhaoPequeno; //Caminhao de capacidade 1 tonelada.
    private Caminhao caminhaoMedio; //Caminhao de capacidade 4 toneladas.
    private Caminhao caminhaoGrande; //Caminhao de capacidade 10 toneladas.
    private LeitorDados leitor; //Objeto que realiza a leitura dos dados.
    


    //Construtor inicializa as variaveis e objetos. Inicializa e executa o leitor de dados.
    public Transporte(){

        this.pesoTotal = 0;
        this.custoTotal = 0;
        this.distanciaTotal = 0;
        this.qntTotalItens = 0;
        this.cidades = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.custoTrechos = new ArrayList<>();
        this.itensPorTrecho = new ArrayList<>();
        this.caminhoesPorTrecho = new ArrayList<>();
        this.caminhaoPequeno = new Caminhao(4.87);
        this.caminhaoMedio = new Caminhao(11.92);
        this.caminhaoGrande = new Caminhao(27.44);
        this.leitor = new LeitorDados();

        //Chama a funcao que promove a leitura dos dados, caso ocorra algum erro o programa é fechado.
        try{
            leitor.readFile();
        }catch(IOException e){
            System.out.println("Erro na leitura do arquivo csv");
            System.exit(0);
        }
    }
    
    /*Adiciona cidade na lista de caminho, caso a cidade exista e ainda nao tenha sido adicionada retorna 0,
    caso a cidade exista mas ja tenha sido adicionada retorna 1 e caso a cidade nao exista retorna 2.*/
    public int addCidade(String cidade){

        if(leitor.containsCidade(cidade)){
            
            if(!cidades.contains(cidade)){

                cidades.add(cidade);
                int tamanho = cidades.size();

                if(tamanho > 1){ //Faz o calculo do trajeto apenas a partir da segunda cidade adicionada.

                    calculaCaminhoes(); //Promove o calculo da quantidade de caminhoes a cada trajeto criado.
                    int distancia = leitor.getDistancia(cidades.get(tamanho-2), cidade);
                    this.distanciaTotal += distancia;
                    custoTrechos.add(calculaCusto(distancia));
                }
                return 0;
            }
            return 1;
        }
        return 2;
    }

    //Adiciona um item ao transporte e promove o calculo do peso total que sera utilizado no metodo "calculaCaminhoes".
    public void addItem(String nome, int quantidade, double peso){
        String[] temp = new String[3];
        temp[0] = nome;
        temp[1] = ""+quantidade;
        temp[2] = String.format("%.2f", peso);
        this.pesoTotal += quantidade * peso;
        this.qntTotalItens += quantidade;
        this.itens.add(temp);
    }

    //Remove um item do transporte. Utilizado para descarregar.
    public void removeItem(int index, int qnt){
        double resultado = Integer.parseInt(itens.get(index)[1]) - qnt;

        //Se a quantidade solicitada para descarregar foi maior que a quantidade disponivel, o item é excluido do transporte.
        if(resultado <= 0){
            pesoTotal -= Integer.parseInt(itens.get(index)[1])  * Double.parseDouble(itens.get(index)[2].replace(",", "."));
            itens.remove(index); 
        }
        else{
            itens.get(index)[1] = String.format("%.0f", resultado);
            pesoTotal -= qnt * Double.parseDouble(itens.get(index)[2].replace(",", "."));
        }
    }

    //Calcula a menor quantidade de caminhoes necessarias de acordo com o peso total.
    public void calculaCaminhoes(){
        double pesoAtual = pesoTotal;
        caminhaoGrande.setQntCaminhao(0);
        caminhaoMedio.setQntCaminhao(0);
        caminhaoPequeno.setQntCaminhao(0);

        //Logica para o calculo da quantidade de caminhoes.
        if(pesoAtual > 8){

            caminhaoGrande.setQntCaminhao(pesoAtual/10);
            pesoAtual -= caminhaoGrande.getQuantidade() * 10;

            if(pesoAtual > 8){
                caminhaoGrande.addQntCaminhao(1);
                pesoAtual = 0;
            }
        }
        if(pesoAtual > 2){

            caminhaoMedio.setQntCaminhao(pesoAtual/4.0);
            pesoAtual -= caminhaoMedio.getQuantidade() * 4;

            if(caminhaoMedio.getQuantidade() == 0){
                caminhaoMedio.setQntCaminhao(1);
                pesoAtual = 0;
            }
            else if(pesoAtual > 2){
                caminhaoMedio.addQntCaminhao(1);
                pesoAtual = 0;
            }
        }
        if(pesoAtual > 1){
            caminhaoPequeno.setQntCaminhao(2);
        }
        else if(pesoAtual == 1){
            caminhaoPequeno.setQntCaminhao(1);
        }
    }

    /*Calcula os custos e a quantidade de cada caminhao em cada trecho do transporte
      e tambem armazena quais os itens transportados em cada trecho.*/
    public Double[] calculaCusto(int dist){

        Double[] custos = new Double[5];
        Integer[] qntCaminhoes = new Integer[3];
        ArrayList<String> nomeItens = new ArrayList<>();
        int quantidadeItensTrecho = 0;

        //Adiciona os itens que foram transportados em cada trecho.
        for (String[] item : itens) {
            nomeItens.add(item[0]);
            quantidadeItensTrecho += Integer.parseInt(item[1]) ;
        }

        //Adiciona o custo de cada caminhao no trecho em especifico.
        custos[0] = caminhaoPequeno.getCusto(dist);
        custos[1] = caminhaoMedio.getCusto(dist);
        custos[2] = caminhaoGrande.getCusto(dist);
        custos[3] = custos[0] + custos[1] + custos[2]; //Total dos custos.
        custos[4] = custos[3]/quantidadeItensTrecho; //Custo unitario medio dos itens.

        //Adiciona a quantidade de cada caminhao no trecho.
        qntCaminhoes[0] = caminhaoPequeno.getQuantidade();
        qntCaminhoes[1] = caminhaoMedio.getQuantidade();
        qntCaminhoes[2] = caminhaoGrande.getQuantidade();


        itensPorTrecho.add(nomeItens);
        caminhoesPorTrecho.add(qntCaminhoes);

        calculaCustoTotal(custos[3]);

        return custos;
    }

    //Calcula o custo total somando o custo dos trechos.
    private void calculaCustoTotal(double custo){
        this.custoTotal += custo;
    }

    //Calcula o custo de um caminhao pequeno para um distancia especifica.
    public double calculaPequeno(int dist){
        return caminhaoPequeno.getCusto(dist, 1);
    }

    //Calcula o custo de um caminhao medio para um distancia especifica.
    public double calculaMedio(int dist){
        return caminhaoMedio.getCusto(dist, 1);
    }

    //Calcula o custo de um caminhao grande para um distancia especifica.
    public double calculaGrande(int dist){
        return caminhaoGrande.getCusto(dist, 1);
    }

    //Retorna o custo total.
    public double getCustoTotal(){
        return this.custoTotal;
    }

    //Retorna a distancia total.
    public int getDistanciaTotal(){
        return this.distanciaTotal;
    }

    //Retorna a quantidade de itens total.
    public int getQntItens(){
        return this.itens.size();
    }

    //Retorna a quantidade de cidades no trajeto.
    public int getQntCidades(){
        return cidades.size();
    }

    //Responsavel pela tela de descarregamento de itens.
    public String getExcluirItens(){
        String infos = "";
        int i = 1;

        for (String[] iten : itens) {
            infos += "\n" + i + " - " + iten[0].toUpperCase() + " | Quantidade: " + iten[1];
            i++;
        }
        return infos;
    }

    //Retorna a lista completa de cidades existentes.
    public String getListaCidades(){
        LinkedList<String> nomes = leitor.getListaCidades();
        String infos = "Lista de cidades:\n";

        for (String string : nomes) {
            infos += "\n" + string;
        }
        return infos;
    }

    //Retorna os trajetos do transporte.
    public String getTrajeto(){
        String infos = "Trajeto:\n";
        int tamanho = cidades.size();

        if(tamanho == 1){
            infos += "\n" + cidades.get(0).toUpperCase();
        }
        else{            
            for (int i = 0; i < tamanho-1; i++) {
                infos += "\n" + cidades.get(i).toUpperCase() + " ---> " + cidades.get(i+1).toUpperCase();
            }
        }
        return infos;
    }

    //Retorna as informacoes necessarias referentes aos itens.
    public String getInfoItens(){
        String infos = "";
        for (int i = 0; i < itens.size(); i++) {
            infos += "\n" + itens.get(i)[0].toUpperCase() +
                     "\n    Quantidade: " + itens.get(i)[1] + 
                     "\n    Peso: " + itens.get(i)[2] + "kg" +
                     "\n--------------------\n";
        }
        return infos;
    }

    //Retorna as informacoes referentes aos trechos percorridos no transporte.
    public String getInfo(){
        String infos = "";
        for (int i = 0; i < cidades.size()-1; i++) {
            String cidade1 = cidades.get(i).toUpperCase();
            String cidade2 = cidades.get(i+1).toUpperCase();
            infos += "\n" + cidade1 + " --> " + leitor.getDistancia(cidade1, cidade2) + "km --> " + cidade2 + 
            "\n\nCaminhao Pequeno - Custo: R$ " + String.format("%.2f", custoTrechos.get(i)[0])  + " | Quantidade:" + caminhoesPorTrecho.get(i)[0] + 
            "\nCaminhao Medio - Custo: R$ " + String.format("%.2f", custoTrechos.get(i)[1]) + " | Quantidade:" + caminhoesPorTrecho.get(i)[1] + 
            "\nCaminhao Grande - Custo: R$ " + String.format("%.2f", custoTrechos.get(i)[2]) + " | Quantidade:" + caminhoesPorTrecho.get(i)[2] + 
            "\nCusto total do trecho: R$ " + String.format("%.2f", custoTrechos.get(i)[3]) +
            "\nCusto unitario medio dos itens: R$ " + String.format("%.2f", custoTrechos.get(i)[4]);
            if(itensPorTrecho.get(i).size() > 0){
                infos += "\nItens transportados:";
                for (String itens : itensPorTrecho.get(i)) {
                    infos += " | " + itens.toUpperCase();
                }
            }
            infos +=  "\n----------------------\n";
        }
        infos += "Informacoes gerais\n" +
                 "\nTotal de caminhoes pequenos: " + caminhaoPequeno.getQntMaxima() + " veiculos" +
                 "\nTotal de caminhoes medios: " + caminhaoMedio.getQntMaxima() + " veiculos" +
                 "\nTotal de caminhoes grandes: " + caminhaoGrande.getQntMaxima() +" veiculos" +
                 "\nCusto total: R$ " + String.format("%.2f", custoTotal) +
                 "\nPreco medio por km: R$ " + String.format("%.2f", (custoTotal/distanciaTotal)) +
                 "\nQuantidade total de itens transportados: " + qntTotalItens;
                 
        return infos;
    }
}
