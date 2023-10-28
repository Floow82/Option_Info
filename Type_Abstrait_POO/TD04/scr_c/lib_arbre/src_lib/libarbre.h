#ifndef LIBARBRE_H_
#define LIBARBRE_H_

typedef struct t_noeud *t_arbre;

/**
 * Initialisation d'un t_arbre
 **/
t_arbre arbreVide();

/**
 * Construction d'un arbre binaire
 *
 * elem : valeur du noeud
 * ag : sous-arbre gauche
 * ad : sous-arbre droit
 **/
t_arbre arbreCons(const void *elem, const t_arbre ag, const t_arbre ad);

/**
 * Construction d'une feuille
 * elem : valeur de la feuille
 **/
t_arbre feuilleCons(const void *elem);

/**
 * Test si l'arbre est vide
 **/
int estVide(const t_arbre arb);

/**
 * Obtient la valeur de l'arbre
 *
 * return : valeur de la racine
 **/
void *valeurArbre(const t_arbre arb);

/**
 * Obtient le sous-arbre gauche de l'arbre.
 *
 * return : t_arbre (sag)
 **/
t_arbre sagArbre(const t_arbre arb);

/**
 * Obtient le sous-arbre droit
 *
 * return : t_arbre (sad)
 **/
t_arbre sadArbre(const t_arbre arb);

/**
 * Obtient la taille de l'arbre
 *
 * return : int
 **/
int tailleArbre(const t_arbre arb);

/**
 * Obtient la hauteur de l'arbre
 *
 * return : int
 **/
int hauteurArbre(const t_arbre arb);

/**
 * Suppression mémoire d'un arbre et de son contenu
 *
 * arb = NULL
 **/
void supprArbre(t_arbre *arb);

/**
 * Provoque l'affichage de l'arbre à la console
 **/
void afficheArbre(const t_arbre arb, void (*print_elem)(void *));


/**
 * Parcours profondeur préfixe (récursif)
 **/
void prefixe(const t_arbre arb, void (*display_elem)(void *));

/**
 * Parcours profondeur infixe (récursif)
 **/
void infixe(const t_arbre arb, void (*display_elem)(void *));

/**
 * Parcours profondeur suffixe (récursif)
 **/
void suffixe(const t_arbre arb, void (*display_elem)(void *));

/**
 * Parcours largeur (récursif)
 **/
void largeur(const t_arbre arb, void (*display_elem)(void *));

#endif