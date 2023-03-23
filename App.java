import java.io.IOException;
import java.util.Scanner;

public class App {
    

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        LeitorDados leitor = new LeitorDados();
        
        try{
            leitor.readFile();
        }catch(IOException e){
            System.out.println("Erro na leitura do arquivo csv");
            System.exit(0);
        }

        int dist = sc.nextInt();
        int caminhao1 = 0;
        int caminhao4 = 0;
        int caminhao10 = 0;

        if(dist >= 9){
            caminhao10 = dist/10;
            if(dist%10 == 9){
                caminhao10++;
            }
        }
        if(dist%10 > 2){
            caminhao4 = (dist%10)/4;
            if((dist%10)%4 == 3){
                caminhao4++;
            }
        }
        if((dist%10)%4 == 2){
            caminhao1 = 2;
        }
        else if((dist%10)%4 == 1){
            caminhao1++;
        }

        System.out.printf("Caminhao1: %d \nCaminhao4: %d \nCaminhao10: %d", caminhao1, caminhao4, caminhao10);
    }
    
}
