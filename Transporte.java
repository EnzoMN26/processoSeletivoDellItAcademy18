import java.io.IOException;
import java.util.ArrayList;

public class Transporte {
    
    private double pesoTotal;
    private double custoTotal;
    private int distanciaTotal;
    private ArrayList<Double[]> custoTrechos; //Armazena o custo de cada caminhao e o custo total de cada trecho.
    private ArrayList<String> cidades; //Armazena todas as cidades do trajeto;
    private ArrayList<String[]> produtos; //Armazena todos os produtos, com suas quantidades e pesos.
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
        this.produtos = new ArrayList<>();
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
    public void addProduto(String nome, int quantidade, double peso){
        String[] temp = new String[3];
        temp[0] = nome;
        temp[1] = ""+quantidade;
        temp[2] = ""+peso;
        this.pesoTotal += quantidade * peso;
        this.produtos.add(temp);
        calculaCaminhoes();
    }


    public void calculaCaminhoes(){
        //Logica para o calculo da quantidade de caminhoes.
        if(pesoTotal >= 9){

            caminhaoGrande.qntCaminhao(pesoTotal/10);

            if(pesoTotal%10 == 9){
                caminhaoGrande.qntCaminhao(1);
            }
        }
        if(pesoTotal%10 > 2){

            caminhaoMedio.qntCaminhao(((pesoTotal%10)/4));
            
            if((pesoTotal%10)%4 == 3){
                caminhaoMedio.qntCaminhao(1);
            }
        }
        if((pesoTotal%10)%4 == 2){
            caminhaoPequeno.qntCaminhao(2);
        }
        else if((pesoTotal%10)%4 == 1){
            caminhaoPequeno.qntCaminhao(1);
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


    //PARA TESTE
    public ArrayList getCustoTrechos(){
        return new ArrayList<>(custoTrechos);
    }

    //Retorna o custo total.
    public double getCustoTotal(){
        return this.custoTotal;
    }


    //Calcula o custo total somando o custo dos trechos.
    private void calculaCustoTotal(double custo){
        this.custoTotal += custo;
    }

    //Retorna as informacoes referentes ao trechos percorridos no transporte
    public String getInfoViagem(){
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
