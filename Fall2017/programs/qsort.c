#include <stdio.h>

void Partition (int A[], int *i, int *j) {

  int pivot, temp, pivpos;
  pivpos=(*i+*j)/2 ;
  pivot = A[ pivpos ];  //middle key
  do {
   while ( A[*i] < pivot ) (*i)++;
   while ( A[*j] > pivot ) (*j)--;
    if (*i <= *j ) {
      temp = A[*i]; A[*i]=A[*j]; A[*j]=temp; //swap i, j
      (*i)++; (*j)-- ;
    }
  } while (*i <= *j);
}

void QuickSort (int A[], int m, int n) {

  int i,j;
  if (m<n) {
    i=m; j=n;
    Partition (A, &i, &j);
    QuickSort(A,m,j);
    QuickSort(A,i,n);
  }
}

int main (int argc, char *argv[]) {
  
  int A[100], i;
  for (i=0;i<argc-1;i++) A[i]=atoi(argv[i+1]);
  printf("Original:");
  for (i=0;i<argc-1;i++) printf("%6d,",A[i]);
  printf("\nSorted:  ");
  QuickSort (A, 0, argc-2);
  for (i=0;i<argc-1;i++) printf("%6d,",A[i]);
  printf("\n");
return 0;
}


