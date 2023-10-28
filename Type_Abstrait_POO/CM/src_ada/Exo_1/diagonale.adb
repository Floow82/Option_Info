with Ada.Text_IO,
    Ada.Long_Float_Text_IO,
    Ada.Numerics.Long_Elementary_Functions;
use Ada.Text_IO,
    Ada.Long_Float_Text_IO,
    Ada.Numerics.Long_Elementary_Functions;

procedure Diagonale is
    Cote : Long_Float;
begin
    Put (Item => "Coté = ");
    Get (Item => Cote);
    Put_Line (Item => "Diagonale = " & Long_Float'Image  (Cote * Sqrt (2.0)));
    Put (Item => "Diagonale = ");
    Put (Item => Cote * Sqrt (2.0), Aft => 3, Exp => 0);
    New_Line (Spacing => 1);
end Diagonale;