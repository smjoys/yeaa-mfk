import java.util.Stack;

public class AFND {

    char[] arreglo;
    Stack<Automata> pila = new Stack();



    public AFND(char[] arreglo) {
        this.arreglo = arreglo;

    }


    public void Imprimir() { //Metodo auxiliar para revisar q se envio bien los caracteres

        for (char er : arreglo) {
            System.out.println(er);
        }
    }



    public void CrearAFND() {



        for (char er : arreglo) {

            switch (er) {


                case '.':
                    generarConcatenacion();

                    break;

                case '*':
                    generarCerradura();

                    break;

                case '|':

                    generarUnion();

                    break;

                default:
                    generarEstados(er);


            }
        }


    }


    public void generarEstados(char letra){
        Automata au= new Automata();

        Estado estado1= new Estado(0,true,false);
        Estado estado2= new Estado(1,false,true);

        estado1.agregarTransicion(letra,estado2);

        au.agregarEstado(estado1);
        au.agregarEstado(estado2);

        au.setEstadoInicio(estado1);
        au.agregarEstadoFinal(estado2);

        pila.push(au);
    }

    public void generarConcatenacion(){
        Automata au1;
        Automata au2;
        Automata conca = new Automata();

        au2 = this.pila.pop();
        au1 = this.pila.pop();

        au1.finales.get(0).agregarTransicion('-', au2.inicio);

        for (Estado estado: au1.estados){
            conca.agregarEstado(estado);
        }
        for (Estado estado: au2.estados){
            conca.agregarEstado(estado);
        }
        conca.setEstadoInicio(au1.inicio);
        conca.finales.addAll(au2.finales);

        for (int i=0; i<conca.estados.size();i++){
            conca.estados.get(i).id=i;
        }
        this.pila.push(conca);
    }

    public void generarUnion(){
        Automata automata2=this.pila.pop();
        Automata automata1=this.pila.pop();
        Automata union=new Automata();

        Estado inicio=new Estado(0,true,false);
        Estado fin=new Estado(0,false,true);

        inicio.agregarTransicion('|',automata1.inicio);
        inicio.agregarTransicion('|',automata2.inicio);

        automata1.finales.get(0).agregarTransicion('-',fin);
        automata2.finales.get(0).agregarTransicion('|',fin);

        union.agregarEstado(inicio);

        for (Estado estado: automata1.estados){
            union.agregarEstado(estado);
        }

        for (Estado estado: automata2.estados){
            union.agregarEstado(estado);
        }

        union.agregarEstado(fin);

        for(int i=0;i<union.estados.size();i++){
            union.estados.get(i).id=i;
        }

        union.inicio=inicio;
        union.agregarEstadoFinal(fin);

        this.pila.push(union);
    }

    public void generarCerradura(){

    }




}






