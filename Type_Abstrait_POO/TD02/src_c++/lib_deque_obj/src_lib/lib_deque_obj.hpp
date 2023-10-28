#include <ostream>
using namespace std;
namespace libdeque_obj
{
    template <typename T>
    class Deque
    {
        public:
            Deque(void);
            ~Deque(void);
            /* avec le const la methode ne sera pas impactante dnas elle va pas modifier l'attribut de l'objet*/
            long sizedeque(void) const;
        private:
            struct cell
            {
                T data;
                struct cell *prev;
                struct cell *next;
            };
            long size;
            struct cell *head;
            struct cell *queue;

    };
}
