with Ada.Text_IO, Ada.Integer_Text_IO;
use Ada.Text_IO, Ada.Integer_Text_IO;

procedure Carre is
    X : Integer;
begin
    Put (Item => "x = ");
    Get (Item => X);
    Put_Line (Item => "x^2 = " & Integer'Image (X * X));
    Put (Item => "[Base 16] x^2 =");
    Put (Item => X * X, Base => 16);
    New_Line (1);
end Carre;