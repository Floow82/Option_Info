package Libmatrice_Ada is

    type T_Matrice (N : Positive; M : Positive)  is limited private;

    procedure Creation_Matrice (Mat : in out T_Matrice);
    procedure Get (Mat : in out T_Matrice);
    procedure Put (Mat : in out T_Matrice);
    procedure Free (Mat : in out T_Matrice);

    --  Exception(s)
    MATRICE_ALLOC_EXCEPTION : exception;
private
    type T_Ptr_Val is access Float;
    type T_Mat is array (Positive range <>, Positive range <>) of T_Ptr_Val;
    type T_Ptr_Mat is access T_Mat;
    type T_Matrice (N : Positive; M : Positive) is record
        Matrice : T_Ptr_Mat;
    end record;

end Libmatrice_Ada;