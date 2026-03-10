# Réflexion R1
Il faudra pouvoir mutualiser les informations communes à l'espèce (nom, PV de base, attaque de base).

# Réflexion R2
Les différentes méthodes doivent permettre d'obtenir le multiplicateur pour une cible donnée.
Elles ne fonctionnent pas, car la liaison dynamique s'applique sur les méthodes redéfinies au sein d'une arborscence. Elle ne s'applique pas pour appeler une méthode surchargée en fonction du type des paramètres.

Il nous faut donc utiliser les mécanismes d'héritage pour choisir le multiplicateur. Depuis l'attaquant, le type d'attaque est statique, mais le type de la cible n'est pas forcément défini. On va donc appeler une méthode sur la cible, correspondant au type de l'attaquant. En fonction du type de la cible, on aura le multiplicateur correspondant grâce à la liaison dynamique.

# Réflexion R3
Au total, on a 4 types différents avec 4 types d'attaquant différents. Cependant, nous n'avons pas redéfini les multiplicateurs de 1.0, donc au total on a 3*3 redéfinitions.
Si on ajoutait un nouveau type, on devrait ajouter le multiplicateur dans chaque autre type et définir les 5 multiplicateurs du nouveau type, soit (n-1)+(n)=2n-1 multiplications avec n le nouveau nombre de types.

# Réflexion R4
Si l'arène accepte des Combattants, l'utilisation de l'interface permettrait d'accepter toutes sortes de combattants. 
De la même manière, Soignable permet à toute classe avec des PV d'avoir un comportement similaire.

# Réflexion R5
Avec 4 types et 3 comportements spéciaux, on aurait 12 types spéciaux, ou 16 en comptant les types de base (comme CanardFeu). Idéalement, il faudrait implémenter ces comportements différemment (par composition ?)
