#include <iostream>
#include <iomanip>
#include <cmath>
#include <iostream>

using namespace std;

void fact (const int n, int *res);

int main(int argc, char const *argv[])
{
   int n;
   int r;
   if (argc < 2)
   {
    cout << "Paramètre(s) manquant" << endl;
    return -1;
   }

    n = atoi(argv[1]);
    fact(n,&r);
    cout << r << endl;
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