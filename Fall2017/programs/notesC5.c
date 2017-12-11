#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (void) {

typedef char AirportCode[4];

typedef struct NodeTag {
  AirportCode Airport;
  struct NodeTag *Link;
} Node;

Node *L, *temp;


L=(Node *)malloc(sizeof(Node));
strcpy(L->Airport, "YYZ");
L->Link=NULL;

temp=(Node *)malloc(sizeof(Node));
strcpy(temp->Airport, "PAR");
L->Link = temp;

temp=(Node *)malloc(sizeof(Node));
strcpy(temp->Airport, "ZRH");
L->Link->Link = temp;
temp->Link = NULL;

//now try printing:
printf("L->Airport: %s\n", L->Airport);
printf("L->Link->Airport: %s\n", L->Link->Airport);
printf("L->Link->Link->Airport: %s\n", L->Link->Link->Airport);
printf("L->Link->Link->Link: %p\n", L->Link->Link->Link);

}

