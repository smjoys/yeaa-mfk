import java.util.Stack;

public class AFND {

    char[] arreglo;
    AFND(char[] arreglo){
        this.arreglo=arreglo;

    }


    public void Imprimir(){ //Metodo auxiliar para revisar q se envio bien los caracteres

        for (char er:arreglo) {
            System.out.println(er);
        }
    }

    int num=0;
    public void CrearAFND(){

        for (char er:arreglo) {
            num++;
            switch (er){

                case 'a':
                    Nodo n= new Nodo(num,null,null,null);


                    break;

                case 'b':
                    Nodo no= new Nodo(num,null,null,null);


                    break;

                case '.':



                    break;

                case '*':



                    break;

                case '|':


                    break;







        }



    }
    }





}
