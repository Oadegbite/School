#include <stdio.h>
//division-in-halves recursion

//sum(a,b) does sum a+(a+1)+(a+2)+...+b 
//assumes a<=b

int sum(int a, int b) {
 printf("called with %d %d\n",a,b);
   int mid=(a+b)/2;
   if (a>=b) return a;
   return (sum(a,mid) + sum(mid+1,b));

}


int main (void) {
/*
  printf("sum(3,5) is %d\n",sum(3,5));
  printf("sum(4,7) is %d\n",sum(4,7));
*/
  printf("sum(1,8) is %d\n",sum(1,8));
}
