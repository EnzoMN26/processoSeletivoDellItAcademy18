public class Caminhao {

    private double preco;
    private int qntCaminhao;

    public Caminhao(double preco){
        this.preco = preco;
        this.qntCaminhao = 0;
    }

    public void qntCaminhao(int qnt){
        this.qntCaminhao = qnt;
    };

    public double getCusto(int distancia){
        return (this.preco * distancia) * qntCaminhao;
        
    }

    public int getQuantidade(){
        return qntCaminhao;
    }
}
