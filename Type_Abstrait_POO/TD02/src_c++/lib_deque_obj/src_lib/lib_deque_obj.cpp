#include "lib_deque_obj.hpp"
#include <iostream>
namespace libdeque_obj
{
    template < typename T>
    Deque <T> :: Deque(void)
    {
        size = 0;
        head = nullptr;
        queue = nullptr;
        std :: cout << "fin du constrcuteur" << std :: endl;
    }
    template < typename T>
    long Deque <T> :: sizedeque(void) const
    {
        return size;
    }
    template < typename T>
    Deque <T> :: ~Deque(void)
    {
        std :: cout << "Tchaaooooo" << std:: endl;
    }
}