#ifndef LIBARB_H
#define LIBARB_H

typedef struct t_noeud *t_arbre;

t_arbre chercheNoeud (const t_arbre arb, const void *val, int (*compare_elem)(void *v1), void *v2)
int recherche(const t_arbre arb, const void *val, int (*compare_elem)(void *v1, void *v2))

#endif