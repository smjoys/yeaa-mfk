public class Identificador {


    public Identificador(char[] arreglo) {
        char[] er = arreglo;
    }

    private AFND separar(char[] er) {

        Pila AFNDpila = new Pila(er.length);

        int cont;
        for (char c : er) {
            switch (c) {
                case '*':
                    AFND afnd = AFNDpila.pop();
                    Estado nuevoIncial = new Estado();
                    Estado nuevoFinal = new Estado();

                    nuevoIncial.addTrans('e', afnd.inicial);
                    nuevoIncial.addTrans('e', nuevoFinal);


                    afnd.finall.addTrans('e', afnd.inicial);
                    afnd.finall.addTrans('e', nuevoFinal);
                    AFNDpila.push(new AFND(nuevoIncial, nuevoFinal));


                    break;
                case '.':

                    AFND afnd2 = AFNDpila.pop();
                    AFND afnd1 = AFNDpila.pop();


                    afnd1.finall.addTrans('e', afnd2.inicial);
                    AFNDpila.push(new AFND(afnd1.inicial, afnd2.finall));
                    break;


                case '|':

                    AFND afnd4 = AFNDpila.pop();
                    AFND afnd3 = AFNDpila.pop();


                    Estado nuevoInicio2 = new Estado();
                    Estado nuevoFinal2 = new Estado();


                    nuevoInicio2.addTrans('e', afnd3.inicial);
                    nuevoInicio2.addTrans('e', afnd4.inicial);

                    afnd3.finall.addTrans('e', nuevoFinal2);
                    afnd4.finall.addTrans('e', nuevoFinal2);
                    AFNDpila.push(new AFND(nuevoInicio2, nuevoFinal2));
                    break;


                default:
                    Estado estado = new Estado();
                    Estado estadoSig = new Estado();

                    estado.addTrans(c, estadoSig);
                    AFNDpila.push(new AFND(estado, estadoSig));
                    break;

            }
        }

        while (!AFNDpila.isEmpty()) {
            System.out.println(AFNDpila.pop().toString());
        }

        return AFNDpila.pop();

    }




}





