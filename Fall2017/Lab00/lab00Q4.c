#include <stdio.h>
#include <stdlib.h>

typedef int *IntegerPointer;

IntegerPointer A, B;

void AllocFailTest(void){

  typedef int BigArray[1000];
  BigArray *A;

  while( (A = (BigArray *)malloc(sizeof(BigArray))) != NULL);

  printf("storage allocation faliure\n" );

}

void main(void){

AllocFailTest();

}
