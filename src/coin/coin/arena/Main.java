class Main {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("       BIENVENUE DANS COIN-COIN ARENA !          ");
        System.out.println(
            "=================================================\n"
        );

        // -------------------------------------------------------
        // 1. Création des canards
        // -------------------------------------------------------
        System.out.println("--- Création des canards ---\n");

        CanardFeu flambi = new CanardFeu("Canard Flamme", 39, 52, 1.3);
        CanardFeu brasero = new CanardFeu("Canard Flamme", 39, 52); // intensiteFlamme = 1.0
        CanardEau jaillis = new CanardEau("Canard Torrent", 45, 40, 15);
        CanardEau gouttelot = new CanardEau("Canard Torrent", 45, 40); // pressionJet = 10
        CanardPlante feuillu = new CanardPlante("Canard Feuille", 50, 30);
        CanardPlante herbouil = new CanardPlante("Canard Feuille", 50); // atk = 10
        CanardClassique alfred = new CanardClassique("Canard Normal", 40, 35);
        CanardClassique basique = new CanardClassique("Canard Normal", 40); // atk = ATK_MIN

        System.out.println(
            "Canards créés : " + CanardDeCombat.getNbCanardsCrees()
        );
        System.out.println();

        // -------------------------------------------------------
        // 2. Surnoms
        // -------------------------------------------------------
        System.out.println("--- Attribution des surnoms ---\n");

        flambi.setSurnom("Gérard");
        brasero.setSurnom("Brasero");
        jaillis.setSurnom("Jaillis");
        gouttelot.setSurnom("Gouttelot");
        feuillu.setSurnom("Feuillu");
        herbouil.setSurnom("Herbouil");
        alfred.setSurnom("Alfred");
        basique.setSurnom("Basique");

        // -------------------------------------------------------
        // 3. Affichage toString de chaque canard
        // -------------------------------------------------------
        System.out.println("--- Fiches des canards ---\n");

        System.out.println(flambi);
        System.out.println(brasero);
        System.out.println(jaillis);
        System.out.println(gouttelot);
        System.out.println(feuillu);
        System.out.println(herbouil);
        System.out.println(alfred);
        System.out.println(basique);
        System.out.println();

        // -------------------------------------------------------
        // 4. Combats — table des types
        //    Note (étape A) : getMultiplicateur(CanardDeCombat)
        //    dans la classe mère renvoie toujours 1.0 car la
        //    surcharge est résolue statiquement. Les overloads
        //    typés ne sont jamais appelés depuis attaquer().
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println(" COMBAT 1 : Feu (Gérard) vs Plante (Feuillu)     ");
        System.out.println(
            "=================================================\n"
        );

        flambi.attaquer(feuillu); // devrait être super efficace (x2) — mais renvoie x1 (étape A)
        System.out.println();
        feuillu.attaquer(flambi); // devrait être pas efficace (x0.5) — mais renvoie x1 (étape A)
        System.out.println();

        System.out.println("=================================================");
        System.out.println(" COMBAT 2 : Eau (Jaillis) vs Feu (Brasero)       ");
        System.out.println(
            "=================================================\n"
        );

        jaillis.attaquer(brasero); // devrait être super efficace (x2)
        System.out.println();
        brasero.attaquer(jaillis); // devrait être pas efficace (x0.5)
        System.out.println();

        System.out.println("=================================================");
        System.out.println(" COMBAT 3 : Normal (Alfred) vs tous              ");
        System.out.println(
            "=================================================\n"
        );

        alfred.attaquer(flambi);
        System.out.println();
        alfred.attaquer(jaillis);
        System.out.println();
        alfred.attaquer(feuillu);
        System.out.println();

        // -------------------------------------------------------
        // 5. Régénération de CanardPlante
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println(" RÉGÉNÉRATION de Feuillu                         ");
        System.out.println(
            "=================================================\n"
        );

        System.out.println("État avant : " + feuillu);
        feuillu.regenerer();
        feuillu.regenerer();
        System.out.println("État après : " + feuillu);
        System.out.println();

        // régénération au maximum (ne doit pas dépasser pvMax)
        feuillu.soigner();
        System.out.println("Après soigner() complet : " + feuillu);
        feuillu.regenerer(); // déjà plein, aucun effet visible sur les PV
        System.out.println(
            "Après regenerer() alors que déjà plein : " + feuillu
        );
        System.out.println();

        // -------------------------------------------------------
        // 6. Mise KO et tentative d'attaque depuis KO
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println(" MISE KO de Brasero                              ");
        System.out.println(
            "=================================================\n"
        );

        brasero.soigner();
        System.out.println("PV de Brasero restaurés : " + brasero);
        System.out.println();

        // On frappe jusqu'au KO
        while (!brasero.estKO()) {
            jaillis.attaquer(brasero);
            System.out.println();
        }

        System.out.println("Brasero est KO ? " + brasero.estKO());
        System.out.println();

        // Attaque depuis un canard KO
        System.out.println("--- Brasero essaie d'attaquer malgré le KO ---\n");
        brasero.attaquer(jaillis);
        System.out.println();

        // -------------------------------------------------------
        // 7. Soigner un canard KO
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println(" SOIN de Brasero                                 ");
        System.out.println(
            "=================================================\n"
        );

        brasero.soigner();
        System.out.println("Brasero après soigner() : " + brasero);
        System.out.println("Brasero est KO ? " + brasero.estKO());
        System.out.println();

        // -------------------------------------------------------
        // 8. Validation des paramètres (exceptions attendues)
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println(" TESTS DE VALIDATION                             ");
        System.out.println(
            "=================================================\n"
        );

        // pvMax <= 0
        try {
            new CanardFeu("Mauvais", 0, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("OK - pvMax=0 refusé : " + e.getMessage());
        }

        // atk < ATK_MIN
        try {
            new CanardEau("Mauvais", 10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("OK - atk=0 refusé   : " + e.getMessage());
        }

        // intensiteFlamme hors bornes
        try {
            new CanardFeu("Mauvais", 10, 10, 2.0);
        } catch (IllegalArgumentException e) {
            System.out.println(
                "OK - intensité=2.0 refusée : " + e.getMessage()
            );
        }

        // pressionJet négatif
        try {
            new CanardEau("Mauvais", 10, 10, -5);
        } catch (IllegalArgumentException e) {
            System.out.println(
                "OK - pression=-5 refusée   : " + e.getMessage()
            );
        }

        // surnom null
        try {
            alfred.setSurnom(null);
        } catch (IllegalArgumentException e) {
            System.out.println(
                "OK - surnom null refusé    : " + e.getMessage()
            );
        }

        System.out.println();

        // -------------------------------------------------------
        // 9. Compteur global
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println(" COMPTEUR GLOBAL                                 ");
        System.out.println(
            "=================================================\n"
        );

        System.out.println(
            "Nombre total de canards instanciés (y compris les invalides qui ont échoué) : " +
                CanardDeCombat.getNbCanardsCrees()
        );
        System.out.println();

        System.out.println("=================================================");
        System.out.println("                   FIN DE L'ARÈNE                ");
        System.out.println("=================================================");
    }
}
