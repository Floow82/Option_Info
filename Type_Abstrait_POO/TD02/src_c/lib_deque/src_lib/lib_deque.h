#ifndef lib_deque_h
#define lib_deque_h

typedef struct deque T_deque;

/* Initialisation du Deque*/
T_deque *init();

/*Nombre d'élément dans le Deque*/
int SizeDeque (const T_deque *dq);

/*Insertion d'éléments*/
void InsertDebut ( T_deque *dq, const void *el);
void InsertFin ( T_deque *dq, const void *el);

/*Retirer des éléments*/
void *RemoveDebut (T_deque *dq);
void *RemoveFin (T_deque *dq);

/*Effacer le deque*/
void DeleteDeque(T_deque *dq);

/*Afficher le deque*/
void PrintDeque(const T_deque *dq, void (*printElem)(void *));
/*Pointeur de fonction pour spécifier une fonction d'impression
spécifique aux éléments du deque*/

#endif