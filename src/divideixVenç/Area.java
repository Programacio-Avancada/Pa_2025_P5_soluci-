package divideixVenç;

/* Aquesta classe no es pot modificar */

class Area implements Comparable<Area> {
    private String nom;
    private int enemicsVisibles;

    public Area(String nom, int enemicsVisibles) {
        this.nom = nom;
        this.enemicsVisibles = enemicsVisibles;
    }

    public String getNom() {
        return nom;
    }
    public int getEnemicsVisibles() {
        return enemicsVisibles;
    }
    public void setEnemicsVisibles(int enemicsVisibles) {
        this.enemicsVisibles = enemicsVisibles;
    }

    @Override
    public int compareTo(Area altra) {
        int cmp = Integer.compare(this.enemicsVisibles, altra.enemicsVisibles);
        if( cmp == 0)
            return this.nom.compareTo(altra.nom);
        return cmp;
    }

    @Override
    public String toString() {
        return nom + " (" + enemicsVisibles + " enemics visibles)";
    }
}
