with Ada.Text_IO,
    Ada.Long_Float_Text_IO,
    Ada.Command_Line;
use Ada.Text_IO,
    Ada.Long_Float_Text_IO,
    Ada.Command_Line;

procedure Name () is
    package Int_IO is new Ada.Text_IO.Integer_IO;
    package Cmd_Line_IO is new Ada.Text_IO.Command_Line_IO;
    type T_Tab is array ( Integer Range <>) of Integer;
    type T_index is range 1 ..1000;
    n: Integer;
    m: Integer;
    i, j: Integer;
    T1 : T_Tab(1..m);
    T2 : T_Tab(1..n);

    procedure Affiche_Tab (Tab : T_Tab);
    function Interclasse (Tab_1 : T_Tab; Tab_2 : T_Tab) return T_Tab;
begin
    if not Cmd_Line_IO.Argument_Count >= 2 then
        Ada.Text_IO.Put_Line("Paramètres manquant")
        return;
    end if;
    m := Integer'Value(Cmd_Line_IO.Argument(1));
    n := Integer'Value(Cmd_Line_IO.Argument(2+m));

    for i in 1 .. m loop
        T1(i):=Cmd_Line_IO.Argument(I+2);
    end loop;
    for j in 1 .. n loop
        T2(j):=Cmd_Line_IO.Argument(I+2+m+1);
    end loop;

    Put(Item => "T1:");
    for i in T1'Range loop
        Int_IO.Put(T1(i));
    end loop;

    Ada.Text_IO.New_Line;
    Put(Item => "T2:");
    for i in 1 .. n loop
        Int_IO.Put(T2(i));
    end loop;

    Ada.Text_IO.New_Line;
    Ada.Text_IO.Put("T3 : ");
    for I in 1 .. O loop
        Int_IO.Put(T3(I));
        if I < O then
            Ada.Text_IO.Put(", ");
        else
            Ada.Text_IO.New_Line;
        end if;
    end loop;


end Name;