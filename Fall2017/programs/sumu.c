#include <stdio.h>
//a going-up recursion

int sumu(int A[], int x, int y) {
  if (x < y) return A[x] + sumu(A,x+1,y);
  else if (x == y) return A[x];
  else return 0;
}

int main(void) {

  int i, A[]={2,4,1};
  printf("A is: ");
  for (i=0;i<3;i++) printf("%d, ",A[i]);
  printf("\n");
  printf("SumU(A,0,2) is: %d\n", sumu(A,0,2));
  printf("SumU(A,1,1) is: %d\n", sumu(A,1,1));

return 0;
}

