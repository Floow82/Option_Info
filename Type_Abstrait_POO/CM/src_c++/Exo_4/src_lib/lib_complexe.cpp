#include "lib_complexe.hpp"
#include <cmath>
#include <iostream>

char ch[500];

T_complexe init_complexe_cart(const double re, const double img) {
  T_complexe c;
  c.repres = cartesien;
  c.reel = re;
  c.img = img;
  c.mod = std::sqrt(re * re + img * img);
  c.arg = std::atan2(img / re);
  return c;
}

T_complexe init_complexe_pol(const double r, const double Th) {
    T_complexe c;
    c.repres = polaire;
    c.mod = r;
    c.arg = Th;
    c.reel = r * std::cos(Th);  // Conversion en forme cartésienne
    c.img = r * std::sin(Th);   // Conversion en forme cartésienne
    return c;
}

//Surcharger l'operateur
ostream & operator<< (ostream & os, const T_complexe & c)
{
    if (c.repres == (t_rep_comp) cartesien){
        cout<< "Imaginaire :" << c.reel << "+" << c.img << "i \n":
    else {
        cout << "Imaginaire:" << c.mod << "e" << c.arg << "i" <<end;
    }
    }
}