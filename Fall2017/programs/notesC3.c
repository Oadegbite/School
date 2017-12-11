#include <stdio.h>
#include <stdlib.h>

int main (void) {

int *y;
y=(int *)malloc(sizeof(int));
/* this is OK too:
y=malloc(sizeof(int));
*/
*y=5;
printf("%d \n", *y);
free(y);
printf("%d \n", *y); //MIGHT still work. If so, why?
}

