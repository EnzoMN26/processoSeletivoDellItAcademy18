public class Caminhao {

    private double preco; //Preco por km do caminhao.
    private int qntCaminhao; //Quantidade atual de caminhoes.
    private int qntMaxima; //Maior quantidade ja registrada, utilizada para o uso da quantiade total.

    //Construtor inicializa as variaveis.
    public Caminhao(double preco){
        this.preco = preco;
        this.qntCaminhao = 0;
        this.qntMaxima = 0;
    }

    //Define a quantidade de caminhoes atuais.
    public void setQntCaminhao(double qnt){
        this.qntCaminhao = (int) qnt;
        setQntMaxima();
    };

    //Soma na quantidade de caminhoes atuais.
    public void addQntCaminhao(int qnt){
        this.qntCaminhao += qnt;
        setQntMaxima();
    };

    //Recebe uma distancia especifica e retorna o custo do caminhao para percorrer essa distancia.
    public double getCusto(int distancia){
        return (this.preco * distancia) * qntCaminhao;
        
    }

    //Calcula o custo do percurso com a distancia e a quantidade de caminhoes passadas por parametro.
    public double getCusto(int distancia, int qntCaminhao){
        return (this.preco * distancia) * qntCaminhao;
        
    }

    //Retona a quantidade atual de caminhoes.
    public int getQuantidade(){
        return this.qntCaminhao;
    }

    //Retorna a quantidade total de caminhoes.
    public int getQntMaxima(){
        return qntMaxima;
    }

    //Se a quantidade atual de caminhoes for maior que a quantidade total armazenada, registra uma nova quantidade total.
    public void setQntMaxima(){
        if(qntCaminhao > qntMaxima){
            qntMaxima = qntCaminhao;
        }
    }
}
