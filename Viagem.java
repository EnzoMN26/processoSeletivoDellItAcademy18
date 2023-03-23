import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Viagem {
    
    private int pesoTotal;
    private double custoTotal;
    private ArrayList<Integer> custoTrechos;
    private ArrayList<String> cidades;
    private Caminhao caminhaoPequeno;
    private Caminhao caminhaoMedio;
    private Caminhao caminhaoGrande;
    private Scanner sc;
    private LeitorDados leitor;


    public Viagem(){

        this.sc = new Scanner(System.in);
        this.leitor = new LeitorDados();
        this.cidades = new ArrayList<>();
        this.custoTrechos = new ArrayList<>();
        this.caminhaoPequeno = new Caminhao(4.87);
        this.caminhaoMedio = new Caminhao(11.92);
        this.caminhaoGrande = new Caminhao(27.44);

        //Chama a funcao que promove a leitura dos dados, caso ocorra algum erro o programa é fechado.
        try{
            leitor.readFile();
        }catch(IOException e){
            System.out.println("Erro na leitura do arquivo csv");
            System.exit(0);
        }

        // System.out.printf("Caminhao1: %d \nCaminhao4: %d \nCaminhao10: %d", caminhao1, caminhao4, caminhao10);
        
    }
    
    public void addCidade(String cidade){
        
    }

    //Funcao que recebe o peso e a distancia do trajeto e retorna a quantidade de caminhoes e o custo.
    public String calculaCaminhao(int peso, int dist){
        /* Criando um array de 4 posicoes onde as 3 primeiras sao referentes as informacoes 
        de cada caminhao e a ultima a informacoes gerais, como o custo total. Dados separados por ; */

        //Logica para o calculo da quantidade de caminhoes.
        if(peso >= 9){
            caminhaoGrande.addCaminhao(peso/10);
            if(peso%10 == 9){
                caminhaoGrande.addCaminhao(1);
            }
        }
        if(peso%10 > 2){
            caminhaoMedio.addCaminhao(((peso%10)/4));
            if((peso%10)%4 == 3){
                caminhaoMedio.addCaminhao(1);
            }
        }
        if((peso%10)%4 == 2){
            caminhaoPequeno.addCaminhao(2);
        }
        else if((peso%10)%4 == 1){
            caminhaoPequeno.addCaminhao(1);
        }
        
        this.custoTotal = caminhaoPequeno.getCustoTotal() + caminhaoMedio.getCustoTotal() + caminhaoGrande.getCustoTotal();

        return caminhaoPequeno.getQuantidade() + " - " + caminhaoMedio.getQuantidade() + " - " + caminhaoGrande.getQuantidade();
    }
}
