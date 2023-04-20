import java.io.IOException;
import java.util.Scanner;


public class ProcessBuilderDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Ingrese la exprecion regular:");
        Scanner tcld= new Scanner(System.in);

        String ER=tcld.next();
        char[] arreglo= ER.toCharArray();

        AFND afnd= new AFND(arreglo);


        afnd.imprimirAFND();



























// linea de comando para crear el diagrama
        String[] list = {"cmd.exe", "/c", "dot -Tjpg dfa.dot > dfa.jpg"};
        var processBuilder = new ProcessBuilder();
        processBuilder.command(list);
        try {
            var process = processBuilder.start();
            var ret = process.waitFor();
//codigo cero significa que no hay error
            System.out.printf("Codigo de retorno: %d", ret);
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }







    }
}