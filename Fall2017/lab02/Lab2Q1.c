#include <stdio.h>
#include <string.h>

void revS(char *S, int a, int b) {
  int i,j;
  i=a;
  j=b;
  char temp;
  while (i<j) {
     temp=S[i];
     S[i]=S[j];
     S[j]=temp;
     i++;
     j--;
  }
}

void main() {
  char a[] = "hello world";

  revS(a, 0,strlen(a)-1);

  printf("%s\n", a);

}
