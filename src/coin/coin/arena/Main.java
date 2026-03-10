class Main {

    public static void main(String[] args) {
        // -------------------------------------------------------
        // 1. Création des équipes
        // -------------------------------------------------------
        Equipe sacha = new Equipe("Sacha");
        Equipe ondine = new Equipe("Ondine");

        // --- Équipe de Sacha ---
        CanardFeu gerard = new CanardFeu("Canard Flamme", 39, 52, 1.3);
        gerard.setSurnom("Gérard");

        CanardConfus coinCoin = new CanardConfus("Canard Confus", 52, 48);
        coinCoin.setSurnom("Coin-Coin");

        CanardPlante fernand = new CanardPlante("Canard Mousse", 45, 49);
        fernand.setSurnom("Fernand");

        CanardClassique riri = new CanardClassique("Canard Normal", 38, 30);
        riri.setSurnom("Riri");

        sacha.ajouter(gerard);
        sacha.ajouter(coinCoin);
        sacha.ajouter(fernand);
        sacha.ajouter(riri);

        // --- Équipe d'Ondine ---
        CanardEau hubert = new CanardEau("Canard Marin", 44, 48, 15);
        hubert.setSurnom("Hubert");

        CanardClassique marcel = new CanardClassique(
            "Canard Classique",
            50,
            45
        );
        marcel.setSurnom("Marcel");

        CanardFeu josette = new CanardFeu("Canard Braise", 42, 55, 1.1);
        josette.setSurnom("Josette");

        CanardPlante flora = new CanardPlante("Canard Fougère", 60, 35);
        flora.setSurnom("Flora");

        ondine.ajouter(hubert);
        ondine.ajouter(marcel);
        ondine.ajouter(josette);
        ondine.ajouter(flora);

        // -------------------------------------------------------
        // 2. Affichage des équipes
        // -------------------------------------------------------
        sacha.afficher();
        System.out.println();
        ondine.afficher();
        System.out.println();

        // -------------------------------------------------------
        // 3. Combat
        // -------------------------------------------------------
        Arene arene = new Arene();
        arene.combattre(sacha, ondine);

        // -------------------------------------------------------
        // 4. Compteur global
        // -------------------------------------------------------
        System.out.println(
            "Nombre total de canards instanciés : " +
                CanardDeCombat.getNbCanardsCrees()
        );
    }
}
