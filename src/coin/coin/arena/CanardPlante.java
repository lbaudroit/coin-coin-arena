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

    public double getMultiplicateur(CanardFeu cible) {
        return 0.5; // Plante vs Feu → 0.5
    }

    public double getMultiplicateur(CanardEau cible) {
        return 2.0; // Plante vs Eau → 2.0
    }

    public double getMultiplicateur(CanardPlante cible) {
        return 0.5; // Plante vs Plante → 0.5
    }

    public double getMultiplicateur(CanardClassique cible) {
        return 1.0; // Plante vs Normal → 1.0
    }
}
