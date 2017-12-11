
#include <stdio.h>
#include <string.h>

int M1(int a) {
  //ASSUME a>0 always
  int x=a; 
  int y=a; 
  int i;
  int j;
  for (i=1;i<=a;i++) {
     x=a-i;
     for (j=a;j>0;j--) {
       y=y+x;
     }
  }
  return (x+y);
}

int main (void) {
  
  printf("M1(7)=%d\n",M1(7));
  printf("M1(1)=%d\n",M1(1));
  printf("M1(19)=%d\n",M1(19));
}

