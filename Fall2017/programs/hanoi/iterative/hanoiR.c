//Here is the recursive algorithm for comparison:


#include <stdio.h>
#include <time.h>
/* #define AUSGABE */

#define N   29
#define N1  1
#define N2  2
#define N3  3

void  hanoi_rec (int n, int current, int destination, int buffer)
{
	if(n!=0)
	{
		hanoi_rec(n-1, current, buffer, destination);
		#ifdef AUSGABE
			printf( "move disk %c from %i to %i\n", (char)(n+'A'-1), current, destination);
		     	fflush(NULL);
		#endif
		hanoi_rec(n-1, buffer, destination, current);
	}	
}

int main (void)
{ 	
	clock_t t0, t1;
	t0=clock();
	hanoi_rec(N, N1, N3, N2);
	t1=clock();
	printf("Time: %f s\n",(t1-t0)/(float)CLOCKS_PER_SEC);
}



