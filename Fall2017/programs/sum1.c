#include <stdio.h>
//a down-by-one recursion (also a going-up recursion)

int sum(int a, int b) {
  printf("called with %d %d\n",a,b);
   if (a>=b) return a;
   return (a + sum(a+1,b));

}


int main (void) {
  //printf("sum(3,5) is %d\n",sum(3,5));
  printf("sum(1,8) is %d\n",sum(1,8));
}
