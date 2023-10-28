with Ada.Text_IO,
    Ada.Integer_Text_IO;
use Ada.Text_IO,
    Ada.Integer_Text_IO;

procedure Reverse_Nb is
    Nb : Integer := 0;
begin
    Put (Item => "n = ");
    Get (Item => Nb);
    Nb := abs (Nb);
    inversion : loop
        Put (Item => Nb mod 10, Width => 1);
        Nb := Nb / 10;
        exit inversion when Nb = 0;
    end loop inversion;
    New_Line (Spacing => 1);
end Reverse_Nb;