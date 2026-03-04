# Réflexion R1
Il faudra pouvoir mutualiser les informations communes à l'espèce (nom, PV de base, attaque de base).

# Réflexion R2
Les différentes méthodes doivent permettre d'obtenir le multiplicateur pour une cible donnée.
Elles ne fonctionnent pas, car la liaison dynamique s'applique sur les méthodes redéfinies au sein d'une arborscence. Elle ne s'applique pas pour appeler une méthode surchargée en fonction du type des paramètres.

Il nous faut donc utiliser les mécanismes d'héritage pour choisir le multiplicateur. Depuis l'attaquant, le type d'attaque est statique, mais le type de la cible n'est pas forcément défini. On va donc appeler une méthode sur la cible, correspondant au type de l'attaquant. En fonction du type de la cible, on aura le multiplicateur correspondant grâce à la liaison dynamique.