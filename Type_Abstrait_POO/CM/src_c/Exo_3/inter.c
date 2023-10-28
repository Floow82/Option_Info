#include <stdio.h>
#include <stdlib.h>
#include "math.h"

void affichetableau(int T[], const int m);
void interclassement( int T1[], const int m, int T2[], const int n, int T3[]);

int main(int argc, char const *argv[])
{
    int T1[10];
    int T2[10];
    int T3[20];
    int m,n,i;

    if (argc < 2)
    {
        printf("Paramètre(s) manquant");
        return -1;
    }

    m = atoi(argv[1]);
    n = atoi(argv[2 + m ]);

    for (i=0; i<m; i++)
    {
        T1[i]=atoi(argv[2+i]);
    }
    for (i=0; i<n; i++)
    {
        T2[i]=atoi(argv[2+i+m+1]);
    }
    printf("T1:");
    affichetableau(T1, m);
    printf("T2:");
    affichetableau(T2, n);
    interclassement(T1,m, T2,n, T3);
    affichetableau(T3, n+m);
    return 0;
}


void affichetableau(int T[], const int m)
{
    int i;
    for (i = 0; i < m - 1; i++)
    {
        printf("%d\t", T[i]);
    }
    printf("%d\n", T[m - 1]);
}


void interclassement( int T1[], const int m, int T2[], const int n, int T3[])
{
    int i=0;
    int j=0;
    while (i<m && j<n)
    {
        if(T1[i]<T2[j])
        {
            T3[i+j]=T1[i];
            i++;
        }
        else
        {
            T3[i+j]=T2[j];
            j++;
        }
    }
    if (i==m)
    {
        for(;j<n;j++)
        {
            T3[i+j] = T2[j];
        }
    }
    else
    {
       for(;i<m;i++)
        {
            T3[i+j] = T1[i];
        }
    }
}