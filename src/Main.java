import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static String ARQUIVO_SAIDA = "C:\\Users\\Lucas Bonato\\Documents\\Github\\JuncaoIdiomas\\ingles\\final.txt";
    static final String ARQUIVO_PORT = "C:\\Users\\Lucas Bonato\\Documents\\Github\\JuncaoIdiomas\\ingles\\port.txt";
    static final String ARQUIVO_ING = "C:\\Users\\Lucas Bonato\\Documents\\Github\\JuncaoIdiomas\\ingles\\ing.txt";

    static FileWriter fw;
    static BufferedWriter bw;

    public static void main(String[] args){
        try {
            fw = new FileWriter(ARQUIVO_SAIDA);
            bw = new BufferedWriter(fw);

            Idioma port = new Idioma(ARQUIVO_PORT);
            Idioma ing = new Idioma(ARQUIVO_ING);

            port.lerArquivo();
            ing.lerArquivo();

            if(port.getQntdLinhas() != ing.getQntdLinhas()){
                System.out.println("O número de linhas dos arquivos não batem.\nPort: " + port.getQntdLinhas() + "\nIng: " + ing.getQntdLinhas());
                return;
            }
            for(int i = 0; i < port.tamanhoArray(); i++) {
                bw.write(port.linhaEspecifica(i));
                bw.newLine();
                bw.write(ing.linhaEspecifica(i));
                if(i == port.tamanhoArray()){
                    break;
                }
                bw.newLine();
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Arquivo concluido com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
