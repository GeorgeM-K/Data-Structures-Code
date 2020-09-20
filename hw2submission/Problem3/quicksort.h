#include <iostream>

using namespace std;

class Node {

public:

    Node *prev;
    Node *next;
    int data;

};


class LinkedList {

public:

    LinkedList(){

        head = NULL;
    };

    bool isEmpty(){

        return head == NULL;
    };

    void add(int newData){

        Node *p = head;

        head = new Node;

        head->data = newData;

        head->next = p;

    };

    void quicksort(){


        Node *iter = head;

        Node *first = head;

        Node *last = NULL;

        cout<<"quicksort"<<endl;


        while (iter != NULL && iter->next != NULL) {

            last = iter->next;

            iter = iter->next;

        }

        cout<<"endofquicksort"<<endl;

        actualSort(first, last);

    };

    void printList(){

        Node *iter = head;

        while (iter != NULL) {

            cout << iter->data << " ";

            iter = iter->next;
        }

    };

    void actualSort(Node *first, Node *last){


        Node *iter = head;

        first = head;

        last = NULL;



        //SHUFFLE
        int temp;
        while (iter != NULL && iter->next != NULL) {
            if (iter->next != NULL) {
                temp = iter->data;
                iter->data = iter->next->data;
                iter->next->data = temp;

            }

            iter = iter->next;

        }
        while (iter != NULL && iter->next != NULL) {

            last = iter->next;

            iter = iter->next;

        }





        if (first < last) {

            Node *pivot = partition(first, last);

            actualSort(first, pivot->prev);
            actualSort(pivot->next, last);

        }

    };


    Node *partition(Node *first, Node *last){
        int i = 0;
        Node* iter;
        first = head;
        last = NULL;
        int first1 = last->data;
        while (iter != NULL && iter->next != NULL) {

            last = iter->next;

            iter = iter->next;
        }



        while (iter != NULL && iter->next != NULL) {
            i++;
            iter = iter->next;
        }

        cout << "i=" << i << endl;

        int j = i/2;

        int k = 0;

        Node *pivot;

        while (k<=j && iter != NULL && iter->next != NULL) {

            pivot = iter;

            iter = iter->next;


        }


        for(Node* iter2 = first; iter2 != last; iter2 = iter2->next) {

            if (iter2->data < first1) {
                iter2 = (first1 == NULL) ? first : pivot->next;
                int temp = pivot->data;
                pivot->data = iter2->data;
                iter2->data = temp;
            }


            pivot = (pivot == NULL) ? first : pivot->next;
            int temp = pivot->data;
            pivot->data = last->data;
            last->data = temp;
            return pivot;
        }
    };

private:

    Node *head;

};






