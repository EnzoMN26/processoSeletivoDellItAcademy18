import java.util.Scanner;

public class App {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Viagem viagem = new Viagem();
        
        //Chama a funcao que promove a leitura dos dados, caso ocorra algum erro o programa é fechado.
        viagem.addCidade("porto alegre");
        viagem.addCidade("sao paulo");
        System.out.println(viagem.getCustoTrechos());
    }
}
