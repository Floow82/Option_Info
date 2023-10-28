#include "lib_deque.hpp"
#include <cmath>
#include <iostream>
#include <iomanip>
#include <stdexcept>

using namespace std;

namespace libdeque
{
    struct cell
    {
        void *data;
        struct cell *prev;
        struct cell *next;
    };

    struct deque
    {
        long size;
        struct cell *head;
        struct cell *queue;
    };

    T_deque *init() noexcept(false)
    {
        T_deque dq;
        try
        {
            struct deque *dq;
            dq->size = 0;
            dq->head = NULL;
            dq->queue = NULL;
        }
        catch(const std::bad_alloc& ba)
        {
            std::cerr << ba.what() << '\n';
            throw dq;
        }
        return *dq;
    }
    /* nulptr signifie pointeur nul */
    int SizeDeque (const T_deque *dq) noexcept(false)
    {
        if (dq == nullptr)
        {
            throw std :: invalid_argument ("Matrice mal allouée");
        }
        return dq->size;
    }

    void InsertDebut (T_deque *dq, const void *el) noexcept(false)
    {
        struct cell *cell;
        if (dq == nullptr)
        {
            throw std :: invalid_argument ("Frr ton deque est vide");
        }
        cell->data = (void *)el;
        cell->prev = NULL;
        cell->next = dq->head;

        if (dq->head == NULL)
        {
            dq->queue = cell;
        }
        else
        {
            dq->head->prev= cell;
        }
        dq->head = cell;
        dq->size++;
    }

    void InsertFin (T_deque *dq, const void *el) noexcept(false)
    {
        struct cell *cell;
        if (dq == nullptr)
        {
            throw std :: invalid_argument ("Frr ton deque est vide");
        }
        cell->data = (void *)el;
        cell->prev = dq->queue;
        cell->next = NULL;
        if (dq->queue == NULL)
        {
            dq->head = cell;
        }
        else
        {
            dq->queue->next= cell;
        }
        dq->queue = cell;
        dq->size++;
    }

    void *RemoveFin (T_deque *dq) noexcept(false)
    {
        struct cell *elSuppr = NULL;
        void *data = NULL;
        if (dq == nullptr)
        {
            throw std :: invalid_argument ("Ta matrice est vide");
        }
        if (dq->size == 0)
        {
            throw std :: invalid_argument ("Ta matrice est vide, impossible de la suppr");
        }
        elSuppr = dq->queue;
        data = elSuppr->data;
        if (dq->size == 1)
        {
            dq->head = nullptr;
            dq->queue = nullptr;
        }
        else
        {
            dq->queue = elSuppr->next;
            dq->queue->next = nullptr;
        }
        free(elSuppr);
        dq->size--;
        return data;
    }

    void DeleteDeque(T_deque *dq) noexcept(false)
    {
        if (dq == nullptr)
        {
            throw std :: invalid_argument ("Ta matrice est vide");
        }
        if((dq)->queue != nullptr)
        {
            while ((dq)->queue != nullptr)
            {
                RemoveFin(dq);
            }
        }
        free(dq);
        dq = NULL;
    }
    void PrintDeque(const T_deque *dq, void (*printElem)(void *)) noexcept(false)
    {
        struct cell *iter;
        if (dq == nullptr)
        {
            throw std :: invalid_argument ("Ta matrice est vide");
        }
        cout << "Taille de la pile : " << dq->size << endl;
        if (dq->head != NULL){
        iter = dq->head;
        do {
            printElem(iter->data);
            iter = iter->next;
            if (iter != NULL)
            {
                cout<<"-";
            }
        } while (iter != NULL);
        cout << "C'est fini" << endl;
        }
    }
}