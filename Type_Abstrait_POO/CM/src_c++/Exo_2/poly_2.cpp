#include <iostream>
#include <iomanip>
#include <cmath>
#include <iostream>

using namespace std;

int main()
{
    int a, b, c;
    int determinant;
    cout << "Donne moi trois entiers :" << endl;
    cin >> a >> b >> c;
    determinant = b*b - 4.0*a*c;
    if (determinant < 0)
    {
        cout << "Il n'y a aucune racine réelle" << endl;
    }
    else if (determinant == 0)
    {
        cout << "Il y a une seule racine" << endl;
        cout << -b/(2.0*a) << endl;
    }
    else
    {
        cout << "Il y a deux racines: " << endl;
        cout << "R1 :" << (-b+sqrt(determinant))/(2.0*a)<<endl;
        cout << "R2:" <<(-b-sqrt(determinant))/(2.0*a) << endl;
    }
    return 0;
}