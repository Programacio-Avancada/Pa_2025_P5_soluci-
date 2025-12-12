# Laberint amb trampes i enemics:

Un equip d’aventurers s’ha perdut dins d’un laberint ple de trampes i enemics.

Cada cel·la del laberint té un cost/dany al accedir:

• 0 → espai lliure (sense perill)

• 1 → una trampa

• 2 → un enemic

L’objectiu és trobar el camí de cost/dany mínim entre l’entrada i la sortida, aplicant la tècnica del backtracking amb poda. El laberint pot tenir una o més sortides. Els moviments permesos són amunt, avall, esquerra i dreta, sempre dins dels límits del laberint.

### 🔹 Decisió
En cada nivell del backtracking ens fem la pregunta: *On moure? = Quin és el següent node?*
Cada decisió consisteix a escollir un veí, per això implementem el mètode getVei(int i) a la classe node que retorni amunt, avall, esquerra i dreta.

### 🔹 Domini
El domini de cada decisió són: els veïns que siguin diferent a null i que no siguin el camí per on he arribat → cal marcatge.
El domini = amplada sempre serà 4.

### 🔹 Acceptable
Una decisió (escollir un veí) és acceptable si:
- És diferent a null
- No és el veí per on venim (no visitat)

### 🔹 Solució
Serà solució quan el veí sigui sortida.

### 🔹 Completable i poda
Un conjunt de decisions parcial és completable mentre:
- tinguem futurs veïns a visitar (però això ho veurem al pròxim nivell de l'arbre).

Es pot aplicar poda quan el dany actual sigui pitjor al millor dany.

### 🔹 Espai de cerca

**Alçada de l'arbre:** és màxima, no podem saber quants nivell necessitem per arribar a la sortida. El valor màxim en el nostre dibuix serà 7x7, però no podem saber-ho.

**Amplada de l'arbre** depèn de la implementació: En el nostre codi és exactament 4, iterem sobre tots els veïns.
En comptes de fer un mètode getVei( int i), es pot fer un mètode que retorni un llistat amb els veïns no nulls, llavors l'amplada és màxima.

![arbre](/EspaiCercaPractica5_2025.drawio.png)

### 🔹 Marcatge
És necessari el marcatge, ja que un node no es pot repetir.

### 🔹 Esquema a aplicar
Busquem la millor solució, minimitzar el cost/dany rebut.
