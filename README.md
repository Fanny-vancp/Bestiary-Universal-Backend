# BestiaryUniversal

## Description
Ce projet est dédié à la création d'une Api avec une architecture hexagonale.
Ce projet à pour but de créer un site web qui permet de répertorié plein de créature de plusieurs univers différents.


## Requêtes 
### Get
https://bestiary.onrender.com/beasts -> renvoie toutes les créatures stocker

https://bestiary.onrender.com/beasts?universe=1 -> renvoie toutes les créatures appartenant à l'univers dont l'id
a été envoyé dans la tête de la requête

https://bestiary.onrender.com/beasts?user=1 -> renvoie tout les créatures favorites de l'utilisateur dont l'id 
à été envoyé dans la tête de la requête

https://bestiary.onrender.com/universes -> renvoie toute les univers stocker

https://bestiary.onrender.com/users -> renvoie tout les users

### Post
https://bestiary.onrender.com/beast -> permet d'ajouter une nouvelle créature grâce au corps de la requête

https://bestiary.onrender.com/favoris?beast=1&user=1 -> permet d'ajouter une créature dans les favoris d'un utilisateur
grâce à l'id de la bête et l'id de l'utilisateur dans le tête de la requête

https://bestiary.onrender.com/universe -> permet d'ajouter un nouveau univers grâce au coprs de la requête

https://bestiary.onrender.com/user -> permet de créer un nouvel utilisateur grâce au coprs de la requête

### Delete
https://bestiary.onrender.com/beast?idBeast=1 -> permet de supprimer une créature en récupérant son id 
dans la tête de la requête

https://bestiary.onrender.com/universe?idUniverse=1 -> peremt de supprimer un univers en récupérant son id 
dans la tête de la requête

https://bestiary.onrender.com/user?idUser=1 -> permet de supprimer un utilisateur en récupérant son id 
dans la tête de la requête

