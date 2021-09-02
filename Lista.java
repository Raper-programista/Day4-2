import java.util.*;
import java.io.*;

public class Lista{
    private static List<String> lista = new ArrayList<>();
    static{
        try(BufferedReader reader = new BufferedReader(new FileReader("plik.txt"))){
            while(reader.ready())
                lista.add(reader.readLine());
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }

    }
    public static List<String> getList(){
        return lista;
    }

}