package backtracking;

/* : Exercici 3: implementació de l'esquema de backtracking
    - Recorda que és imprescindible respondre les preguntes al fitxer Exercici2_Analisis.txt
*/

import java.util.*;

public class SolucioBacktracking_SEC {

    // Solució amb una seqüència enllaçada de NodeSolucio
    private class NodeSolucio implements Cloneable {
        Node inf;
        NodeSolucio seg;

        public NodeSolucio(Node inf, NodeSolucio seg) {
            this.inf = inf;
            this.seg = seg;
        }
        @Override
        public String toString() {
            String s = this.inf.nom;
            if (this.seg != null) {
                s = seg.toString() + " -> " + s;
            }
            return s;
        }
        @Override
        public NodeSolucio clone() {
            NodeSolucio cloned = new NodeSolucio(this.inf, null);
            if (this.seg != null) {
                cloned.seg = this.seg.clone();
            }
            return cloned;
        }
    }

    // atributs afegits per guardar la solució
    private NodeSolucio unaSolucio;
    private NodeSolucio millorSolucio;
    private int danyActual;
    private int danyMillor;

    // mètodes afegits per gestionar la solució com a llista enllaçada
    public void afegirPrincipi(Node inf) {
            unaSolucio = new NodeSolucio(inf, unaSolucio); // afegim al principi
    }
    public Node esborrarPrincipi() {
            if (unaSolucio == null) return null;
            Node aux = unaSolucio.inf;
            unaSolucio = unaSolucio.seg;
            return aux;
    }


    public SolucioBacktracking_SEC() {
        // Exercici 3: inicialitzar atributs necessaris

        // IMPORTANT: per les primeres proves recomano utilitzar false
        Node inici = Laberint.getLaberintPresentacio(true);

        unaSolucio = new NodeSolucio(inici, null);
        danyActual = 0;
        millorSolucio = null;
        danyMillor = Integer.MAX_VALUE;
    }

    public static void main(String args[]) {
        SolucioBacktracking_SEC s = new SolucioBacktracking_SEC();
        // IMPORTANT: per les primeres proves recomano utilitzar esquema una solució
        s.backMillorSolucio(0);
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
                    // no apliquem poda a l'esquema una solució
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
                    if( danyActual < danyMillor)
                        this.backMillorSolucio(k + 1);//baixem al següent nivell de l'arbre
                }
                // esborrem l'element actual i fem backtracking
                this.desanotarDeSolucio(k, i);
            }
        }
    }

    private boolean acceptable(int k, int i) {
        Node actual = unaSolucio.inf;
        Node vei = actual.getVei(i);
        if( vei == null) return false;
        if( vei.visited ) return false;
        return true;
    }

    private void anotarASolucio(int k, int i) {
        Node actual = unaSolucio.inf;
        Node vei = actual.getVei(i);
        danyActual += vei.cost;
        vei.visited = true;
        afegirPrincipi(vei);
    }

    private void desanotarDeSolucio(int k, int i) {
        Node ultim = esborrarPrincipi();
        ultim.visited = false;
        danyActual -= ultim.cost;
    }

    private boolean esSolucio(int k, int i) {
        Node ultim = unaSolucio.inf;
        return ultim.sortida;
    }

    private boolean esMillor() {
        return danyActual < danyMillor;
    }

    private void guardarMillorSolucio() {
        danyMillor = danyActual;
        millorSolucio = unaSolucio.clone(); // IMPORTANT: cal clonar per guardar una còpia
    }

    public String toString() {
        if( millorSolucio == null) return "No s'ha trobat solució";
        String aux = "Solució amb dany: " + danyMillor + "\n\t";
        aux += millorSolucio.toString();
        return aux;
    }
}
