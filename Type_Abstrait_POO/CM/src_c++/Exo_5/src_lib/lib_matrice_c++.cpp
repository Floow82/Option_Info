#include "lib_matrice_c++.hpp"
#include <cmath>
#include <iostream>
#include <iomanip>
#include <stdexcept>

using namespace std;

namespace libmatrice
{
    struct matrice
    {
        int n;
        int m;
        float **matrice;
    };

    T_matrice creationMatrice(const int n, const int m) noexcept(false)
    {
        T_matrice mat;
        mat = new (nothrow) struct matrice;
        if (mat == 0)
        {
            cerr << "Problème allocation mémoire... retourne NULL";
            return NULL;
        }
        try
        {
            mat->n = n;
            mat->m = m;
            mat->matrice = new float *;
            for (int i = 0; i < n; i++)
            {
                mat->matrice[i] = new float;
            }
        }
        catch (bad_alloc const &ba)
        {
            cerr << "Problème allocation matrice..." << ba.what() << endl;
            throw mat;
        }
        return mat;
    }

    void scanElement(float &val)
    {
        cin >> val;
    }
    void printElement(float &val)
    {
        cout << setw(6) << setprecision(2) << val;
    }

    void traiteMatrice(T_matrice mat, void (&traite)(float &)) noexcept(false)
    {
        int i, j;

        if (mat != NULL)
        {
            if ((mat->matrice) != NULL)
            {
                for (i = 0; i < mat->n; i++)
                {
                    if (mat->matrice[i] != NULL)
                    {
                        for (j = 0; j < mat->m; j++)
                        {
                            traite(mat->matrice[i][j]);
                        }
                        if (traite != scanElement)
                        {
                            cout << endl;
                        }
                    }
                    else
                    {
                        cerr << "Erreur param";
                        throw invalid_argument("Matrice mal allouée !");
                    }
                }
            }
            else
            {
                cerr << "Erreur param";
                throw invalid_argument("Matrice mal allouée !");
            }
        }
        else
        {
            cerr << "Erreur param";
            throw invalid_argument("Matrice mal allouée !");
        }
    }

    void saisieMatrice(const T_matrice mat) noexcept(false)
    {
        if (mat != NULL)
        {
            cout << "Mat[" << mat->n << "," << mat->m << endl;
        }
        else
        {
            cerr << "Erreur param";
            throw invalid_argument("Matrice mal allouée !");
        }
        traiteMatrice(mat, scanElement);
    }

    void afficheMatrice(const T_matrice mat) noexcept(false)
    {
        if (mat != NULL)
        {
            cout << "Mat[" << mat->n << "," << mat->m << endl;
        }
        else
        {
            cerr << "Erreur param";
            throw invalid_argument("Matrice mal allouée !");
        }
        traiteMatrice(mat, printElement);
        cout << "]\n";
    }

    void detruireMatrice(T_matrice &mat) noexcept(false)
    {
        int i;
        errno = 0;
        if (mat != NULL)
        {
            if (mat->matrice != NULL)
            {
                for (i = 0; i < mat->n; i++)
                {
                    delete (mat->matrice[i]);
                }
                delete (mat->matrice);
            }
            else
            {
                cerr << "Erreur param";
                throw invalid_argument("Matrice mal allouée !");
            }
            delete (mat);
            mat = NULL;
        }
        else
        {
            cerr << "Erreur param";
            throw invalid_argument("Matrice mal allouée !");
        }
    }

    T_matrice operator+(const struct matrice &m1, const struct matrice &m2)
    {
        int i, j;

        if ((m1.n == m2.n) && (m1.m == m2.m))
        {
            T_matrice m3 = creationMatrice(m1.n, m1.m);
            for (i = 0; i < m3->n; i++)
            {
                for (j = 0; j < m3->m; j++)
                {
                    m3->matrice[i][j] = m1.matrice[i][j] + m2.matrice[i][j];
                }
            }
            return m3;
        }
        errno = EINVAL;
        return NULL;
    }

    ostream & operator<<(ostream & os, const T_matrice mat) {
        os << "Mat[" << mat->n << "," << mat->m;
        cout << "Mat[" << mat->n << "," << mat->m;
        return os;
    }
}
