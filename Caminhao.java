public class Caminhao {

    private double preco;
    private int qntCaminhao;
    private int qntMaxima;

    public Caminhao(double preco){
        this.preco = preco;
        this.qntCaminhao = 0;
        this.qntMaxima = 0;
    }

    public void setQntCaminhao(double qnt){
        this.qntCaminhao = (int) qnt;
        setQntMaxima();
    };

    public void addQntCaminhao(int qnt){
        this.qntCaminhao += qnt;
        setQntMaxima();
    };

    public double getCusto(int distancia){
        return (this.preco * distancia) * qntCaminhao;
        
    }

    public double getCusto(int distancia, int qntCaminhao){
        return (this.preco * distancia) * qntCaminhao;
        
    }

    public int getQuantidade(){
        return this.qntCaminhao;
    }

    public int getQntMaxima(){
        return qntMaxima;
    }

    public void setQntMaxima(){
        if(qntCaminhao > qntMaxima){
            qntMaxima = qntCaminhao;
        }
    }
}
