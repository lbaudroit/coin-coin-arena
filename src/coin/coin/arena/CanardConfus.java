import java.util.Random;

class CanardConfus extends CanardEau {

    private boolean enrage;
    private final Random random;

    public CanardConfus(String nom, int pvMax, int atk, int pressionJet) {
        super(nom, pvMax, atk, pressionJet);
        this.enrage = false;
        this.random = new Random();
    }

    public CanardConfus(String nom, int pvMax, int atk) {
        this(nom, pvMax, atk, 10);
    }

    @Override
    public String toString() {
        return super.toString() + " 🌀";
    }

    public void migraine() {
        System.out.println(
            "%s se tient la tête... COIN. COIN.".formatted(getSurnom())
        );
        enrage = true;
    }

    @Override
    public void attaquer(CanardDeCombat cible) {
        boolean confus = random.nextInt(4) == 0;

        if (confus) {
            System.out.println(
                "%s est confus ! Il se cogne la tête... Coin coin ?".formatted(
                    getSurnom()
                )
            );
            double mult = enrage ? 2.0 : 1.0;
            enrage = false;
            int degats = (int) (getAtk() * mult);
            System.out.println(
                "%s s'inflige %d dégâts à lui-même !".formatted(
                    getSurnom(),
                    degats
                )
            );
            subirDegats(degats);
        } else {
            double mult = cible.etreAttaqueePar(this);
            if (enrage) {
                mult *= 2.0;
                enrage = false;
            }
            effectuerAttaque(cible, mult);
        }
    }
}
