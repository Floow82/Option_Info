generic
    type T_elem is private;

package LibArbre is
    type T_arbre is limited private;

    procedure ArbreVide(a : out T_arbre);
    function ConsArbre( Elem : T_elem; sad : T_arbre; sag : T_arbre) return T_arbre;
    function Vide(a : T_arbre) return Boolean;
    function Valeur(a : T_arbre) return T_elem;
    function Sag (a : T_arbre) return T_arbre;
    function Sad (a : T_arbre) return T_arbre;
    function Taille(a : T_arbre) return Integer;
    function Hauteur(a : T_arbre) return Integer;
    procedure AfficheArbre (a : T_arbre);

    ARBRE_VIDE_EXCEPTION : exception;
private
    type T_Node;

    type T_Node_Access is access T_Node;

    type T_Node is limited record
        Data : T_Elem;
        Droite : T_Node_Access;
        Gauche : T_Node_Access;
    end record;

    type T_arbre is limited record
        hauteur : Integer;
        taille : Integer;
        racine : T_Node;
    end record;
end LibArbre;