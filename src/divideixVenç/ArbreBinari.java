package divideixVenç;

class ArbreBinari <E extends Comparable<E>> {

    private class NodeA {
        private E info;
        private NodeA esquerra;
        private NodeA dreta;

        private NodeA(E info) {
            this.info = info;
            this.esquerra = null;
            this.dreta = null;
        }
        @Override
        public String toString(){
            String res = this.info.toString()+"\n";
            if( this.esquerra != null) res += this.esquerra.toString();
            if( this.dreta != null) res += this.dreta.toString();
            return res;
        }
    }

    private NodeA arrel;

    public ArbreBinari() {
        arrel = null;
    }

    /**
     * Inserció bàsica per mantenir l’ordre segons compareTo
     */
    public void inserir(E elem) {
        arrel = inserirRec(arrel, elem);
    }

    private NodeA inserirRec(NodeA n, E elem) {
        if (n == null) return new NodeA(elem);
        if (elem.compareTo(n.info) < 0)
            n.esquerra = inserirRec(n.esquerra, elem);
        else
            n.dreta = inserirRec(n.dreta, elem);
        return n;
    }

    /**
     * TODO: Exercici 1: Retorna el valor màxim de l’arbre amb Divideix i Venç
     */
    public E trobaAreaPerAtacar() throws Exception {
        // Cal aplicar la tècnica del Divideix i Venç
        // Llança una excepció si l’arbre és buit
        // Es valorarà l’eficiència i l’ús correcte de la recursivitat
        if (arrel == null) throw new Exception("Arbre buit");
        return trobaAreaPerAtacar(arrel);
    }

    private E trobaAreaPerAtacar(NodeA n) {
        if (n == null) return null;

        // Divideix: resol els subarbres esquerre i dret
        E maxE = trobaAreaPerAtacar(n.esquerra);
        E maxD = trobaAreaPerAtacar(n.dreta);

        // Venç i combina: retorna el màxim dels tres
        E maxim = n.info;
        if (maxE != null && maxE.compareTo(maxim) > 0) maxim = maxE;
        if (maxD != null && maxD.compareTo(maxim) > 0) maxim = maxD;

        return maxim;
    }

    @Override
    public String toString(){
        return this.arrel.toString();
    }
}