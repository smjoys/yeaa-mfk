import javax.swing.*;

public class Pila {
    private int tope;
    private AFND p[];

    public Pila(int n){
        tope = -1;
        p = new AFND[n];
    }



    public boolean estaVacia(){
        return tope==-1;
    }
    public boolean estaLlena(){
        return tope==p.length-1;
    }

    public boolean push(AFND c){

        if(this.estaLlena()){
            return false;
        }else{
            p[++tope] =c;

            return true;
        }
    }

    public AFND pop(){
        if(this.estaVacia()){
            AFND afnd=new AFND(null,null);
            return afnd;
        }else{
            AFND aux = p[tope];
            tope--;
            return aux;
        }
    }

    public boolean isEmpty() {
        return tope == -1;
    }

}
