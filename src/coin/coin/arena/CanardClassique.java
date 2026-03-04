class CanardClassique extends CanardDeCombat {

    public CanardClassique(String nom, int pvMax, int atk) {
        super(nom, pvMax, atk);
    }

    public CanardClassique(String nom, int pvMax) {
        this(nom, pvMax, ATK_MIN);
    }

    @Override
    public String getType() {
        return "Normal";
    }

    @Override
    public String toString() {
        return super.toString() + " [Classique]";
    }

    public double getMultiplicateur(CanardFeu cible) {
        return 1.0; // Normal vs Feu → 1.0
    }

    public double getMultiplicateur(CanardEau cible) {
        return 1.0; // Normal vs Eau → 1.0
    }

    public double getMultiplicateur(CanardPlante cible) {
        return 1.0; // Normal vs Plante → 1.0
    }

    public double getMultiplicateur(CanardClassique cible) {
        return 1.0; // Normal vs Normal → 1.0
    }
}
