#include "libarbre.h"
#include <assert.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>

#undef MAX
#define MAX(a, b) ((a) > (b) ? (a) : (b))

struct t_noeud
{
    void *valeur;
    t_arbre sag;
    t_arbre sad;
};
typedef struct t_noeud t_noeud;

t_arbre arbreVide() { return NULL; }

t_arbre arbreCons(const void *elem, const t_arbre ag, const t_arbre ad)
{
    t_noeud *noeud;
    noeud = (t_noeud *)malloc(sizeof(t_noeud));
    if (noeud == NULL)
    {
        perror("Erreur dans arbreCons : malloc");
        return NULL;
    }
    noeud->valeur = (void *)elem;
    noeud->sag = ag;
    noeud->sad = ad;
    return noeud;
}

t_arbre feuilleCons(const void *elem) { return arbreCons(elem, NULL, NULL); }

int estVide(const t_arbre arb) { return (arb == NULL); }

void *valeurArbre(const t_arbre arb)
{
    assert(!estVide(arb));
    return arb->valeur;
}

t_arbre sagArbre(const t_arbre arb)
{
    if (!(estVide(arb)))
    {
        return arb->sag;
    }
    errno = EINVAL;
    return NULL;
}

t_arbre sadArbre(const t_arbre arb)
{
    if (!(estVide(arb)))
    {
        return arb->sad;
    }
    errno = EINVAL;
    return NULL;
}

int hauteurArbre(const t_arbre arb)
{
    if (estVide(arb))
    {
        return 0;
    }
    else if (sagArbre(arb) == NULL && sadArbre(arb) == NULL)
    {
        return 0;
    }
    else
    {
        return MAX(hauteurArbre(sagArbre(arb)), hauteurArbre(sadArbre(arb))) +
               1;
    }
}

int tailleArbre(const t_arbre arb)
{
    if (estVide(arb))
    {
        return 0;
    }
    else
    {
        return tailleArbre(sagArbre(arb)) + tailleArbre(sadArbre(arb)) + 1;
    }
}

void supprArbre(t_arbre *arb)
{
    if (*arb != NULL)
    {
        supprArbre(&((*arb)->sag));
        supprArbre(&((*arb)->sad));
        free(*arb);
        *arb = NULL;
    }
}

void afficheArbreIndent(const t_arbre arb, void (*print_elem)(void *),
                        const int indent, const char fils)
{
    int i;
    if (arb == NULL)
    {
        return;
    }
    for (i = 0; i < indent - 1; i++)
    {
        printf("│-    ");
    }
    if (indent > 0)
    {
        printf("├──%c-", fils);
    }
    print_elem(arb->valeur);
    printf("\n");
    afficheArbreIndent(arb->sag, print_elem, indent + 1, 'g');
    afficheArbreIndent(arb->sad, print_elem, indent + 1, 'd');
}

void afficheArbre(const t_arbre arb, void (*print_elem)(void *))
{
    afficheArbreIndent(arb, print_elem, 0, 'r');
}

/*****************************************************************************/
/*                                  Parcours                                 */
/*****************************************************************************/

void prefixe_rec(const t_arbre arb, void (*display_elem)(void *))
{
    if (!estVide(arb))
    {
        display_elem(arb->valeur);
        prefixe_rec(sagArbre(arb), display_elem);
        prefixe_rec(sadArbre(arb), display_elem);
    }
}

void prefixe(const t_arbre arb, void (*display_elem)(void *))
{
    if (!estVide(arb))
    {
        prefixe_rec(arb, display_elem);
    }
    else
    {
        errno = EINVAL;
    }
}

void infixe_rec(const t_arbre arb, void (*display_elem)(void *))
{
    if (!estVide(arb))
    {
        infixe_rec(sagArbre(arb), display_elem);
        display_elem(arb->valeur);
        infixe_rec(sadArbre(arb), display_elem);
    }
}

void infixe(const t_arbre arb, void (*display_elem)(void *))
{
    if (!estVide(arb))
    {
        infixe_rec(arb, display_elem);
    }
    else
    {
        errno = EINVAL;
    }
}

void suffixe_rec(const t_arbre arb, void (*display_elem)(void *))
{
    if (!estVide(arb))
    {
        suffixe_rec(sagArbre(arb), display_elem);
        suffixe_rec(sadArbre(arb), display_elem);
        display_elem(arb->valeur);
    }
}

void suffixe(const t_arbre arb, void (*display_elem)(void *))
{
    if (!estVide(arb))
    {
        suffixe_rec(arb, display_elem);
    }
    else
    {
        errno = EINVAL;
    }
}

void largeur_rec(const t_arbre arb, void (*display_elem)(void *), const int niv)
{
    if (estVide(arb))
    {
        return;
    }
    if (niv == 0)
    {
        display_elem(valeurArbre(arb));
    }
    else if (niv > 0)
    {
        largeur_rec(sagArbre(arb), display_elem, niv - 1);
        largeur_rec(sadArbre(arb), display_elem, niv - 1);
    }
}

void largeur(const t_arbre arb, void (*display_elem)(void *))
{
    int i;
    if (!estVide(arb))
    {
        for (i = 0; i <= hauteurArbre(arb); i++)
        {
            largeur_rec(arb, display_elem, i);
        }
    }
    else
    {
        errno = EINVAL;
    }
}