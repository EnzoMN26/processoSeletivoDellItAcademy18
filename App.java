import java.util.Scanner;

public class App {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Transporte transporte = new Transporte();
        
        //Chama a funcao que promove a leitura dos dados, caso ocorra algum erro o programa é fechado.
        transporte.addProduto("celular", 10, 0.6);
        transporte.addProduto("patins", 10, 2);
        transporte.addProduto("garrafa", 10, 0.3);
        transporte.addCidade("porto alegre");
        transporte.addCidade("sao paulo");
        transporte.addCidade("brasilia");
        transporte.addCidade("aracaju");
        System.out.println(transporte.getInfoViagem());
    }
}
