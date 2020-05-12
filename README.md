# Space invaders IUT
![ImgSpace](https://thumbs.gfycat.com/PlasticGenuineFawn-max-1mb.gif)

# Sommaire :
- [Semaine 1 : 30/03/2020 - 05/04/2020](#semaine1)
- [Semaine 2 : 04/05/2020 - 10/05/2020](#semaine2)
- [Glossaire](#glossaire)


## Semaine 1 <a id="semaine1"></a>
### Fonctinnalité 1 : Déplacer vaisseau dans espace de jeu
- Story n°1.1 : Créer un espace de jeu  
Un espace de jeu est créé aux dimensions données (2D) 
Cet espace de jeu est vide

-  Story n°1.2 : Positionner un nouveau vaisseau dans l’espace de jeu  
Un nouveau vaisseau est créé
Le vaisseau est positionné aux coordonnées transmises
Si un nouveau vaisseau essaye d’être positionné en dehors des limites de l’espace jeu, alors une exception devra être levée.
 Contraintes :
La position souhaitée est transmise par ses coordonnées x et y.
Le coin supérieur gauche de l’espace jeu (point en haut à gauche) a pour coordonnées (0,0)
La taille du vaisseau est réduite pour l'instant à son minimum (1 seul point)

- Story n°1.3 : Déplacer le vaisseau vers la droite dans l'espace de jeu  
Le vaisseau se déplace d'un pas vers la droite 
Si le vaisseau se trouve sur la bordure droite de l'espace de jeu, le vaisseau doit rester immobile (aucun déplacement, aucune exception levée : le vaisseau reste juste à sa position actuelle).


- Story n°1.4 : Déplacer le vaisseau vers la gauche dans l'espace de jeu  
Le vaisseau se déplace d'un pas vers la gauche 
Si le vaisseau se trouve sur la bordure gauche de l'espace de jeu, le vaisseau doit rester immobile (aucun déplacement, aucune exception levée : le vaisseau reste juste à sa position actuelle).

### Diagramme de classe : 
![Diagrammes de classes semaine 1](img/diagrammeDeClassesWeek1.png)

### Nuage de mots :
![Nuage de mots](img/nuageMotWeek1.png)

## Semaine 2 <a id="semaine2"></a>
### Fonctinnalité 2 : Dimensionner le vaisseau

- Story n°2.1 : Positionner un nouveau vaisseau avec une dimension donnée.
Un nouveau vaisseau est créé aux dimensions données (2D). Ce vaisseau est positionné aux coordonnées transmises.

- Story n°2.2 : Faire en sorte qu'il soit impossible de positionner un nouveau vaisseau qui déborde de l'espace de jeu.
Si un nouveau vaisseau essaye d’être positionné en dehors des limites de l’espace jeu, alors une exception est levée. Si une partie du vaisseau créé est en dehors des limites de l'espace de jeu, alors une exception est levée. Contraintes : La position souhaitée est transmise par ses coordonnées x et y. Le coin inférieur gauche du vaisseau correspond a l'origine du vaisseau.

- Story n°2.3 : Déplacer un vaisseau vers la droite en tenant compte de sa dimension.
Le vaisseau se déplace d'un pas vers la droite. Refactoring de la Story 1.3 en prenant en compte la largeur du vaisseau. Si le bord droit du vaisseau se trouve sur la bordure droite de l'espace de jeu, le vaisseau doit rester immobile.

- Story n°2.4 : Déplacer un vaisseau vers la droite en tenant compte de sa dimension.
Le vaisseau se déplace d'un pas vers la gauche. Refactoring de la Story 1.4 en prenant en compte la largeur du vaisseau. Si le bord gauche du vaisseau se trouve sur la bordure gauche de l'espace de jeu, le vaisseau doit rester immobile.

- Story n°2.5 : Refactoring.
Création des classes Position et Dimension. Implémentation de ces classes dans les classes SpaceInvaders et Vaisseau.

### Diagramme de classe : 
![Diagrammes de classes semaine 2](img/diagrammeDeClassesWeek2.png)

### Nuage de mots :
![Nuage de mots 2](img/nuageMotWeek2.png)

## Glossaire <a id="glossaire"></a>

**Vaisseau** : Véhicule commandé par le joueur, pouvant se déplacer de droite à gauche et ayant la possibilité de lancer des missiles destinés à détruire les envahisseurs.

**Envahisseur** : Ennemi qui apparaît à l'écran, se déplace automatiquement et qui doit être détruit par un missile lancé depuis le vaisseau du joueur.

**Missile** : Projectile envoyé à la verticale par le vaisseau vers l'envahisseur dans le but de le détruire.

--------------------- 
