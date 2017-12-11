typedef struct treeentry {
       KeyType key;
} TreeEntry; 

typedef struct treenode {
    TreeEntry       entry;
    struct treenode *left;
    struct treenode *right;
} TreeNode;

void CreateTree(TreeNode **root);
int TreeEmtpy(TreeNode *root);
void Preorder(TreeNode *root, void (*Visit)(TreeEntry x));
void Inorder(TreeNode *root, void (*Visit)(TreeEntry x));
void Postorder(TreeNode *root, void (*Visit)(TreeEntry x));
TreeNode *Search(TreeNode *root, KeyType target);
TreeNode *Insert(TreeNode *root, TreeNode *newnode);
