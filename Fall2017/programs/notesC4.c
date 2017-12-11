#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (void) {

typedef char AirportCode[4];

typedef struct NodeTag {
  AirportCode Airport;
  struct NodeTag *Link;
} Node;

AirportCode Calgary; 
Node *L, *temp;

strcpy(Calgary,"YYC");
printf("Calgary's airport code is: %s \n", Calgary); 

L=(Node *)malloc(sizeof(Node));
strcpy(L->Airport, "YYZ");
L->Link=NULL;

printf("L->Airport[3] is: %c\n",L->Airport[3]);
printf("L->Airport[2] is: %c\n",L->Airport[2]);

}

