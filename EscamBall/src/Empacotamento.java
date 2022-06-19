import java.io.*;
import java.util.ArrayList;

public class Empacotamento {
    public static void serializacao(ArrayList<Object> serie, String arquivo) {
        File arq = new File(arquivo);
        try {
            arq.delete();
            arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(serie);
            objOutput.close();

        } catch(IOException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Object> desserializacao(String arquivo) {
        ArrayList<Object> desserie = new ArrayList();
        try {
            File arq = new File(arquivo);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                desserie = (ArrayList<Object>)objInput.readObject();
                objInput.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return(desserie);
    }
}

/*
* https://www.devmedia.com.br/serializacao-de-objetos-em-java/23413
* */
