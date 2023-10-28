#ifndef liste_h
#define liste_h

typedef struct liste *T_liste;

T_liste initListe();

void first(const T_liste l);
void last(const T_liste l);
void next(const T_liste l);
void prev(const T_liste l);
int InsertFirst(T_liste l, const void *el);
int InsertLast(T_liste l, const void *el);
void *element(T_liste l);
void *RemplaceEl (T_liste l, const void *el);
void InsertPrev(T_liste l, const void *el);
void InsertNext(T_liste l, const void *el);
void *RemoveElem(T_liste l);
int listeVide(T_liste l);
int SizeListe (const T_liste l);
void PrintListe (const T_liste l, void (*printElem)(void *));
void deleteListe(T_liste *li);
#endif