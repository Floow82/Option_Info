#include <stdio.h>
#include "math.h"

int fact_r( const int n);

int main()
{
    int n;
    int r;
    scanf("%d", &n);
    r = fact_r(n);
    printf("n! = %d\n", r);
    return 0;
}


int fact_r(const int n)
{
    if (n > 1) {
        return n * fact_r(n - 1);
        }

    else {
        return 1;
    }
}