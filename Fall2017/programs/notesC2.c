#include <stdio.h>
#include <stdlib.h>

int main (void) {

typedef struct {
  int real;
  int imag;
} ComplexNumber;

ComplexNumber C;
ComplexNumber *PC;
C.real = 5;
C.imag = 7;

printf("C is: %d+%di\n",C.real,C.imag);

PC=&C;

(*PC).real = 3;
PC->imag = 4;

printf("C is: %d+%di\n",C.real,C.imag);
printf("PC points to : %d+%di\n",PC->real,PC->imag);

//Last line from C3:
printf("%d %d\n", C.real, PC->real);

}

