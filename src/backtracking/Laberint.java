// java
package backtracking;

// Aquesta classe no es pot MODIFICAR
// Aquesta classe representa tot el laberint a partir del node d’entrada.
public class Laberint {
    Node entrada; // Node inicial d’on comença l’exploració

    public Laberint(Node entrada) {
        this.entrada = entrada;
    }

    public static Node getLaberintPresentacio(boolean doblesentit) {
        // Creem els nodes del laberint
        Laberint lab = new Laberint(new Node("n10", 0, false));
        Node n11 = new Node("n11", 2, false);
        lab.entrada.dreta = n11;
        Node n01 = new Node("n01", 0, false);
        n11.amunt = n01;
        Node n00 = new Node("n00", 1, false);
        n01.esquerra = n00;
        Node n02 = new Node("n02", 0, false);
        n01.dreta = n02;
        Node n03 = new Node("n03", 0, false);
        n02.dreta = n03;
        Node n04 = new Node("n04", 1, false);
        n03.dreta = n04;
        Node n14 = new Node("n14", 0, false);
        n04.avall = n14;
        Node n15 = new Node("n15", 2, false);
        n14.dreta = n15;
        Node n05 = new Node("n05", 0, false);
        n15.amunt = n05;
        Node n06 = new Node("n06", 1, false);
        n05.dreta = n06;
        Node n16 = new Node("n16", 0, true); // sortida
        n06.avall = n16;
        if(doblesentit) {
            // doble sentido, cuidado con la recursividad
            n11.esquerra = lab.entrada;
            n01.avall = n11;
            n00.dreta = n01;
            n02.esquerra = n01;
            n03.esquerra = n02;
            n04.esquerra = n03;
            n14.amunt = n04;
            n15.esquerra = n14;
            n05.avall = n15;
            n06.esquerra = n05;
            n16.amunt=n06;
        }
        Node n13 = new Node("n13", 0, false);
        n03.avall = n13;
        Node n23 = new Node("n23", 0, false);
        n13.avall = n23;
        Node n22 = new Node("n22", 0, false);
        n23.esquerra = n22;
        Node n12 = new Node("n12", 0, false);
        n22.amunt = n12;
        Node n21 = new Node("n21", 0, false);
        n22.esquerra = n21;
        Node n20 = new Node("n20", 2, false);
        n21.esquerra = n20;
        Node n31 = new Node("n31", 1, false);
        n21.avall = n31;
        Node n30 = new Node("n30", 0, false);
        n31.esquerra = n30;
        Node n40 = new Node("n40", 0, false);
        n30.avall = n40;
        Node n41 = new Node("n41", 0, false);
        n40.dreta = n41;
        Node n42 = new Node("n42", 0, false);
        n41.dreta = n42;
        Node n52 = new Node("n52", 0, false);
        n42.avall = n52;
        Node n51 = new Node("n51", 0, false);
        n52.esquerra = n51;
        Node n50 = new Node("n50", 0, false);
        n51.esquerra = n50;
        Node n60 = new Node("n60", 0, false);
        n50.avall = n60;
        Node n61 = new Node("n61", 1, false);
        n60.dreta = n61;
        Node n53 = new Node("n53", 1, false);
        n52.dreta = n53;
        Node n62 = new Node("n62", 0, false);
        n52.avall = n62;
        Node n63 = new Node("n63", 0, false);
        n62.dreta = n63;
        Node n64 = new Node("n64", 0, false);
        n63.dreta = n64;
        Node n65 = new Node("n65", 0, false);
        n64.dreta = n65;
        Node n66 = new Node("n66", 2, true); // sortida amb enemic
        n65.dreta = n66;
        if(doblesentit) {
            n13.amunt = n03;
            n23.amunt = n13;
            n22.dreta = n23;
            n12.avall = n22;
            n21.dreta = n22;
            n20.dreta = n21;
            n31.amunt = n21;
            n30.dreta = n31;
            n40.amunt = n30;
            n41.esquerra = n40;
            n42.esquerra = n41;
            n52.amunt = n42;
            n51.dreta = n52;
            n50.dreta = n51;
            n60.amunt = n50;
            n61.esquerra = n60;
            n53.esquerra = n52;
            n62.amunt = n52;
            n63.esquerra = n62;
            n64.esquerra = n63;
            n65.esquerra = n64;
            n66.esquerra = n65;
        }
        Node n54 = new Node("n54", 0, false);
        n64.amunt = n54;
        Node n44 = new Node("n44", 0, false);
        n54.amunt = n44;
        Node n43 = new Node("n43", 0, false);
        n44.esquerra = n43;
        Node n33 = new Node("n33", 0, false);
        n43.amunt = n33;
        Node n32 = new Node("n32", 2, false);
        n33.esquerra = n32;
        Node n34 = new Node("n34", 0, false);
        n33.dreta = n34;
        Node n35 = new Node("n35", 1, false);
        n34.dreta = n35;
        Node n25 = new Node("n25", 0, false);
        n35.amunt = n25;
        Node n24 = new Node("n24", 2, false);
        n25.esquerra = n24;
        Node n26 = new Node("n26", 0, false);
        n25.dreta = n26;
        Node n36 = new Node("n36", 0, false);
        n26.avall = n36;
        Node n46 = new Node("n46", 0, false);
        n36.avall = n46;
        Node n45 = new Node("n45", 0, false);
        n46.esquerra = n45;
        Node n55 = new Node("n55", 0, false);
        n45.avall = n55;
        Node n56 = new Node("n56", 0, true); //sortida
        n55.dreta = n56;
        if(doblesentit) {
            n54.avall = n64;
            n44.avall = n54;
            n43.dreta = n44;
            n33.avall = n43;
            n32.dreta = n33;
            n34.esquerra = n33;
            n35.esquerra = n34;
            n25.avall = n35;
            n24.dreta = n25;
            n26.esquerra = n25;
            n36.amunt = n26;
            n46.amunt = n36;
            n45.dreta = n46;
            n55.amunt = n45;
            n56.esquerra = n55;
        }
        return lab.entrada;
    }

}
