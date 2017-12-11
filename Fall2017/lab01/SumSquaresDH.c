//  (to compute the sum of the squares in the range m:n, where m <= n)
//  e.g., SumSquares(2,4) computes ( 2^2 + 3^2 + 4^2 ) = 29
//  Precondition: m <= n 
//  DIVISION IN HALVES

int SumSquares(int m, int n)                             /* assume m <= n */
{
   int mid;
   if  (m < n) {
       mid = (m+n)/2;
       return SumSquares(m,mid) + SumSquares(mid+1, n ) ;
   } else {
      return n*n;                                        /* the base case */
   }
}

