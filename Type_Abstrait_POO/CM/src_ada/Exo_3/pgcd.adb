with Ada.Text_IO,
    Ada.Integer_Text_IO;
use Ada.Text_IO,
    Ada.Integer_Text_IO;

procedure Pgcd is
    function Pgcd_Calc (Val_1 : Integer; Val_2 : Integer)
        return Integer;

    function Pgcd_Calc (Val_1 : Integer; Val_2 : Integer)
        return Integer is
    begin
        if Val_1 = Val_2 then
            return Val_1;
        elsif Val_1 > Val_2 then
            return Pgcd_Calc (Val_1 => Val_2, Val_2 => Val_1 - Val_2);
        else
            return Pgcd_Calc (Val_1 => Val_1, Val_2 => Val_2 - Val_1);
        end if;
    end Pgcd_Calc;
    --  =====

    A, B : Integer;
begin
    Put (Item => "Donner a puis b : ");
    Get (Item => A);
    Get (Item => B);
    Put (Item => "PGCD(a,b) = ");
    Put (Item => Pgcd_Calc (Val_1 => A, Val_2 => B), Width => 1);
    New_Line (Spacing => 1);
end Pgcd;