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

int main (void) {
  
char S[]="abcdefg";

printf("S starts as: %s\n", S);
revS(S,0,strlen(S)-1);
printf("S reversed : %s\n", S);

}

