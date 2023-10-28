#include "libcomplexe.h"
#include <math.h>
#include <stdio.h>

char ch[500];

T_complexe init_complexe_cart(const double re, const double img) {
  T_complexe c;
  c.repres = cartesien;
  c.reel = re;
  c.img = img;
  c.mod = sqrt(re * re + img * img);
  c.arg = atan(img / re);
  return c;
}

T_complexe init_complexe_pol(const double r, const double theta) {
  T_complexe c;
  c.repres = polaire;
  c.mod = r;
  c.arg = theta;
  c.re = r*cos(theta);
  c.im = r*sin(theta);
  return c;
}

char *complexe_to_string (const T_complexe c, const T_rep_comp rep){
  if (rep == cartesien){
    sprintf(ch, "z = %.4f + i %.4f \n", c.re, c.im);
    return ch;
  }
  else{
    sprintf(ch, "z = %.4f e^(i %.4f) \n", c.mod, c.arg);
    return ch;
  }
}

T_complexe addctoc(const T_complexe c1, const T_complexe c2){
  T_complexe c3;
  c3.re = c1.re + c2.re;
  c3.im = c1.im + c2.im;
  return c3;
}

T_complexe addctore (const T_complexe c1, const double re){
  return init_complexe_cart(c1.re + re, c1.im);
}

T_complexe addretoc (const double re, const T_complexe c){
  return init_complexe_cart(re + c1.re, c1.im);
}

T_complexe multctoc (const T_complexe c1, const T_complexe c2){
  return init_complexe_pol(c1.mod * c2.mod, c1.arg + c2.arg);
}

