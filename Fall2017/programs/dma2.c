#include <stdio.h>
#include <stdlib.h>

int main (void) {

 int Num, i, *A;
 
 //read Num. Then Num integers into A
 printf("enter Num, then Num integers: ");
 scanf("%d",&Num);
 A=(int *)malloc(Num*sizeof(int));
 if (A==NULL) {
     printf("No memory available...Terminating\n");
     return(1);
 } else {
   for (i=0;i<Num;i++) scanf("%d",&A[i]);
   //for (i=0;i<Num;i++) scanf("%d",A+i);

   //print A
   printf("A is:\n");
   for (i=0;i<Num;i++) printf("%d ",A[i]);
   //for (i=0;i<Num;i++) printf("%d ",*A+i);
 }

 return(0);
}
