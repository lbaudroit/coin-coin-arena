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
    
    public void attaquer(CanardDeCombat cible) {
        double mult = cible.etreAttaqueePar(this) * intensiteFlamme;
        effectuerAttaque(cible, mult);
    }
    
    @Override
    public double etreAttaqueePar(CanardFeu attaquant) {
        return 0.5;
    }
    
    @Override
    public double etreAttaqueePar(CanardEau attaquant) {
        return 2.0;
    }
    
    @Override
    public double etreAttaqueePar(CanardPlante attaquant) {
        return 0.5;
    }
}
