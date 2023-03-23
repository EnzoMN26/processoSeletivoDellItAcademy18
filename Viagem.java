import java.io.IOException;
import java.util.ArrayList;

public class Viagem {
    
    private int pesoTotal;
    private double custoTotal;
    private ArrayList<Integer> custoTrechos;
    private ArrayList<String> cidades;
    private Caminhao caminhaoPequeno;
    private Caminhao caminhaoMedio;
    private Caminhao caminhaoGrande;
    private LeitorDados leitor;


    public Viagem(){

        this.pesoTotal = 0;
        this.custoTotal = 0;
        this.custoTrechos = new ArrayList<>();
        this.cidades = new ArrayList<>();
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
                    custoTrechos.add(leitor.getDistancia(cidades.get(tamanho-2), cidade));
                }
                return 0;
            }
            return 1;
        }
        return 2;
    }

    //PARA TESTE
    public ArrayList getCustoTrechos(){
        return new ArrayList<>(custoTrechos);
    }

    public double getCustoTotal(){
        return this.custoTotal;
    }

    //Calcula o custo total somando o custo dos trechos.
    public void calculaCustoTotal(){
        for (Integer custo : custoTrechos) {
            this.custoTotal+= custo;
        }
    }

    //Funcao que faz os calculos necessários armazenando os dados gerados tanto nos caminhoes como na propria classe.
    public Double[] calcula(int dist){

        Double[] custos = new Double[3];
        //Logica para o calculo da quantidade de caminhoes.
        if(pesoTotal >= 9){

            caminhaoGrande.addCaminhao(pesoTotal/10);

            if(pesoTotal%10 == 9){
                caminhaoGrande.addCaminhao(1);
            }
        }
        if(pesoTotal%10 > 2){

            caminhaoMedio.addCaminhao(((pesoTotal%10)/4));
            
            if((pesoTotal%10)%4 == 3){
                caminhaoMedio.addCaminhao(1);
            }
        }
        if((pesoTotal%10)%4 == 2){
            caminhaoPequeno.addCaminhao(2);
        }
        else if((pesoTotal%10)%4 == 1){
            caminhaoPequeno.addCaminhao(1);
        }
        
        custos[0] = caminhaoPequeno.getCustoTotal(dist);
        custos[1] = caminhaoMedio.getCustoTotal(dist);
        custos[2] = caminhaoGrande.getCustoTotal(dist);

        calculaCustoTotal();

        return custos;
    }

    public String getInfoViagem(){
        String infos = "";
        for (int i = 0; i < cidades.size()-1; i++) {
            String cidade1 = cidades.get(i);
            String cidade2 = cidades.get(i+1);
            infos += cidade1 + " --> " + leitor.getDistancia(cidade1, cidade2) + "km --> " + cidade2 + "\n";
        }
        return infos;
    }
}
