#include <stdio.h>
#include <stdlib.h>

int main (void) {

 int *X,*Y;
 
 X=(int *)malloc(sizeof(int));
 Y=(int *)malloc(sizeof(int));
 *X=5;
 *Y=3;
 printf("*X and *Y are : %d %d\n",*X,*Y);
 free(X);
 printf("*X and *Y are : %d %d\n",*X,*Y);

 return(0);
}
