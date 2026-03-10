class Arene {

    /**
     * Simule un combat entre deux équipes jusqu'à ce que l'une soit
     * entièrement KO. Affiche le déroulement tour par tour.
     */
    public void combattre(Equipe e1, Equipe e2) {
        System.out.println("=== COMBAT ===");
        System.out.println();

        CanardDeCombat c1 = e1.getPremierValide();
        CanardDeCombat c2 = e2.getPremierValide();

        if (c1 == null || c2 == null) {
            System.out.println(
                "Une équipe est déjà entièrement KO avant le début !"
            );
            return;
        }

        int tour = 0;

        while (!e1.touteKO() && !e2.touteKO()) {
            tour++;
            System.out.print("Tour " + tour + " : ");

            // --- Attaque de c1 vers c2 ---
            c1.attaquer(c2);

            if (c2.estKO()) {
                System.out.println(c2.getSurnom() + " est KO !");
                if (!e2.touteKO()) {
                    c2 = e2.getPremierValide();
                    System.out.println(
                        e2.getNomDresseur() + " envoie " + c2.getSurnom() + " !"
                    );
                }
            }

            if (e2.touteKO()) break;

            // --- Attaque de c2 vers c1 ---
            c2.attaquer(c1);

            if (c1.estKO()) {
                System.out.println(c1.getSurnom() + " est KO !");
                if (!e1.touteKO()) {
                    c1 = e1.getPremierValide();
                    System.out.println(
                        e1.getNomDresseur() + " envoie " + c1.getSurnom() + " !"
                    );
                }
            }

            if (e1.touteKO()) break;

            // --- Régénération des CanardPlante en fin de tour ---
            regenererSiPlante(c1);
            regenererSiPlante(c2);

            System.out.println();
        }

        System.out.println();
        afficherRecapitulatif(e1, e2, tour);
    }

    /**
     * Régénère le canard s'il est un CanardPlante et qu'il n'est pas KO.
     */
    private void regenererSiPlante(CanardDeCombat canard) {
        if (canard instanceof CanardPlante && !canard.estKO()) {
            ((CanardPlante) canard).regenerer();
        }
    }

    /**
     * Affiche le récapitulatif de fin de combat :
     * vainqueur, nombre de tours, survivants.
     */
    private void afficherRecapitulatif(Equipe e1, Equipe e2, int nbTours) {
        System.out.println("=================================================");
        System.out.println(" FIN DU COMBAT après " + nbTours + " tour(s)");
        System.out.println("=================================================");
        System.out.println();

        Equipe vainqueur = e1.touteKO() ? e2 : e1;
        Equipe perdant = e1.touteKO() ? e1 : e2;

        System.out.println("Vainqueur : " + vainqueur.getNomDresseur() + " !");
        System.out.println();

        System.out.println(
            "Survivants de " + vainqueur.getNomDresseur() + " :"
        );
        vainqueur.afficher();
        System.out.println();

        System.out.println(
            "Équipe de " + perdant.getNomDresseur() + " (tous KO) :"
        );
        perdant.afficher();
    }
}
