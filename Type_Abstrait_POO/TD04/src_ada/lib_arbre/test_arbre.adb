with Ada.Text_IO,
    Ada.Integer_Text_IO,
    arbre;
use Ada.Text_IO, arbre;

procedure Test_arbre is
    package Integer_Tree is new LibArbre (T_elem => Integer);
    use Integer_Tree;
    A : T_arbre;
    B : T_Arbre;
begin
    ArbreVide (A);
    A := ConsArbre (1; null; null);
    B := ConsArbre (2; null; null);
    AfficheArbre (A);
    AfficheArbre (B);
end Test_arbre;