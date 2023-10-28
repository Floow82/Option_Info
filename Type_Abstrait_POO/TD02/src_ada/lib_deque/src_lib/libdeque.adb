with Ada.Text_IO, Ada.Unchecked_Deallocation;
use Ada.Text_IO;

package body Libdeque is

    procedure Free_Node is new Ada.Unchecked_Deallocation
       (Object => T_Node, Name => T_Node_Access);

    procedure Init_Deque (Deq : out T_Deque) is
    begin
        Deq.Size  := 0;
        Deq.Head  := null;
        Deq.Queue := null;
    end Init_Deque;

    function Size_Deque (Deq : T_Deque) return Long_Integer is
    begin
        return Deq.Size;
    end Size_Deque;

    procedure Insert_Head (Deq : in out T_Deque; Data : T_Elem) is
        New_Node : T_Node_Access;
    begin
        New_Node      := new T_Node;
        New_Node.Data := Data;
        New_Node.Prev := null;
        New_Node.Succ := Deq.Head;
        if Deq.Head = null then
            Deq.Head  := New_Node;
            Deq.Queue := New_Node;
        else
            Deq.Head.Prev := New_Node;
            Deq.Head      := New_Node;
        end if;
        Deq.Size := Deq.Size + 1;
    end Insert_Head;

    procedure Insert_Queue (Deq : in out T_Deque; Data : T_Elem) is
        New_Node : T_Node_Access;
    begin
        New_Node      := new T_Node;
        New_Node.Data := Data;
        New_Node.Prev := Deq.Queue;
        New_Node.Succ := null;
        if Deq.Queue = null then
            Deq.Queue := New_Node;
            Deq.Head  := New_Node;
        else
            Deq.Queue.Succ := New_Node;
            Deq.Queue      := New_Node;
        end if;
        Deq.Size := Deq.Size + 1;
    end Insert_Queue;

    procedure Put (Deq : T_Deque) is
        Iter : T_Node_Access;
    begin
        Put (Item => "(size = " & Long_Integer'Image (Deq.Size) & ")H->");
        if Deq.Head /= null then
            Iter := Deq.Head;
            parcours :
            loop
                Print_Elem (Elem => Iter.Data);
                Iter := Iter.Succ;
                if Iter /= null then
                    Put ("-");
                end if;
                exit parcours when Iter = null;
            end loop parcours;
        end if;
        Put (Item => "<-Q");
    end Put;

    function Remove_Head (Deq : in out T_Deque) return T_Elem is
        Rem_Node : T_Node_Access;
        Data     : T_Elem;
    begin
        if Deq.Size = 0 then
            raise DEQUE_VIDE_EXCEPTION;
        else
            Rem_Node := Deq.Head;
            Data     := Rem_Node.Data;
            Deq.Head := Rem_Node.Succ;
            if Deq.Head /= null then
                Deq.Head.Prev := null;
            else
                Deq.Queue := null;
            end if;
            Free_Node (X => Rem_Node);
            Deq.Size := Deq.Size - 1;
            return Data;
        end if;
    end Remove_Head;

end Libdeque;