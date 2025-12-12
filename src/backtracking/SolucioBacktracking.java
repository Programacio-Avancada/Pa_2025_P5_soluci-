package backtracking;


import java.util.ArrayList;
import java.util.List;

public class SolucioBacktracking {

    // definim els següent atributs:
    List<Node> solucio; // guardem un llistat amb tots els nodes del camí solució
    int danyActual; // suma del dany total
    List<Node> millor; // guardem la millor solució
    int danyMillor; // el mínim dany trobat.

    // IMPORTANT: no cal un atribut Node pel node actual perquè serà el k-èssim de la solució.
    // el marcatge ho fem directament a la classe Node

    public SolucioBacktracking() {
        solucio = new ArrayList<>();
        danyActual = 0;
        millor = new ArrayList<>();
        danyMillor = Integer.MAX_VALUE;
        Node inici = Laberint.getLaberintPresentacio(true);
        inici.visited = true;
        solucio.add(inici); // k=0
    }
    public static void main(String args[]) {
        SolucioBacktracking s = new SolucioBacktracking();
        s.backUnaSolucio(0);
        //s.backMillorSolucio(0);
        System.out.println(s);
    }
    // Recomanació: canvia els noms dels índexs al teu problema:
    //  - k és alçada de l'arbre
    //  - i és amplada de l'arbre


    /* esquema recursiu que troba una solució
     * utilitzem una variable booleana (que retornem)
     * per aturar el recorregut quan haguem trobat una solució
     */
    public boolean backUnaSolucio(int k) {
        boolean trobada = false;
        int amplada = 4;
        // iterem sobre l'amplada de l'arbre
        for(int i = 0; i < amplada && !trobada; i++) {
            //mirem si l'element i es pot assignar a k
            if(this.acceptable(k,i)) {
                //posem l'element a la solució actual
                this.anotarASolucio(k,i);

                if(this.esSolucio(k,i)) { // és solució?
                    this.guardarMillorSolucio();
                    return true; // hem trobat una solució
                } else {
                    if( solucio.get(k+1).teVeins() )
                        trobada = this.backUnaSolucio(k + 1); //baixem al següent nivell de l'arbre
                }
                if(!trobada)
                    // esborrem l'actual, per després posar-la a una altra
                    this.desanotarDeSolucio(k,i);
            }
        }
        return trobada;
    }

    /* Esquema recursiu que busca totes les solucions
     * no cal utilitzar una variable booleana per aturar perquè busquem totes les solucions
     * cal guardar una COPIA de la millor solució a una variable
     */
    public void backMillorSolucio(int k) {
        int amplada = 4;
        // iterem sobre l'amplada de l'arbre
        for(int i = 0; i < amplada; i++) {
            //mirem si l'element i es pot assignar a k
            if(this.acceptable(k, i)) {
                //posem l'element a la solució actual
                this.anotarASolucio(k, i);

                if (this.esSolucio(k,i)) { // és solució?
                    if( this.esMillor())
                        this.guardarMillorSolucio();
                } else {
                    if( solucio.get(k+1).teVeins() && danyActual < danyMillor) //aquí també es podria afegir una poda de dany < vida
                        this.backMillorSolucio(k + 1);//baixem al següent nivell de l'arbre
                }
                // esborrem l'element actual i fem backtracking
                this.desanotarDeSolucio(k, i);
            }
        }
    }

    private boolean acceptable(int k, int i) {
        Node actual = solucio.get(k);
        Node vei = actual.getVei(i);
        if( vei == null) return false;
        if( vei.visited ) return false;
        return true;
    }

    private void anotarASolucio(int k, int i) {
        Node actual = solucio.get(k);
        Node vei = actual.getVei(i);
        danyActual += vei.cost;
        vei.visited = true;
        solucio.add(vei);
    }

    private void desanotarDeSolucio(int k, int i) {
        Node ultim = solucio.get(k+1);
        ultim.visited = false;
        danyActual -= ultim.cost;
        solucio.remove(ultim);
    }

    private boolean esSolucio(int k, int i) {
        Node ultim = solucio.get(k+1);
        return ultim.sortida;
    }

    private boolean esMillor() {
        return danyActual < danyMillor;
    }

    private void guardarMillorSolucio() {
        danyMillor = danyActual;
        millor = new ArrayList<>(solucio.size());
        millor.addAll(solucio);
    }

    public String toString() {
        if( millor.size() == 0) return "No s'ha trobat solució";
        String aux = "Solució amb dany: " + danyMillor + "\n\t";
        for (Node item : millor) {
            aux += item.toString()+" -> ";
        }
        return aux;
    }

}
