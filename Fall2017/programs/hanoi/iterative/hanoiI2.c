/***  Shortest and possibly fastest Hanoi Tower algorithm        

      Found and then improved by Glenn C. Rhoads;
      then some more by M. Kolar (2000)                    ***/


#include <stdio.h>
#include <time.h>

#define N   29
/* #define AUSGABE */

void hanoi(void)
{
	int x, fr, to;
	unsigned int i, j;

	for (x=1; x < (1 << N); x++) 
	{
		i=(x|x-1)+1; to=(i+i/3)&3;
		i=x&x-1; fr=(i+i/3)&3;
		/* fr=(x&x-1)%3; to=((x|x-1)+1)%3; */
		for(i=x, j=1; ; i>>=1, j++) { if(i&1) break; }
		#ifdef AUSGABE
			printf( "move disk %i from %i to %i\n", j, fr, to );
		     	fflush(NULL);
		#endif
	}	
}

int main (void)
{ 	
	clock_t t0, t1;
	t0=clock();
	hanoi();  
	t1=clock();
	printf("Time: %f s\n",(t1-t0)/(float)CLOCKS_PER_SEC);
}

