import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class LeitorDados {
    
    //Dicionario que faz a associacao de uma cidade ao seu index na matriz de dados.
    private Map<String, Integer> cidadeParaInt;
    //Matriz onde ficaram armazenadas as distancias entre cidades.
    private Integer[][] matrizDistancias;
    //Lista com todas as cidades.
    private LinkedList<String> nomesCidades;

    //Funcao para a leitura dos dados presentes no arquivo csv.
    public void  readFile() throws IOException{

        cidadeParaInt = new HashMap<String, Integer>();
        nomesCidades = new LinkedList<>();

        //Leitura do arquivo contendo os dados.
        BufferedReader br = new BufferedReader(new FileReader("distancias.csv"));
        String line = br.readLine();

        //Construcao do didicionario entre cidade e index.
        int i = 0;
        for (String cidade : line.split(";")) {
            cidadeParaInt.put(cidade, i++);
            nomesCidades.add(cidade);
        } 

        //Inicializacao da matriz com a quantidade de cidades existentes.
        int qntCidades = cidadeParaInt.size();
        matrizDistancias = new Integer[qntCidades][qntCidades];

        //Construcao da matriz de distancias.
        int numeroLinha = 0;
        while ((line = br.readLine()) != null){
            String[] values = line.split(";");
            for (int j = 0; j < values.length; j++) {
                matrizDistancias[numeroLinha][j] = Integer.parseInt(values[j]);
            }
            numeroLinha++;
        }
        br.close();
    }

    //Verifica a existencia da cidade recebida por parametro na lista de cidades, retornando um boolean.
    public boolean containsCidade(String cidade){
        cidade = Normalizer.normalize(cidade, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toUpperCase();
        return cidadeParaInt.containsKey(cidade);
    }

    //Retorna a distancia entre as duas cidades passadas por parametro.
    public int getDistancia(String cidade1, String cidade2){

        //Limpando os acentos dos nomes das cidades e tranformando em UpperCase.
        cidade1 = Normalizer.normalize(cidade1, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toUpperCase();
        cidade2 = Normalizer.normalize(cidade2, Normalizer.Form.NFD).replaceAll("\\p{M}", "").toUpperCase();

        //Retorna a distancia atraves do index de cada cidade identificado pelo dicionario.
        return matrizDistancias[cidadeParaInt.get(cidade1)][cidadeParaInt.get(cidade2)];
    }

    //Retorna uma copia da lista completa de cidades, de maneira a nao dar acesso a lista original.
    public LinkedList<String> getListaCidades(){
        return new LinkedList<String>(nomesCidades);
    }
}