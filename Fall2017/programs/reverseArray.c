#include <stdio.h>

void printAry (int *A, int i, int j) ;
void swap (int *A, int x, int y) ;

int revAry(int *A, int x, int y) {
  if (x < y) {
     swap (A, x, y);
     revAry(A, x+1, y-1);
  }

}

int main(void) {

  int A[]={1,2,3,4,5};
  printf("A is: \n");
  printAry(A,0,4);
  printf("\n\n");
  printf("revAry(A,0,4) is:\n"); revAry(A,0,4); printAry(A,0,4);
  printf("revAry(A,1,3) is:\n"); revAry(A,1,3); printAry(A,0,4);
  printf("revAry(A,2,2) is:\n"); revAry(A,2,2); printAry(A,0,4);

return 0;
}


void swap (int *A, int i, int j) {
   int temp=A[i];
   A[i]=A[j];
   A[j]=temp;
}


void printAry (int *A, int i, int j) {
   int point;
   for ( point = i; point<=j; point++) {
      printf("%d ", A[point] );
   }
   printf("\n");
}
