public class Nodo {

        int num; //q1,q2,q3,etc....
        Nodo a;
        Nodo b;

        Nodo eps;

        boolean fin;

        public Nodo(int num, Nodo a, Nodo b,Nodo eps) {
            this.num = num;
            this.a=a;
            this.b=b;
            this.eps=eps;
            this.fin=false;
        }

        public void CambiarFinal(){
            this.fin=true;
        }

}
