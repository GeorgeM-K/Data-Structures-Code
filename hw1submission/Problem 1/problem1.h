#include <iostream>



using namespace std;


template<class Object>


class Node {


public:

    Object data;
    Node<Object> *next;
    Node<Object> *prev;
};


template<class Object>
class ArbitraryQueue
{


public:

    ArbitraryQueue();

    void push(Object newData);

    Object pop();

    void enqueue(Object newData);

    Object dequeue();

    Object traverse(int index);

    bool isEmpty();

private:

    Node<Object> *head;

    Node<Object> *tail;


};


template <class Object>
ArbitraryQueue<Object>::ArbitraryQueue(){

    head =NULL;
    tail = NULL;

}



template<class Object>
bool ArbitraryQueue<Object>::isEmpty() {

    return(head == NULL);

}



template<class Object>

void ArbitraryQueue <Object> :: push(Object newData) {

    Node<Object> *p;

    p = head; //assigns data to the head of the list

    head = new Node<Object>;

    head -> data = newData;

    head -> next = p;

}


template<class Object>

Object ArbitraryQueue <Object> :: pop(){

    try {
        if(head == NULL)
            throw("You have accessed a Null Pointer, there are no objects in the data structure at present.")
        else

            Node<Object> *p;

        Object popped = head->data;

        head = NULL;

        head = head->next;


        return popped;


    }
    catch(int e){
        cout<<"Big Mistake"<<e<<endl;
    }

}



template<class Object>

void ArbitraryQueue <Object> :: enqueue(Object newData){

    Node<Object> *p;

    tail = head;

    tail = tail ->next;

    tail -> data = newData;

    tail -> next = NULL;

}


template<class Object>

Object ArbitraryQueue <Object> :: dequeue() {

    Node<Object> *prev;
    try {
        if (isEmpty()) {
            throw ("You have accessed a Null Pointer, there are no objects in the data structure at present.");
        } else if (head->== NULL) {
            return head -> data;
            head = NULL;
            tail = NULL;

        } else

            tail = head;

        Object dequeued = tail->data;

        prev -> next = NULL;

        tail = prev;


        return dequeued;

    }
    catch(int e){
        cout << "Big Mistake" << e << endl;
        return 0;
    }

}


template<class Object>

Object ArbitraryQueue<Object>:: traverse(int index){


    Object newData;

    for(int i=0; i<index;i++){

        head -> data;
        head = head -> next;
        head -> data = newData;

        if(head == tail)

            break;

        return newData;



    }

};



