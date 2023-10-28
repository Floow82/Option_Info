with Ada.Text_IO,
    Ada.Integer_Text_IO,
    Libdeque;
use Ada.Text_IO;

procedure Test_Deque is
    procedure Simple_Put (X : Integer);
    procedure Simple_Put (X : Integer) is
    begin
        Ada.Integer_Text_IO.Put (Item => X, Width => 1);
    end Simple_Put;
    package Deque_Int is new Libdeque
       (T_Elem => Integer, Print_Elem => Simple_Put);
    use Deque_Int;

    La_Deque : T_Deque;
begin
    Init_Deque (Deq => La_Deque);
    Put_Line
       ("Taille deque = " & Long_Integer'Image (Size_Deque (Deq => La_Deque)));
    Insert_Head (Deq => La_Deque, Data => 4);
    Put (Deq => La_Deque);
    New_Line (Spacing => 1);
    Insert_Head (Deq => La_Deque, Data => 44);
    Put (Deq => La_Deque);
    New_Line (Spacing => 1);
    Insert_Queue (Deq => La_Deque, Data => 5);
    Insert_Queue (Deq => La_Deque, Data => 55);
    Insert_Head (Deq => La_Deque, Data => 12);
    Put (Deq => La_Deque);
    New_Line (Spacing => 1);
    Put_Line
       ("Remove head ... " & Integer'Image (Remove_Head (Deq => La_Deque)));
    Put (Deq => La_Deque);
    New_Line (Spacing => 1);

    --  Free (Deq => La_Deque);
end Test_Deque;