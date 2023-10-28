#include <stdio.h>
#include <stdlib.h>
#include "math.h"

void fact (const int n, int *res);

int main(int argc, char const *argv[])
{
   int n;
   int r;
   if (argc < 2)
   {
    printf("Paramètre(s) manquant");
    return -1;
   }

    n = atoi(argv[1]);
    fact(n,&r);
    printf("n! = %d\n", r);
    return 0;
}


void fact(const int n, int *res)
{
    int i;
    *res = 1;
    for (i=1; i<n+1; i++)
    {
        *res = *res *i;
    }
}