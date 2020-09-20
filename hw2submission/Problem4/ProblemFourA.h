

#include<iostream>
using namespace std;

void merge(int a[], int first, int mid, int last, int arraySize){

    int first1 = first;
    int last1 = mid;
    int first2 = mid+1;
    int last2 = last;



    int index = first1;
    int temp[arraySize];

    while((first1 <= last1)&&(first2 <=last2)){

        if (a[first1] <= a[first2]){
            temp[index] = a[first1];
            first1++;
        }


        else{
            temp[index] = a[first2];
            first2++;
        }

        index++;
    }







    while(first1<=last1){
        temp[index] = a[first1];
        first1++;
        index++;
    }


    while(first2<=last2){
        temp[index] = a[first2];
        first2++;
        index++;
    }


    for (index = first; index <= last; index++) {
        a[index] = temp[index];
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

void ProblemFourA(int a[], int arraySize){

    int first = 0;
    int last = arraySize-1;
    int reversecopy[arraySize];

    merger(a,first,last, arraySize);

    for (int i =0; i<arraySize; i++){
        cout<<a[i]<<" ";
    }




    for(int i = 0; i<arraySize; i++){

        reversecopy[i] = a[i];

    }



    int i = 0;
    int j = arraySize-1;
    while(i < j){

        int temp = reversecopy[i];
        reversecopy[i] = reversecopy[j];
        reversecopy[j] = temp;
        i++;
        j--;

    }

    cout<<endl;



    int temp2;

    for(int i = 0; i<arraySize-1; i++){



        temp2 = a[i+1];
        a[i+1] = reversecopy[i];
        reversecopy[i+1] = temp2;

    }

    for (int i =0; i<arraySize; i++){
        cout<<a[i]<<" ";
    }



}

