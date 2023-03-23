import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LeitorDados {
    
    private Map<String, Integer> cidadeParaInt;
    private Integer[][] matrizDistancias;

    public void readFile() throws IOException{

        cidadeParaInt = new HashMap();
        BufferedReader br = new BufferedReader(new FileReader("distancias.csv"));
        String line = br.readLine();
        int i = 0;
        for (String cidade : line.split(";")) {
            cidadeParaInt.put(cidade, i++);
        } 
    }
}



// public class LeitorDados {
    
//     private Integer[] cidadeParaInt;
//     private Integer[][] matrizDistancias;

//     public Integer[][] getAcess() throws FileNotFoundException, IOException{
        
//         try (BufferedReader br = new BufferedReader(new FileReader("distancias.csv"))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 String[] values = line.split(";");
//                 records.add(Arrays.asList(values));
//             }
//         }
//         return null;
//     }
// }
