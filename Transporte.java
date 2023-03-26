import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Transporte {
    
    private double pesoTotal; //Peso total dos itens.
    private double custoTotal;  //Custo total do transporte.
    private int distanciaTotal; //Distancia total do transporte
    private ArrayList<Double[]> custoTrechos; //Armazena o custo de cada caminhao e o custo total de cada trecho.
    private ArrayList<String> cidades; //Armazena todas as cidades do trajeto;
    private ArrayList<String[]> itens; //Armazena todos os itens, com suas quantidades e pesos.
    private Caminhao caminhaoPequeno; //Caminhao de capacidade 1 tonelada.
    private Caminhao caminhaoMedio; //Caminhao de capacidade 4 tonelada.
    private Caminhao caminhaoGrande; //Caminhao de capacidade 10 tonelada.
    private LeitorDados leitor; //Objeto que realiza a leitura dos dados.


    //Construtor inicializa as variaveis e objetos e promove a leitura dos dados.
    public Transporte(){

        this.pesoTotal = 0;
        this.custoTotal = 0;
        this.distanciaTotal = 0;
        this.custoTrechos = new ArrayList<>();
        this.cidades = new ArrayList<>();
        this.itens = new ArrayList<>();
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

                if(tamanho > 1){
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

    //Adiciona um produto ao transporte e promove o calculo do peso total que sera usado no metodo "calcula".
    public void addItem(String nome, int quantidade, double peso){
        String[] temp = new String[3];
        temp[0] = nome;
        temp[1] = ""+quantidade;
        temp[2] = String.format("%.2f", peso);
        this.pesoTotal += quantidade * peso;
        this.itens.add(temp);
        calculaCaminhoes();
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

    //Calcula os custos de cada caminhao em cada trecho do transporte e tambem acrescenta ao valor do custo total.
    public Double[] calculaCusto(int dist){

        Double[] custos = new Double[4];

        //Adiciona o custo de cada caminhao no trecho em especifico.
        custos[0] = caminhaoPequeno.getCusto(dist);
        custos[1] = caminhaoMedio.getCusto(dist);
        custos[2] = caminhaoGrande.getCusto(dist);
        custos[3] = custos[0] + custos[1] + custos[2];

        calculaCustoTotal(custos[3]);

        return custos;
    }

    //Calcula o custo de um caminhao pequeno para um distancia especifica.
    public double calculaPequeno(int dist){
        return caminhaoPequeno.getCusto(dist, 1);
    }

    //Calcula o custo de um caminhao medio para um distancia especifica.
    public double calculaMedio(int dist){
        return caminhaoPequeno.getCusto(dist, 1);
    }

    //Calcula o custo de um caminhao grande para um distancia especifica.
    public double calculaGrande(int dist){
        return caminhaoPequeno.getCusto(dist, 1);
    }

    //Calcula o custo total somando o custo dos trechos.
    private void calculaCustoTotal(double custo){
        this.custoTotal += custo;
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

    //Retorna a lista completa de cidades existentes.
    public String getListaCidades(){
        LinkedList<String> nomes = leitor.getListaCidades();
        String infos = "Lista de cidades:\n";
        for (String string : nomes) {
            infos += "\n" + string;
        }
        return infos;
    }

    //Retorna o trajeto do transporte.
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

    //Retorna as informacoes referentes ao trechos percorridos no transporte
    public String getInfo(){
        String infos = "";
        for (int i = 0; i < cidades.size()-1; i++) {
            String cidade1 = cidades.get(i).toUpperCase();
            String cidade2 = cidades.get(i+1).toUpperCase();
            infos += cidade1 + " --> " + leitor.getDistancia(cidade1, cidade2) + "km --> " + cidade2 + 
            "\n\nCaminhao Pequeno: R$" + String.format("%.2f", custoTrechos.get(i)[0])  + "\nCaminhao Medio: R$" + 
            String.format("%.2f", custoTrechos.get(i)[1]) + "\nCaminhao Grande: R$" + String.format("%.2f", custoTrechos.get(i)[2]) + 
            "\ncustoTrecho: R$" + String.format("%.2f", custoTrechos.get(i)[3]) + "\n----------------------\n";
        }
        infos += "Informacoes gerais\n" +
                 "\nCaminhoes pequenos: " + caminhaoPequeno.getQuantidade() + " veiculos" +
                 "\nCaminhoes medios: " + caminhaoMedio.getQuantidade() + " veiculos" +
                 "\nCaminhoes grandes: " + caminhaoGrande.getQuantidade() +" veiculos" +
                 "\nCusto total: R$" + String.format("%.2f", custoTotal) +
                 "\nPeso total: " + pesoTotal;
        return infos;
    }
}
