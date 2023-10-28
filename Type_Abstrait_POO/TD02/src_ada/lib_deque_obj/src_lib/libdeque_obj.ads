generic
    type T_Elem is private;
    with procedure Print_Elem (Elem : T_Elem);
package Libdeque is

    type T_Deque is tagged private;

    procedure Init_Deque (Deq : out T_Deque);

    function Size_Deque (Deq : T_Deque) return Long_Integer;

    procedure Insert_Head (Deq : in out T_Deque; Data : T_Elem);

    procedure Insert_Queue (Deq : in out T_Deque; Data : T_Elem);

    function Remove_Head (Deq : in out T_Deque) return T_Elem;

    procedure Put (Deq : T_Deque);

    --  Exception(s)
    DEQUE_VIDE_EXCEPTION : exception;

private
    type T_Node;

    type T_Node_Access is access T_Node;

    type T_Node is limited record
        Data : T_Elem;
        Prev : T_Node_Access;
        Succ : T_Node_Access;
    end record;

    type T_Deque is limited record
        Size : Long_Integer;
        Head : T_Node_Access;
        Queue : T_Node_Access;
    end record;
end Libdeque;