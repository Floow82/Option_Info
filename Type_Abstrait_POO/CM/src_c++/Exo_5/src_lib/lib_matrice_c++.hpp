#include <ostream>
using namespace std;
namespace libmatrice
{
    typedef struct matrice *T_matrice;

    /* Création d'une matrice n*m */
    T_matrice creationMatrice(const int n, const int m) noexcept(false);

    /* saisie clavier de la matrice mat*/
    void saisieMatrice(const T_matrice mat) noexcept(false);

    /* Affichage Ecran de la matrice mat */
    void afficheMatrice(const T_matrice mat) noexcept(false);

    /* Désalloue une matrice mat */
    void detruireMatrice(T_matrice &mat) noexcept(false);

    /* Somme de deux matrices m1 et m2 de dimension identique */
    T_matrice operator+(const struct matrice &m1, const struct matrice &m2);

    /* Retourne la représentation d'une matrice au format chaine de caractères */
    ostream & operator<<(ostream & os, T_matrice mat);

}
