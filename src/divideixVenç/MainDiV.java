package divideixVenç;

import java.util.ArrayList;

public class MainDiV {
    public static void main(String[] args) {
        try {
            // Construïm manualment un arbre binari d'àrees
            ArbreBinari<Area> arbre = new ArbreBinari<>();
            Area[] arees = new Area[]{
                    new Area("Centre", 15),
                    new Area("Sud", 10),
                    new Area("Nord", 20),
                    new Area("Sud-est", 12),
                    new Area("Sud-oest", 9),
                    new Area("Nord-est", 25),
                    new Area("Nord-oest", 18)
            };
            for(int i = 0; i< arees.length; i++) {
                arbre.inserir(arees[i]);
            }
            // Assignem els ènemics visibles
            for(int i = 0; i< arees.length; i++) {
                arees[i].setEnemicsVisibles((int) (Math.random()*30));
            }
            System.out.println(arbre);

            // Mostrem l’àrea amb més enemics visibles
            Area maxArea = arbre.trobaAreaPerAtacar();
            System.out.println("L'àrea a atacar és: " + maxArea);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}