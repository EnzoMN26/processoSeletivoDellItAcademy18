public class Caminhao {

    private double preco;
    private double custoTotal;
    private int qntCaminhao;

    public Caminhao(double preco){
        this.preco = preco;
        this.custoTotal = 0;
        this.qntCaminhao = 0;
    }

    public void addCaminhao(int x){
        this.qntCaminhao += x;
    };

    public double getCustoTotal(int distancia){
        this.custoTotal += (this.preco * distancia) * qntCaminhao;
        return this.custoTotal;
    }

    public int getQuantidade(){
        return qntCaminhao;
    }
}
