#include <stdio.h>
#include "OpenAddrHash.h"
int tcolls;

int h(KeyType K) {
	return K%M;
}
int p(KeyType K) {
	return K/M;
}

void LookFor(Table T, KeyType K) {
	int found;
	found=HashSearch(T,K);
	if (found == -1) printf("key %d not found\n",K);
	else printf("key %d found in slot %d\n",K,found);
}

int main(void) {
	int found;
	tcolls=0;
	Table T;
	InitializeTable(T);
	HashInsert(T,9, 'a',&tcolls);
	HashInsert(T,61,'b',&tcolls);
	HashInsert(T,95,'c',&tcolls);
	HashInsert(T,78,'d',&tcolls);
	HashInsert(T,44,'e',&tcolls);
	PrintTable(T);
	LookFor(T,44);
	LookFor(T,58);
	printf("%d\n",tcolls);
	LoadFactor(T);
	return 0;
}
