abstract class CanardDeCombat {

    private final String nom;
    private String surnom;
    private final int pvMax;
    private int pvActuels;
    private int atk;

    private static int nbCanardsCrees = 0;
    public static final int ATK_MIN = 1;

    public CanardDeCombat(String nom, int pvMax, int atk) {
        if (nom == null) {
            throw new IllegalArgumentException("Le nom ne peut pas être null.");
        }
        if (pvMax <= 0) {
            throw new IllegalArgumentException("pvMax doit être > 0.");
        }
        if (atk < ATK_MIN) {
            throw new IllegalArgumentException(
                "atk doit être >= ATK_MIN (%d).".formatted(ATK_MIN)
            );
        }
        this.nom = nom;
        this.surnom = nom;

        this.pvMax = pvMax;
        this.pvActuels = pvMax;
        this.atk = atk;

        nbCanardsCrees++;
    }

    public String getNom() {
        return nom;
    }

    public String getSurnom() {
        return surnom;
    }

    public int getPvMax() {
        return pvMax;
    }

    public int getPvActuels() {
        return pvActuels;
    }

    public int getAtk() {
        return atk;
    }

    public static int getNbCanardsCrees() {
        return nbCanardsCrees;
    }

    public void setSurnom(String surnom) {
        if (surnom == null) {
            throw new IllegalArgumentException(
                "Le surnom ne peut pas être null."
            );
        }
        this.surnom = surnom;
    }

    public boolean estKO() {
        return pvActuels <= 0;
    }

    public void subirDegats(int degats) {
        if (degats < 0) {
            return;
        }
        pvActuels -= degats;
        if (pvActuels < 0) {
            pvActuels = 0;
        }
        System.out.println(
            "%s subit %d dégâts ! (PV: %d/%d)".formatted(
                surnom,
                degats,
                pvActuels,
                pvMax
            )
        );
    }

    public void soigner() {
        pvActuels = pvMax;
    }

    @Override
    public String toString() {
        return "[%s] %s «%s» (PV: %d/%d | ATK: %d)".formatted(
            getType(),
            nom,
            surnom,
            pvActuels,
            pvMax,
            atk
        );
    }

    // Méthode abstraite pour le type élémentaire
    public abstract String getType();

    // Méthode de combat
    public void attaquer(CanardDeCombat cible) {
        if (cible == null) {
            throw new IllegalArgumentException(
                "La cible ne peut pas être null."
            );
        }
        if (this.estKO()) {
            System.out.println(
                "%s est KO et ne peut pas attaquer.".formatted(this.surnom)
            );
            return;
        }
        System.out.println(
            "%s attaque %s !".formatted(this.surnom, cible.getSurnom())
        );
        double multiplicateur = getMultiplicateur(cible);
        if (multiplicateur > 1.0) {
            System.out.println("C'est super efficace !");
        } else if (multiplicateur < 1.0) {
            System.out.println("Ce n'est pas très efficace...");
        }
        int degats = Math.max(1, (int) Math.round(this.atk * multiplicateur));
        // Affiche le déroulement avant d'appliquer les dégâts
        System.out.println(
            "%s inflige %d dégâts.".formatted(this.surnom, degats)
        );
        cible.subirDegats(degats);
    }

    public double getMultiplicateur(CanardDeCombat cible) {
        return 1.0;
    }
}
