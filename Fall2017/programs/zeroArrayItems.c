// zeroArrayItems (A, m, n) sets array items A[m] ... A[n] to zero
#include <stdio.h>
#define MAX 10
int A[MAX]={0,1,2,3,4,5,6,7,8,9};

zeroArrayItemsI (int A[], int m, int n) {
  int i;
  for (i=m; i<=n; i++) {
    A[i]=0;
  }
}
/*
zeroArrayItemsR (int A[], int m, int n) {
  if (m<=n) {
      A[m]=0;
      zeroArrayItemsR (A, m+1, n);
  }
}
*/

printArray(int A[]) {
  int i;
  for (i=0;i<MAX;i++) printf("%d,",A[i]);
}

int main (void) {
  printf("zeroArrayItemsI(A,3,6): ");
  zeroArrayItemsI(A,3,6);
  printArray(A);
  printf("\n");
  /*
  printf("zeroArrayItemsR(A,3,6): ");
  zeroArrayItemsR(A,3,6);
  printArray(A);
  printf("\n");
  */
}
