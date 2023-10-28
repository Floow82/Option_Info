with Ada.Text_IO, Ada.Unchecked_Deallocation;
use Ada.Text_IO;

package body Libarbre is

    procedure ArbreVide (a : out T_arbre) is
    begin
        a.taille := 0;
        a.hauteur := 0;
        a.racine := null;
    end ArbreVide;

    function ConsArbre (Elem : T_elem; sad : T_arbre; sag : T_arbre) return T_arbre is
        a : T_arbre;
        new_r : T_Node_Access;
    begin
        new_r := new T_Node;
        new_r.Data := Elem;
        new_r.Droite := sad;
        new_r.gauche := sag;
        ArbreVide(a=>a);
        a.racine := new_r;
        a.taille := sad.taille + sag.taille + 1;
        a.hauteur := Integer'Max(sad.hauteur, sag.hauteur) + 1;
        return a;
    end ConsArbre;
    function Vide (a : T_arbre) return Boolean is
    begin
        return a.taille = 0;
    end Vide;

    function Valeur (a : T_arbre) return T_elem is
    begin
        return a.racine.data;
    end Valeur;

    function Sag (a : T_arbre) return T_arbre is
    begin
        if Vide(a) then
            raise ARBRE_VIDE_EXCEPTION;
        else
            return a.racine.Gauche;
        end if;
    end Sag;

    function Sad (a : T_arbre) return T_arbre is
        begin
        if Vide(a) then
            raise ARBRE_VIDE_EXCEPTION;
        else
            return a.racine.Droite;
        end if;
    end Sag;

    function Taille (a : T_arbre) return Integer is
    begin
        return a.taille;
    end Taille;

    function Hauteur (a : T_arbre) return Integer is
    begin
        return a.hauteur;
    end Hauteur;

    procedure AfficheArbre (Tree_Node : T_arbre) is
    procedure AfficheSA (Node : T_arbre; Indent : Integer) is
    begin
        if not Vide(Node) then
            for I in 1 .. Indent loop
                Ada.Text_IO.Put("   ");
            end loop;
            Ada.Text_IO.Put_Line(Integer'Image(Valeur(Node)));
            Print_Subtree(Sag(Node), Indent + 1);
            Print_Subtree(Sad(Node), Indent + 1);
        end if;
    end AfficheSA;
    begin
    Print_Subtree(Tree_Node, 0);
    end AfficheArbre;
end Libarbre;