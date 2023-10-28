with Ada.Text_IO,
    Ada.Integer_Text_IO;
use Ada.Text_IO,
    Ada.Integer_Text_IO;

procedure Fibo is
    N : Natural;
    Fn_2, Fn : Natural := 0;
    Fn_1 : Natural := 1;
begin
    Put (Item => "n (>=0)= ");
    Get (Item => N);
    if N /= 0 then
        Fn := 1;
        for I in 2 .. N - 1 loop
            Fn_2 := Fn_1;
            Fn_1 := Fn;
            Fn := Fn_2 + Fn_1;
        end loop;
    end if;
    Put (Item => "ui = ");
    Put (Item => Fn, Width => 1);
    New_Line (Spacing => 1);
end Fibo;