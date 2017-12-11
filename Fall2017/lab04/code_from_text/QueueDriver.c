#include <stdio.h>
#include <stdlib.h>
#include "QueueInterface.h"

int main(void){

  Queue Q;
  InitializeQueue(&Q);
  (Empty(&Q) == 1) ? printf("Queue is empty \n") : printf("Queue is not empty\n");
  int i;
  Remove(&Q, &i);
  (Empty(&Q) == 1) ? printf("Queue is empty \n") : printf("Queue is not empty\n");
  for(i = 7; i > 0; i--){
   int f = Insert(i,&Q);
    (f == 1) ? printf("%d Element added \n",i) : printf("%d Element not added\n", i);
  }
  while(!Empty(&Q))
  {
    int b,e;
    e = Remove(&Q,&b);
    (e == 1) ? printf("%d Was removed \n",b) : printf("%d Element not added\n", b);
  }
  (Empty(&Q) == 1) ? printf("Queue is empty \n") : printf("Queue is not empty\n");

  return 0;
}
