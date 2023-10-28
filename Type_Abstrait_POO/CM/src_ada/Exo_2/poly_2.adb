with Ada.Text_IO,
    Ada.Long_Float_Text_IO,
    Ada.Numerics.Long_Elementary_Functions;
use Ada.Text_IO,
    Ada.Long_Float_Text_IO,
    Ada.Numerics.Long_Elementary_Functions;

procedure poly_2 is
    a : Long_Float;
    b : Long_Float;
    c : Long_Float;
    determinant : Long_Float;
begin
    Put_Line (" Donne moi trois entiers stp ");
    Get (Item => a);
    Get (Item => b);
    Get (Item => c);
    determinant := b * b - 4.0 * a * c;
    if determinant < 0.0 then
        Put_Line ("Il n'y a pas de racine");
    elsif determinant = 0.0 then
        Put_Line ("Il y a une racine :");
        Put (Item => -b / (2.0 * a));
    else
        Put_Line ("Il y a deux racine");
        Put (Item => (-b - Sqrt (determinant)) / (2.0 * a));
        Put (Item => (-b + Sqrt (determinant)) / (2.0 * a));
    end if;
end poly_2;