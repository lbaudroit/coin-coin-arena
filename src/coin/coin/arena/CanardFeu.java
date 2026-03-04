class CanardFeu extends CanardDeCombat {

    private double intensiteFlamme;

    public CanardFeu(String nom, int pvMax, int atk, double intensiteFlamme) {
        super(nom, pvMax, atk);
        if (intensiteFlamme < 0.8 || intensiteFlamme > 1.5) {
            throw new IllegalArgumentException(
                "intensiteFlamme doit être entre 0.8 et 1.5."
            );
        }
        this.intensiteFlamme = intensiteFlamme;
    }

    public CanardFeu(String nom, int pvMax, int atk) {
        this(nom, pvMax, atk, 1.0);
    }

    public double getIntensiteFlamme() {
        return intensiteFlamme;
    }

    public void setIntensiteFlamme(double intensiteFlamme) {
        if (intensiteFlamme < 0.8 || intensiteFlamme > 1.5) {
            throw new IllegalArgumentException(
                "intensiteFlamme doit être entre 0.8 et 1.5."
            );
        }
        this.intensiteFlamme = intensiteFlamme;
    }

    @Override
    public String getType() {
        return "Feu";
    }

    @Override
    public String toString() {
        return super.toString() + " [Flamme: x%.2f]".formatted(intensiteFlamme);
    }

    public double getMultiplicateur(CanardFeu cible) {
        return 0.5 * intensiteFlamme;
    }

    public double getMultiplicateur(CanardEau cible) {
        return 0.5 * intensiteFlamme;
    }

    public double getMultiplicateur(CanardPlante cible) {
        return 2.0 * intensiteFlamme;
    }

    public double getMultiplicateur(CanardClassique cible) {
        return 1.0 * intensiteFlamme;
    }
}
