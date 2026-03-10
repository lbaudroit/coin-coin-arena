class CanardEau extends CanardDeCombat {

    private int pressionJet;

    public CanardEau(String nom, int pvMax, int atk, int pressionJet) {
        super(nom, pvMax, atk);
        if (pressionJet < 0) {
            throw new IllegalArgumentException("pressionJet doit être >= 0.");
        }
        this.pressionJet = pressionJet;
    }

    public CanardEau(String nom, int pvMax, int atk) {
        this(nom, pvMax, atk, 10);
    }

    public int getPressionJet() {
        return pressionJet;
    }

    public void setPressionJet(int pressionJet) {
        if (pressionJet < 0) {
            throw new IllegalArgumentException("pressionJet doit être >= 0.");
        }
        this.pressionJet = pressionJet;
    }

    @Override
    public String getType() {
        return "Eau";
    }

    @Override
    public String toString() {
        return super.toString() + " [Pression: %d]".formatted(pressionJet);
    }
    
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }
    
    @Override
    public double etreAttaqueePar(CanardFeu attaquant) {
        return 0.5;
    }
    
    @Override
    public double etreAttaqueePar(CanardEau attaquant) {
        return 0.5;
    }
    
    @Override
    public double etreAttaqueePar(CanardPlante attaquant) {
        return 2.0;
    }
}
