#include <ostream>
using namespace std;
namespace libdeque
{
    typedef struct deque T_deque;

    /* Initialisation du Deque*/
    T_deque *init()
        noexcept(false);

    /*Nombre d'élément dans le Deque*/
    int SizeDeque (const T_deque *dq)
        noexcept(false);

    /*Insertion d'éléments*/
    void InsertDebut ( T_deque *dq, const void *el)
        noexcept(false);
    void InsertFin ( T_deque *dq, const void *el)
        noexcept(false);

    /*Retirer des éléments*/
    void *RemoveFin (T_deque *dq)
        noexcept(false);

    /*Effacer le deque*/
    void DeleteDeque(T_deque *dq)
        noexcept(false);

    /*Afficher le deque*/
    void PrintDeque(const T_deque *dq, void (*printElem)(void *))
        noexcept(false);
    /*Pointeur de fonction pour spécifier une fonction d'impression
    spécifique aux éléments du deque*/
}
