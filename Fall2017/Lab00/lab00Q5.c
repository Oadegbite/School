#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main(){

typedef char AirportCode[4];

typedef struct NodeTag{
  AirportCode Airport;
  struct NodeTag *Link;
} Node;

Node *N,*L,*temp,*F;

  N = (Node*)malloc(sizeof(Node));

  strcpy(N->Airport,"YYZ");

  L = (Node*)malloc(sizeof(Node));

  strcpy(L->Airport, "ORD");

  temp = (Node*)malloc(sizeof(Node));

  L->Link = temp;

  strcpy(temp->Airport, "MIA");

  temp->Link = (Node*)malloc(sizeof(Node));

  temp = temp->Link;


  strcpy(temp->Airport,"MEX");

  N->Link = L->Link->Link;

  L->Link->Link = N;

  F = L;
  while (F != NULL)
  {
      printf("%s\n",F->Airport);
      F = F->Link;
  }

}
