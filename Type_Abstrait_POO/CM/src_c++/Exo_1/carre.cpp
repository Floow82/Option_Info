#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    int x;
    cout << "x = ";
    cin >> x;
    cout << "x^2 = " << setw(5) << x * x << endl;
    cout << "[Base 16] x^2 = " << setbase(16)
        << setw(5) << x * x << endl;
    return 0;
}