with Ada.Text_IO, Ada.Long_Float_Text_IO;
use Ada.Text_IO, Ada.Long_Float_Text_IO;

package Lib_complexe is
    type T_Complexe is record
        re: Long_Float := 0.0;
        im : Long_Float :=0.0;
        mod : Long_float := 0.0;
        arg : Long_float := 0.0;
    end record;

function Init_complexe_cart(r: in Long_Float; i: in Long_Float) return T_complexe;
function Init_complexe_pol(r: in Long_Float; th: in Long_Float) return T_complexe
procedure Put_Line(c1 : T_complexe);
function "+" (c1: T_complexe; c2: T_complexe) return T_complexe;
function "+" (re: Long_Float; c1: T_complexe) return T_complexe;
function "+" (c1: T_complexe; re: Long_Float) return T_complexe;
function "*" (c1: T_complexe; c2: T_complexe) return T_complexe;
end Lib_complexe;

