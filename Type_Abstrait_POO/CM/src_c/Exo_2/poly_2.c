#include <math.h>
#include <stdio.h>

int main()
{
    int a, b, c;
    int determinant;
    printf("Donne moi trois entiers : \n");
    scanf("%d%d%d", &a, &b, &c);
    determinant = b*b - 4*a*c;
    if (determinant < 0)
    {
        printf("Il n'y a aucune racine réelle");
    }
    else if (determinant == 0)
    {
        printf("Il y a une seule racine \n");
        printf("%d", -b/(2*a));
    }
    else
    {
        printf("Il y a deux racines: \n");
        printf(" R1 :%f, \n R2 :%f \n", (-b+sqrt(determinant))/(2*a), (-b-sqrt(determinant))/(2*a));
    }
    return 0;
}