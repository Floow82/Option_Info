with Ada.Text_IO,
    Ada.Float_Text_IO,
    Ada.Unchecked_Deallocation;
use Ada.Text_IO,
    Ada.Float_Text_IO;

package body Libmatrice_Ada is

    type T_Traite_Func is access procedure (Elem : T_Ptr_Val);
    procedure Traite_Matrice (Mat : in out T_Matrice; Proc : T_Traite_Func);
    procedure Get (Elem : T_Ptr_Val);
    procedure Put (Elem : T_Ptr_Val);
    procedure Free_Float is new Ada.Unchecked_Deallocation
        (Object => Float, Name => T_Ptr_Val);
    procedure Free_T_Mat is new Ada.Unchecked_Deallocation
        (Object => T_Mat, Name => T_Ptr_Mat);

    procedure Creation_Matrice (Mat : in out T_Matrice) is
    begin
        Mat.Matrice := new T_Mat (1 .. Mat.N, 1 .. Mat.M);
        allocation_cases :
        for I in Mat.Matrice'Range (1) loop
            for J in Mat.Matrice'Range (2) loop
                Mat.Matrice (I, J) := new Float'(0.0);
            end loop;
        end loop allocation_cases;
    end Creation_Matrice;

    procedure Get (Mat : in out T_Matrice) is
    begin
        Traite_Matrice (Mat => Mat, Proc => Get'Access);
    end Get;

    procedure Put (Mat : in out T_Matrice) is
    begin
        Traite_Matrice (Mat => Mat, Proc => Put'Access);
    end Put;

    procedure Free (Mat : in out T_Matrice) is
    begin
        if Mat.Matrice /= null then
            for I in Mat.Matrice'Range (1) loop
                for J in Mat.Matrice'Range (2) loop
                    if Mat.Matrice (I, J) /= null then
                        Free_Float (X => Mat.Matrice (I, J));
                    else
                        raise MATRICE_ALLOC_EXCEPTION;
                    end if;
                end loop;
            end loop;
            Free_T_Mat (X => Mat.Matrice);
        else
            raise MATRICE_ALLOC_EXCEPTION;
        end if;
    end Free;

    --  Private Implementation
    procedure Traite_Matrice (Mat : in out T_Matrice; Proc : T_Traite_Func) is
    begin
        if Mat.Matrice /= null then
            for I in Mat.Matrice'Range (1) loop
                for J in Mat.Matrice'Range (2) loop
                    if Mat.Matrice (I, J) /= null then
                        if Proc = Get'Access then
                            Put ("Val de M[" & Positive'Image (I) & "," &
                                Positive'Image (J) & "] : ");
                        end if;
                        Proc (Mat.Matrice (I, J));
                    else
                        raise MATRICE_ALLOC_EXCEPTION;
                    end if;
                end loop;
                if Proc = Put'Access then
                    New_Line (Spacing => 1);
                end if;
            end loop;
        else
            raise MATRICE_ALLOC_EXCEPTION;
        end if;
    end Traite_Matrice;

    procedure Get (Elem : T_Ptr_Val) is
    begin
        Get (Elem.all);
    end Get;
    procedure Put (Elem : T_Ptr_Val) is
    begin
        Put (Elem.all, Aft => 3, Exp => 0);
    end Put;

end Libmatrice_Ada;