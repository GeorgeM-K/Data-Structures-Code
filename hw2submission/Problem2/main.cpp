#include<iostream>
using namespace std;

void merge(int a[], int first, int mid, int last, int arraySize) {
    int first1 = first;
    int last1 = mid;
    int first2 = mid + 1;
    int last2 = last;


    int temp;

    while ((first1 <= last1) && (first2 <= last2)) {

        if (a[first1] <= a[first2]) {

            first1++;
        } else {
            temp = a[first1];
            a[first1] = a[first2];
            a[first2] = temp;

            first2++;
        }

    }



}


void merger(int a[], int first, int last, int arraySize){
    if(first<last){
        int mid = first + (last-first)/2;

        merger(a,first,mid, arraySize);

        merger(a,mid+1,last, arraySize);


        merge(a,first,mid,last,arraySize);
    }



}


void mergeSort(int a[], int arraySize){

    int first = 0;
    int last = arraySize-1;

    merger(a,first,last, arraySize);

    for (int i =0; i<arraySize; i++){
        cout<<a[i]<<" ";
    }
}

int main() {

}