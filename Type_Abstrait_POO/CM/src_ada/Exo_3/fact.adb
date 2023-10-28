with Ada.Text_IO;
with Ada.Command_Line;
use Ada.Text_IO;

procedure fact is
    procedure calc_fact (N : Integer; Res : out Integer) is
        temp : Integer := 1;
    begin
        for i in 1 .. N loop
            temp := temp * i;
        end loop;
        Res := temp;
    end calc_fact;

    package CLI renames Ada.Command_Line;
    n : Integer;
    r : Integer;
begin
    if CLI.Argument_Count /= 1 then
        Put_Line ("C'est non désooo");
    else
        n := Integer'Value (CLI.Argument (1));
        calc_fact (n, r);
        Put_Line ("Résultat : " & Integer'Image (r));
    end if;
end fact;