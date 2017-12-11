#include <stdio.h>
#include <stdlib.h>

typedef int *IntegerPointer;
IntegerPointer A, B;

void P(void) {
  A = (IntegerPointer)malloc(sizeof(int));
  B = (IntegerPointer)malloc(sizeof(int));
  *A = 19;
  *B = 5;
  *A = *B;
  *B = 7;
  printf("%d\n", *A);
}

int main (void) {

P();

}
