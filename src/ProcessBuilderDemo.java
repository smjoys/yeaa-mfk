import java.io.IOException;
import java.util.Scanner;


public class ProcessBuilderDemo {

    public static void main(String[] args)  {

        System.out.println("Ingrese la exprecion regular:");
        Scanner tcld= new Scanner(System.in);

        String ER=tcld.next();
        char[] arreglo= ER.toCharArray();

        Identificador id= new Identificador(arreglo);

    }
}