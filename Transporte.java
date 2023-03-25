import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Transporte {
    
    private double pesoTotal;
    private double custoTotal;
    private int distanciaTotal;
    private ArrayList<Double[]> custoTrechos; //Armazena o custo de cada caminhao e o custo total de cada trecho.
    private ArrayList<String> cidades; //Armazena todas as cidades do trajeto;
    private ArrayList<String[]> itens; //Armazena todos os itens, com suas quantidades e pesos.
    private Caminhao caminhaoPequeno;
    private Caminhao caminhaoMedio;
    private Caminhao caminhaoGrande;
    private LeitorDados leitor;


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

        // System.out.printf("Caminhao1: %d \nCaminhao4: %d \nCaminhao10: %d", caminhao1, caminhao4, caminhao10);
        
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

    //Funcao que recebe a distancia a ser percorrida e faz os calculos de custo retornando um array com o custo de cada caminhao e o custo somado no trecho.
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

    //Calcula o custo total somando o custo dos trechos.
    private void calculaCustoTotal(double custo){
        this.custoTotal += custo;
    }

    //PARA TESTE
    public ArrayList<Double[]> getCustoTrechos(){
        return new ArrayList<>(custoTrechos);
    }

    //Retorna o custo total.
    public double getCustoTotal(){
        return this.custoTotal;
    }

    public int getDistanciaTotal(){
        return this.distanciaTotal;
    }

    public int getQntItens(){
        return this.itens.size();
    }

    public int getQntCidades(){
        return cidades.size();
    }

    public String getListaCidades(){
        LinkedList<String> nomes = leitor.getListaCidades();
        String infos = "Lista de cidades:\n";
        for (String string : nomes) {
            infos += "\n" + string;
        }
        return infos;
    }

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
            String cidade1 = cidades.get(i);
            String cidade2 = cidades.get(i+1);
            infos += "----------------------\n" + cidade1 + " --> " + leitor.getDistancia(cidade1, cidade2) + "km --> " + cidade2 + 
            "\ncustoC1: R$" + String.format("%.2f", custoTrechos.get(i)[0])  + "\ncustoC2: R$" + String.format("%.2f", custoTrechos.get(i)[1]) + "\ncustoC3: R$" + String.format("%.2f", custoTrechos.get(i)[2]) + "\ncustoTrecho: R$" + String.format("%.2f", custoTrechos.get(i)[3]) + "\n----------------------";
        }
        infos += "\nInformacoes gerais\n" +
                 "\nCaminhoes pequenos: " + caminhaoPequeno.getQuantidade() + " veiculos" +
                 "\nCaminhoes medios: " + caminhaoMedio.getQuantidade() + " veiculos" +
                 "\nCaminhoes grandes: " + caminhaoGrande.getQuantidade() +" veiculos" +
                 "\nCusto total: R$" + String.format("%.2f", custoTotal) +
                 "\nPeso total: " + pesoTotal;
        return infos;
    }
}
