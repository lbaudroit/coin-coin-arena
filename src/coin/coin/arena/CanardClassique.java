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
    
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }
}
