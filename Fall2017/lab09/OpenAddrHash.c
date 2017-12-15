#include <stdio.h>
#include "OpenAddrHash.h"


void InitializeTable(Table T) {
  int i;
  for (i=0;i<M;i++) T[i].Key=EmptyKey;
}

void LoadFactor(Table T)
{
  float loadF;
  int emp = 0;
  for (int i = 0; i <M; i++)
  {
    if(T[i].Key != EmptyKey) emp += 1;
  }
  loadF = (float)emp/M;
  printf("Entries: %d\n", emp);
  printf("Load factor: %0.2f\n", loadF);
}

void PrintTable(Table T) {
  int i;
  printf("\nTable:\n");
  for (i=0;i<M;i++) {
	  printf("Slot %4d: Key: %4d ",i,T[i].Key);
	  if (T[i].Key != EmptyKey)
    {
      printf("Info: %c",T[i].Info);
    }printf("\n");
  }
}

void HashInsert(Table T, KeyType K, InfoType I, int *b) {
  int i;
  int ProbeDecrement;
  i=h(K);
  ProbeDecrement = p(K);

  while (T[i].Key != EmptyKey) {
	  i-=ProbeDecrement;
    *b += 1;
	  if (i<0) i+=M;
  }
  T[i].Key = K;
  T[i].Info = I;
}

int HashSearch(Table T, KeyType K) {
	int i,ProbeDecrement;
	KeyType ProbeKey;

	i=h(K);
	ProbeDecrement = p(K);
	ProbeKey = T[i].Key;

	while ((K != ProbeKey) && (ProbeKey != EmptyKey)) {
		i -=ProbeDecrement;
		if (i<0) i+=M;
		ProbeKey = T[i].Key;
	}

	if (ProbeKey == EmptyKey)  return -1;
	else return i;
}
