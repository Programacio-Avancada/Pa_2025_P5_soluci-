package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Aquesta classe es pot MODIFICAR i afegir ATRIBUTS
// Aquesta classe representa una cel·la del laberint
public class Node {
    final String nom;             // Nom del node (guardem la posició, simplement per observar les solucions)
    final int cost;              // 0: lliure, 1: trampa, 2: enemic
    final boolean sortida;       // Indica si aquest node és la sortida del laberint
    Node amunt, avall, esquerra, dreta;  // Connexions amb nodes veïns
    boolean visited; //afegim un atribut de marcatge

    public Node(String nom, int cost, boolean sortida) {
        this.nom = nom;
        this.cost = cost;
        this.sortida = sortida;
        this.amunt = null;
        this.avall = null;
        this.esquerra = null;
        this.dreta = null;
        this.visited = false;
    }

    public Node getVei(int i){ // domini són els 4 veïns = amplada exacta
        switch ( i ){
            case 0: return dreta ;
            case 1: return avall;
            case 2: return esquerra;
            case 3: return amunt;
        }
        throw new RuntimeException("index de veí incorrecte");
    }

    public boolean teVeins(){
        if(amunt != null && !amunt.visited) return true;
        if(avall != null && !avall.visited) return true;
        if(esquerra != null && !esquerra.visited) return true;
        if(dreta != null && !dreta.visited) return true;
        return false;
    }

    @Override
    public String toString() {
        String aux = this.nom + " ";
        if( sortida ) aux += "Sortida";
        switch (cost) {
            //case 0: return aux+"Via lliure";
            case 1: return aux+"Trampa";
            case 2: return aux+"Enemic";
            default: return aux;
        }
    }
}