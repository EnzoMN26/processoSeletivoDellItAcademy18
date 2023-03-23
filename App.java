import java.io.IOException;
import java.util.Map;

public class App {
    

    public static void main(String[] args){

        LeitorDados leitor = new LeitorDados();
        
        try{
            leitor.readFile();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
}
