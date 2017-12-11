#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main (void) {

 typedef char AirportCode[4];

 typedef struct NodeTag {
              AirportCode    Airport;
              struct NodeTag *Link;
          } Node;


 Node *N, *L, *tmp;
 
 //set up N
 N=(Node *)malloc(sizeof(Node));
 if (N==NULL)  {
   perror("malloc");
   exit(1);
 }
 strcpy(N->Airport,"GCM");
 N->Link=NULL;

 //print N
 printf("N is:\n");
 tmp=N;
 while (tmp) {
   printf("  %s\n",tmp->Airport);
   tmp=tmp->Link;
 }

 //set up L
 L=(Node *)malloc(sizeof(Node));
 if (L==NULL)  {
   perror("malloc");
   exit(1);
 }
 strcpy(L->Airport,"ORD");
 L->Link=NULL;

 tmp=(Node *)malloc(sizeof(Node));
 if (tmp==NULL)  {
   perror("malloc");
   exit(1);
 }
 strcpy(tmp->Airport,"MIA");
 tmp->Link=NULL;
 L->Link=tmp;

 tmp=(Node *)malloc(sizeof(Node));
 if (tmp==NULL)  {
   perror("malloc");
   exit(1);
 }
 strcpy(tmp->Airport,"MEX");
 tmp->Link=NULL;
 L->Link->Link=tmp;

 //print L
 printf("L is:\n");
 tmp=L;
 while (tmp) {
   printf("  %s\n",tmp->Airport);
   tmp=tmp->Link;
 }

 printf("Answer to question 3 page 37:\n");
 N->Link=L->Link->Link;
 L->Link->Link=N;

 //print L
 printf("L is:\n");
 tmp=L;
 while (tmp) {
   printf("  %s\n",tmp->Airport);
   tmp=tmp->Link;
 }

 return(0);
}
