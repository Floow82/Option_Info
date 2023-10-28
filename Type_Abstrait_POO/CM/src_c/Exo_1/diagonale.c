#include <math.h>
#include <stdio.h>

/* int main(int argc, char *argv[]) */
int main()
{
    double cote;
    printf("Coté = ");
    scanf("%lf", &cote);
    printf("diagonale =  %.4f\n", cote * sqrt(2));
    return 0;
}
