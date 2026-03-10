abstract class CanardDeCombat implements Soignable, Combattant {

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

    protected void setPvActuels(int pvActuels) {
        this.pvActuels = pvActuels;
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

    public abstract String getType();

    /**
     * Affichage simplifié sans les infos spécifiques aux sous-classes.
     * Utilisé par Equipe.afficher() pour correspondre au format attendu.
     */
    public String toStringSimple() {
        return "[%s] %s «%s» (PV: %d/%d | ATK: %d)".formatted(
            getType(),
            nom,
            surnom,
            pvActuels,
            pvMax,
            atk
        );
    }

    // Logique d'attaque commune (pas de logique de type !)
    protected void effectuerAttaque(CanardDeCombat cible, double mult) {
        int degats = (int) (getAtk() * mult);

        System.out.println(
            "%s attaque %s ! (%s → %s : x%.1f) → %d dégâts".formatted(
                getSurnom(),
                cible.getSurnom(),
                getType(),
                cible.getType(),
                mult,
                degats
            )
        );
        cible.subirDegats(degats);
    }

    public abstract void attaquer(CanardDeCombat cible);

    public double etreAttaqueePar(CanardFeu attaquant) {
        return 1.0;
    }

    public double etreAttaqueePar(CanardEau attaquant) {
        return 1.0;
    }

    public double etreAttaqueePar(CanardPlante attaquant) {
        return 1.0;
    }

    public double etreAttaqueePar(CanardClassique attaquant) {
        return 1.0;
    }
}
