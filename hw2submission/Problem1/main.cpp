#include <iostream>
using namespace std;

int findMax(int a[], int arraySize){

    int max = a[arraySize-1];

    for (int i = arraySize-2; i>=0; i--){

        if(a[i] > max){
            max = a[i];
        }
    }

    return max;

}


int findCount(int a[], int arraySize){

    int count = 0;

    int max2 = findMax(a , arraySize);





    for(int i = 0; max2>= 1; i++){

        max2 /= 10;

        count = i+1;


    }


    return count;

}

void Print(int a[], int arraySize){
    for(int i = 0; i<arraySize; i++){
        cout<<a[i]<<" ";
    }
}

void digitSort(int a[], int arraySize, int x){

    int digitcopy[10] = {0};

    int sorted[arraySize];

    for (int i = 0; i<arraySize; i++){

        digitcopy[(a[i]/x)%10]++;
    }

    for (int i = 1; i<10; i++){
        digitcopy[i] += digitcopy[i-1];
    }
    for(int i = arraySize-1; i>= 0; i--){
        sorted[digitcopy[(a[i]/x)%10] -1] = a[i];
        digitcopy[(a[i]/x)%10]--;
    }
    for(int i =0; i<arraySize; i++){
        a[i] = sorted[i];
    }
}

void Problem1Sort(int a[], int arraySize){

    int numReps = findCount(a, arraySize);

    int i = 0;

    for(int x =1; i<= numReps; x*=10){

        digitSort(a,arraySize,x);


        i++;


    }


}

int main() {

    return 0;
}