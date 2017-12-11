#include <stdio.h>
#include <stdlib.h>
#include "QueueInterface.h"

int main(void) {
    Queue Q;
    int i,removedItem, val, success=1;

    // a)
    InitializeQueue(&Q); 
    val=Empty(&Q);
    if ( ! val ) success=0;


    // b)
    /*test underflow*/
    val=Remove(&Q,&removedItem);
    if ( val )  success=0;
    val=Empty(&Q);
    if (  ! val ) success=0;


    // c)
    for (i=7;i>0;i--) {
      val=Insert(i,&Q);
      if ( ! val ) success=0;
    }


    // d)
    for (i=7;i>0;i--) {
      val=Remove(&Q,&removedItem);
      if ( ! val ) success=0;
      else {
         if ( removedItem != i) success=0;
      }
    }

    // e)
      val=Empty(&Q);
      if (  ! val ) success=0;

    if (success) printf("\n Tests Successful\n");
    else         printf("\n Some Tests Failed\n");
}

