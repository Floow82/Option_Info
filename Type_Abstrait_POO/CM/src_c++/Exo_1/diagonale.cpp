#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main()
{
    double cote;
    cout << "Coté = ";
    cin >> cote;
    cout << "diagonale = " << cote * sqrt(2) << endl;
    cout << "diagonale = " << setprecision(20) 
        << cote * sqrt(2) << endl;
}