/***  Iterative solution of the Tower of Hanoi puzzle
 
      by Ingo Hattendorf (1999)                         ***/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N   29
/* #define AUSGABE */

void hanoi_ingo (void)
{ 	
 	int i,j,tmp;
	int *pos     = (int *)malloc((N+1) * sizeof(int));
	int *pos_old = (int *)malloc((N+1) * sizeof(int));
	for(i=1; i <= N; i++) 
	{ 	pos[i]=1; 
		pos_old[i] = (i&1 ?  2 : 3);
	}
	
	for(j=1; j <= (1 << N)-1; j++)
	{ 	
		if(j&1)
		{ 	
			#ifdef AUSGABE
				printf("\nMove disc %c from pole %i to ", 'A', pos[1]); 
			#endif
			tmp        = pos[1];
			pos[1]     = pos[1]^pos_old[1];
			pos_old[1] = tmp;
			#ifdef AUSGABE
				printf("%i", pos[1]); 
		     		fflush(NULL);
			#endif
		} 
		else
		{ 	i=1;
			while(!((j>>i++)&1));
			#ifdef AUSGABE
				printf("\nMove disc %c from pole %i to ", (char)(i+'A'-1), pos[i]); 
			#endif
			tmp        = pos[i];
			pos[i]     = pos[i]^pos_old[i];
			pos_old[i] = tmp;
			#ifdef AUSGABE
				printf("%i", pos[i]); 
		     		fflush(NULL);
			#endif
			}
		}
}

int  main (void)
{ 	
	clock_t t0, t1;
	t0=clock();
	hanoi_ingo(); 
	t1=clock();
	printf("\nTime: %f s\n",(t1-t0)/(float)CLOCKS_PER_SEC);
}

