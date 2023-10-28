#ifndef monmodule_h
#define monmodule_h

typedef struct matrice *T_matrice;

T_matrice initMatrice (const int n, const int m);
void destMatrice (const T_matrice *mat);
void saisieMatrice (const T_matrice mat);
void afficheMatrice (const T_matrice mat);
T_matrice sommeMatrice (const T_matrice mat1, const T_matrice mat2);
char *matriceToString (const T_matrice mat);
#endif