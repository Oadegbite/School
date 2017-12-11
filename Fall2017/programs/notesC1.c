#include <stdio.h>
#include <stdlib.h>

int main (void) {

int x, *px, **ppx;
x=5;
px=&x;
ppx=&px;

printf("*px: %d \n", *px);
printf("&x: %p \n", &x);
printf("px: %p \n", px);
printf("&px: %p \n", &px);
printf("ppx: %p \n", ppx);

}

