with Ada.Text_IO, Ada.Long_Float_Text_IO;
use Ada.Text_IO, Ada.Long_Float_Text_IO;
with lib_complexe.ads

package body Lib_complexe is
    function Init_complexe_cart(r: in Long_Float; i: in Long_Float) return T_complexe is
        c : T_complexe;
    begin
        c.re := r;
        c.im :=i;
        c.mod := Sqrt(a*a + b*b);
        c.arg := atan(i/r);
        return c;
    end Init_complexe;

    function Init_complexe_pol(r: in Long_Float; th: in Long_Float) return T_complexe is
        c : T_complexe;
    begin
        c.mod := r;
        c.th := th;
        c.re := r*cos(th);
        c.im := r*sin(th);
        return c;
    end Init_complexe;

    procedure Put_Line(c : T_complexe) is
    begin
        put(c);
        New_Line;
    end Put_Line ;

    function "+" (c1: T_complexe; c2: T_complexe) return T_complexe is
    begin
        return Init_complexe_cart(c1.R1 + c2.R1; c1.R2 + c2.R2);
    end;

    function "+" (c1: T_complexe; re: Long_Float) return T_complexe is
    begin
        return Init_complexe_cart(c1.re + re; c1.im + c2.im);
    end;

    function "*" (c1: T_complexe; c2: T_complexe) return T_complexe is
    begin
        return Init_complexe_pol(c1.mod * c2.mod; c1.arg + c2.arg);
    end;



end Lib_complexe;