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
    La_Deque.Init_Deque();
    Put_Line
       ("Taille deque = " & Long_Integer'Image (La_Deque.Size_Deque ()));
    La_Deque.Insert_Head(Data => 4);
    La_Deque.Put ();
    New_Line (Spacing => 1);
    La_Deque.Insert_Head (Data => 44);
    La_Deque.Put ();
    New_Line (Spacing => 1);
    La_Deque.Insert_Queue (Data => 5);
    La_Deque.Insert_Queue (Data => 55);
    La_Deque.Insert_Head (Data => 12);
    La_Deque.Put ();
    New_Line (Spacing => 1);
    Put_Line
       ("Remove head ... " & Integer'Image (La_Deque.Remove_Head ()));
    La_Deque.Put ();
    New_Line (Spacing => 1);

    --  Free (Deq => La_Deque);
end Test_Deque;