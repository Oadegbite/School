#include <stdio.h>
#include <stdlib.h>

int large(int q) {
  //ASSUME q>0 always
  int x=q;
  int y=q;
  int i;
  int j;
  for (i=1;i<=q;i++) {
     x=q-i;
     for (j=q;j>0;j--) {
       y=y+x;
     }
  }
  return (x+y);
    }

void main()
{
  int *a;
  a = (int *) malloc(sizeof(int));
  *a = 4;
  printf("%d \n",large(*a));

}
