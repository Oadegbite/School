//  (to compute the sum of the squares in the range m:n, where m <= n)
//  e.g., SumSquares(2,4) computes ( 2^2 + 3^2 + 4^2 ) = 29
//  Precondition: m <= n 
//  EDGES AND CENTER

int SumSquares(int m, int n)                             /* assume m <= n */
{
   if  (m < n) {
       return SumSquares(m+1, n-1 ) + m*m + n*n;         /* the recursion */
   } else {
      return n*n;                                        /* the base case */
   }
}

