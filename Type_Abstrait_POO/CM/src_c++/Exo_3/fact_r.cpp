#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int fact_r(const int n);

int main() {
    int n;
    int r;

    std::cout << "Entrez un entier positif : ";
    std::cin >> n;

    r = fact_r(n);

    std::cout << "n! = " << r << std::endl;

    return 0;
}

int fact_r(const int n) {
    if (n > 1) {
        return n * fact_r(n - 1);
    } else {
        return 1;
    }
}
