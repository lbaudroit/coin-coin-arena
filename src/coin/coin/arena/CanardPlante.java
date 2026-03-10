class CanardPlante extends CanardDeCombat {

    public CanardPlante(String nom, int pvMax, int atk) {
        super(nom, pvMax, atk);
    }

    public CanardPlante(String nom, int pvMax) {
        this(nom, pvMax, 10);
    }

    @Override
    public String getType() {
        return "Plante";
    }

    /**
     * Restaure 10 % des PV max à chaque tour, sans dépasser pvMax.
     */
    public void regenerer() {
        int pvSoin = (int) Math.round(getPvMax() * 0.10);
        int nouveauxPv = Math.min(getPvActuels() + pvSoin, getPvMax());
        setPvActuels(nouveauxPv);
        
        System.out.println(
            "%s se régénère et récupère %d PV ! (PV: %d/%d)".formatted(
                getSurnom(),
                pvSoin,
                getPvActuels(),
                getPvMax()
            )
        );
    }

    @Override
    public String toString() {
        return super.toString() + " [Régénération: 10% PV max/tour]";
    }
    
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this);
        effectuerAttaque(cible, mult);
    }
    
    @Override
    public double etreAttaqueePar(CanardFeu attaquant) {
        return 2.0;
    }
    
    @Override
    public double etreAttaqueePar(CanardEau attaquant) {
        return 0.5;
    }
    
    @Override
    public double etreAttaqueePar(CanardPlante attaquant) {
        return 0.5;
    }
}
