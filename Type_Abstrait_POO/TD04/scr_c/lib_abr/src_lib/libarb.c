#include "libarb.h"
#include <errno.h>
#include <stdlib.h>

t_arbre chercheNoeud (const t_arbre arb, const void *val, int (*compare_elem)(void *v1), void *v2)
{
    if (!estVide(arb))
    {
        int comp = compare_elem((void*)val, valeurArbre(arb));
        if (comp == 0)
        {
            return arb;
        }
        if (comp == -1)
        {
            return chercheNoeud(sagArbre(arb), val, compare_elem);
        }
        return chercheNoeud (sadArbre(arb), val, compare_elem);
    }
    return NULL;
}
int recherche(const t_arbre arb, const void *val, int (*compare_elem)(void *v1, void *v2))
{
    t_arbre noeud;
}

t_arbre chercherFeuille(const t_arbre arb, const void *val, int (*compare_elem)(void *v1, void *v2))
{
    if (estVide(sagArbre(arb)))
    {
        if (estVide(sagArbre(arb)))
        {
            return arb;
        }
        else
        {
            return cherhcerFeuille(sagArbre(arb), val, compare_elem);
        }
    }
    else
    {
        if (estVide (sadArbre(arb)))
        {
            return arb;
        }
        else
        {
            return chercheFeuille(sadArbre(arb), val, compare_elem);
        }
    }
    return arb;

}