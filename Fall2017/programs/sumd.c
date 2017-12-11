#include <stdio.h>
//a going-down recursion

int sumd(int *A, int x, int y) {
  if (x < y) return A[y] + sumd(A,x,y-1);
  else if (x == y) return A[x];
  else return 0;
}

int main(void) {

  int i, A[]={2,4,1};
  printf("A is: ");
  for (i=0;i<3;i++) printf("%d, ",A[i]);
  printf("\n");
  printf("SumU(A,0,2) is: %d\n", sumd(A,0,2));
  printf("SumU(A,1,1) is: %d\n", sumd(A,1,1));

return 0;
}

