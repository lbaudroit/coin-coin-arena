class Equipe {

    private static final int TAILLE_MAX = 6;

    private final CanardDeCombat[] canards;
    private int nbCanards;
    private final String nomDresseur;

    private static int nbEquipesCrees = 0;

    public Equipe(String nomDresseur) {
        if (nomDresseur == null) {
            throw new IllegalArgumentException(
                "Le nom du dresseur ne peut pas être null."
            );
        }
        this.nomDresseur = nomDresseur;
        this.canards = new CanardDeCombat[TAILLE_MAX];
        this.nbCanards = 0;
        nbEquipesCrees++;
    }
    
    public String getNomDresseur() {
        return nomDresseur;
    }

    public static int getNbEquipesCrees() {
        return nbEquipesCrees;
    }

    public int getNbCanards() {
        return nbCanards;
    }

    /**
     * Ajoute un canard à l'équipe si elle n'est pas pleine.
     *
     * @return true si l'ajout a réussi, false sinon.
     */
    public boolean ajouter(CanardDeCombat c) {
        if (c == null || nbCanards >= TAILLE_MAX) {
            return false;
        }
        canards[nbCanards] = c;
        nbCanards++;
        return true;
    }

    /**
     * Retire le premier canard dont le surnom correspond.
     * Comble le trou en décalant les canards suivants.
     *
     * @return true si un canard a été retiré, false sinon.
     */
    public boolean retirer(String surnom) {
        if (surnom == null) {
            return false;
        }
        for (int i = 0; i < nbCanards; i++) {
            if (surnom.equals(canards[i].getSurnom())) {
                // Décalage vers la gauche pour combler le trou
                for (int j = i; j < nbCanards - 1; j++) {
                    canards[j] = canards[j + 1];
                }
                canards[nbCanards - 1] = null;
                nbCanards--;
                return true;
            }
        }
        return false;
    }

    /**
     * Renvoie le premier canard non-KO, ou null si tous sont KO.
     * 
     * @return le premier canard non-KO, ou null si tous sont KO.
     */
    public CanardDeCombat getPremierValide() {
        for (int i = 0; i < nbCanards; i++) {
            if (!canards[i].estKO()) {
                return canards[i];
            }
        }
        return null;
    }

    /**
     * Soigne toute l'équipe via l'interface Soignable.
     */
    public void soignerTous() {
        for (int i = 0; i < nbCanards; i++) {
            canards[i].soigner();
        }
    }

    /**
     * Affiche chaque canard avec son état.
     */
    public void afficher() {
        System.out.println("=== ÉQUIPE de " + nomDresseur + " ===");
        for (int i = 0; i < nbCanards; i++) {
            String etat = canards[i].estKO() ? " [KO]" : "";
            System.out.println(canards[i].toStringSimple() + etat);
        }
    }

    /**
     * Renvoie true si tous les canards de l'équipe sont KO.
     * 
     * @return true si tous les canards sont KO, false sinon.
     */
    public boolean touteKO() {
        for (int i = 0; i < nbCanards; i++) {
            if (!canards[i].estKO()) {
                return false;
            }
        }
        return true;
    }
}
