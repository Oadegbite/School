#include <stdio.h>
#include <stdlib.h>
#include "compare.h"
#include "BST.h"

void Visit(TreeEntry x){
   printf(" %4d ",x.key);
}

void Error(char *s)
{
   fprintf(stderr, "ERROR: %s\n", s);
   exit(1);
}

TreeNode *MakeNode(KeyType x){
  TreeNode *T;
  T=(TreeNode *)malloc(sizeof(TreeNode));
  if (T==NULL) return NULL;
  T->entry.key=x;
  return T;
  }

int main(int argc, char *argv[] ) {
 TreeNode *T;
 TreeNode *newnode;
 int i; 
 int x; 
 KeyType A[]={10,5,15,1,6,25,12,7,13};
 CreateTree(&T);
 /*
 //allows user to enter keys on command line as in: a.out 10 5 15 1
 for (i=1;i<argc;i++) {
    if (!(newnode=MakeNode(atoi(argv[i])))) Error("out of memory");
    T=Insert(T,newnode); 
 }
 */

 for (i=0;i<9;i++) {
    if (!(newnode=MakeNode(A[i]))) Error("out of memory");
    T=Insert(T,newnode); 
 }
 printf("Preorder:  ");
 Preorder(T,Visit);
 printf("\n");
 printf("Inorder:   ");
 Inorder(T,Visit);
 printf("\n");
 printf("Postorder: ");
 Postorder(T,Visit);
 printf("\n");


 exit(0);
}
