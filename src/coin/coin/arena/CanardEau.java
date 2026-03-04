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

    public double getMultiplicateur(CanardFeu cible) {
        System.out.println(
            " Jet d'eau (pression: %d) !".formatted(pressionJet)
        );
        return 2.0; // Eau vs Feu
    }

    public double getMultiplicateur(CanardEau cible) {
        System.out.println(
            " Jet d'eau (pression: %d) !".formatted(pressionJet)
        );
        return 0.5; // Eau vs Eau
    }

    public double getMultiplicateur(CanardPlante cible) {
        System.out.println(
            " Jet d'eau (pression: %d) !".formatted(pressionJet)
        );
        return 0.5; // Eau vs Plante
    }

    public double getMultiplicateur(CanardClassique cible) {
        System.out.println(
            " Jet d'eau (pression: %d) !".formatted(pressionJet)
        );
        return 1.0; // Eau vs Normal
    }
}
