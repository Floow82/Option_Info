with Ada.Text_IO;
with Ada.Command_Line;
use Ada.Text_IO;

procedure fact is
    function calc_fact (N : Integer) return Integer is
        begin
            if N > 1 then
                return N * calc_fact (N - 1);
            else
                return 1;
            end if;
        end calc_fact;

    package CLI renames Ada.Command_Line;
    n : Integer;
    r : Integer;
begin
    if CLI.Argument_Count /= 1 then
        Put_Line ("C'est non désooo");
    else
        n := Integer'Value (CLI.Argument (1));
        r := calc_fact (n);
        Put_Line ("Résultat : " & Integer'Image (r));
    end if;
end fact;