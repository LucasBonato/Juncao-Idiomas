import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Idioma {
    private FileReader fr;
    private BufferedReader br;
    private String documento;
    private int qntdLinhas = 0;

    private ArrayList<String> arrayFinal = new ArrayList<String>();

    public Idioma(String documento) {
        this.documento = documento;
    }

    public void lerArquivo() {
        try {
            fr = new FileReader(documento);
            br = new BufferedReader(fr);

            String linha = br.readLine();

            while(linha != null) {
                linha = linha.trim();
                int lastChar = linha.length() - 1;
                if(linha.charAt(lastChar) != '.' && linha.charAt(lastChar) != '?') {
                    linha = linha + ".";
                }
                arrayFinal.add(linha.trim());
                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int tamanhoArray() {
        return arrayFinal.size();
    }
    public String linhaEspecifica(int index) {
        return arrayFinal.get(index);
    }
    public int getQntdLinhas() {
        try {
            fr = new FileReader(documento);
            br = new BufferedReader(fr);
            String linha = br.readLine();
            while(linha != null){
                qntdLinhas++;
                linha = br.readLine();
            }
        } catch (IOException e) {
          e.printStackTrace();
        }
        return qntdLinhas;
    }
}
