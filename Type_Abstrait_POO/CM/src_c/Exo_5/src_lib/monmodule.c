#include "monmodule.h"
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct matrice
{
    int n;
    int m;
    float **matrice;
};

T_matrice initMatrice (const int n, const int m)
{
    int i;
    T_matrice mat;
    errno =0;

    /*Allocation dynamique de l'espace memoire pour pouvoir accder a n et m*/
    /*Stock l'adresse de la mémoire dans mat*/
    mat = (struct matrice *)malloc(sizeof(struct matrice));

    /*Probleme sur l'allocation*/
    if (errno) {
        perror("Erreur allocation structure matrice");
        return NULL;
    }

    /*Alloue dynamiquement un tableau de pointeur vers des lignes de la matrice*/
    /*n elements pointeur de taille float * */
    mat->matrice = (float **)calloc(n, sizeof(float *));

    /*erreur sur le valeur de n*/
    if (errno){
        perror("Erreur sur l'allocation de dim ligne");
        return NULL;
    }

    /*Alloue dynamiquement de la memoire pour chaque colonne de la matrice*/
    /* m element de type float*/
    for (i=0; i<n; i++){
        mat->matrice[i] = (float*)calloc(m, sizeof(float));
    }
    /*erreur sur m*/
    if (errno){
        perror("Erreur sur l'allocation de dim col");
        return NULL;
    }

    mat->n = n;
    mat->m = m;
    /*renvoie un pointeur vers une structure matrice*/
    return mat;
}

void destMatrice (const T_matrice *mat)
{
    int i;
    errno=0;

    if ((*mat) != NULL){
        if ((*mat)->matrice !=NULL){
            for (i=0; i< (*mat)->n; i++){
                if ((*mat)->matrice[i] !=NULL){
                    free((*mat)->matrice[i]);
                    (*mat)->matrice[i]=NULL;
                }
                else{
                    errno = 1;
                    return;
                }
            }
            free((*mat)->matrice);
            (*mat)->matrice=NULL;
        }
        else{
            errno=1;
            return;
        }
        free(*mat);
        mat=NULL;
    }
    else{
        errno=1;
        return;
    }
}
void saisieMatrice (const T_matrice mat){

}
/*Attention ligne 102, les 2 crochets enlevent le referencement, si l'argument est une addresse il faut ajouter "&" devant les crochets*/
void afficheMatrice (const T_matrice mat)
{
    int i;
    int j;
    if (mat != NULL){
        if (mat->matrice != NULL){
            for (i=0; i<mat->n; i++){
                if (mat->matrice[i]){
                    for (j=0; j<mat->n; j++){
                        printf("%.2f", mat->matrice[i][j]);
                    }
                    printf("\n");
                }
                else{
                    errno=EEXIST;
                    return;
                }
            }
        }
        else{
            errno = EEXIST;
            return;
        }
    }
    else{
        return;
        errno = EEXIST;
    }
}

T_matrice sommeMatrice (const T_matrice mat1, const T_matrice mat2){
    int i, j;
    /*faire une fonction de verification d'existance ca irait plus vite*/
    if ((mat1 != NULL) && (mat2 != NULL)){
        if ((mat1->n == mat2->n)&&(mat1->m == mat2->m)){
            if ((mat1->matrice != NULL)&&(mat2->matrice != NULL)){
                T_matrice mat3 = initMatrice(mat1->n, mat1->m);
                for (i=0; i<mat1->n; i++){
                    if ((mat1->matrice[i])&&(mat2->matrice[i] != NULL)){
                        for (j=0; j<mat1->n; j++){
                            mat3->matrice[i][j] = mat1->matrice[i][j] + mat2->matrice[i][j];
                        }
                        return mat3;
                    }
                    else{
                        errno=EINVAL;
                        return NULL;
                    }
                }
        }
        else{
            errno = EINVAL;
            return NULL;
        }

        }

    }
    else{
        errno = EINVAL;
        return NULL;
    }
}

