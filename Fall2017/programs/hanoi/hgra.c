#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int height,flag;
struct pole {
      int maxheight;
      int *blocksize;
} stick[4];

void EatLine(void) {
  int i;
    while ((i=getchar())!='\n');
}
void displaysticks(void) {
  int i,j,c,l,width=height+2;
  system("clear");
  printf("Towers of Hannoi with %d blocks.",height);
  if (flag==2) printf(" Hit enter for next step...");
  printf("\n\n");
  for (j=height;j>=1;j--) {
    for (i=1;i<4;i++) {
      if (j <= stick[i].maxheight) {
         for (l=1;l<=stick[i].blocksize[j];l++) 
            printf("%1s","-");
         for (;l<=width;l++) printf("%1s"," ");
         }
      else {printf("%1s","|");for (l=2;l<=width;l++) printf("%1s"," ");}
    }
    printf("\n");
  }
 if (flag==2) EatLine();
 else system("sleep 1");
}

void moveblock(int from,int to) {
/*  printf("from %4d to %4d\n",from,to); */
  stick[from].maxheight--;stick[to].maxheight++;
  stick[to].blocksize[stick[to].maxheight]=stick[from].blocksize[stick[from].maxheight+1];
  stick[from].blocksize[stick[from].maxheight+1]=0;
  /*displaysticks();*/
}

void move(int num,int from,int to,int tmp) {
  if (num <= 0) return;
  move(num-1,from,tmp,to);
  moveblock(from,to);
  displaysticks();
  move(num-1,tmp,to,from);
}

int main(int argc, char *argv[]) {
  int size,k,i,j;
  /*check for valid input*/
  if ((argc != 2 && argc !=3) || (argc==3 && strcmp(argv[2],"a")!=0)) {
     fprintf(stderr,"Usage: %s <height (integer)> [a]\n",argv[0]);
     exit(1);
  }
  flag=argc;
  for (i=0;i<strlen(argv[1]);i++) 
   if (!isdigit(argv[1][i])) {
     fprintf(stderr,"Usage: %s <height (integer)> [a]\n",argv[0]);
     exit(1);
      }
  height=atoi(argv[1]);
  /*allocate memory for stick array and initialize to 0*/
  for (i=1;i<=3;i++) {
    if ((stick[i].blocksize=(int *)malloc(sizeof(int)*(height+1)))==NULL) {
       fprintf(stderr,"Not enough memory\n"); exit(2);
    }
    for (j=1;j<=height;j++)
       stick[i].blocksize[j]=0;
  }
  /*put all blocks on stick 1 and no blocks on sticks 2 and 3*/
  stick[1].maxheight=height;stick[2].maxheight=stick[3].maxheight=0;
  for (k=height,size=1;k>=1;k--,size++) stick[1].blocksize[k]=size;
  displaysticks();
  move(height,1,3,2);
  exit(0);
}
