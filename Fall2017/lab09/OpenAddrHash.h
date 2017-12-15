#define M 17
#define EmptyKey -1
typedef int KeyType;
typedef char InfoType;


typedef struct {
	KeyType Key;
	InfoType Info;
	} TableEntry;

typedef TableEntry Table[M];

int p(KeyType);
int h(KeyType);
void InitializeTable(Table T);
void PrintTable(Table T);
void HashInsert(Table T, KeyType K, InfoType I,int *b);
int HashSearch(Table T, KeyType K);
void LoadFactor(Table T);
