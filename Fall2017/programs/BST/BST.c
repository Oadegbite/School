#include <stdio.h>
#include "compare.h"
#include "BST.h"

 /* CreateTree:  create a tree.
Pre:   None.
Post: An empty binary search tree has been created to which root points.
 */
void CreateTree(TreeNode **root)
{
    *root = NULL;
}

 /* TreeEmpty:  TRUE if the tree is emtpy.
Pre:   The tree to which root points has been created.
Post: The function returns the value TRUE or FALSE according as the
tree is empty or not.
 */
int TreeEmtpy(TreeNode *root)
{
    return root == NULL;
}

 /* Preorder: visit each node of the tree in preorder.
Pre:  The binary tree to which root points has been created.
Post: The function Visit has been performed on every entry in the binary
tree in preorder sequence.
 */
void Preorder(TreeNode *root, void (*Visit)(TreeEntry x))
{
  if (root) {
    Visit(root->entry);
    Preorder(root->left, Visit);
    Preorder(root->right, Visit);
  }
}

 /* Inorder: visit each node of the tree in inorder.
Pre:  The binary tree to which root points has been created.
Post: The function Visit has been performed on every entry in the binary
tree in inorder sequence.
 */
void Inorder(TreeNode *root, void (*Visit)(TreeEntry x))
{
  if (root) {
    Inorder(root->left, Visit);
    Visit(root->entry);
    Inorder(root->right, Visit);
  }
}

 /* Postorder: visit each node of the tree in postorder.
Pre:  The binary tree to which root points has been created.
Post: The function Visit has been performed on every entry in the binary
tree in postorder sequence.
 */
void Postorder(TreeNode *root, void (*Visit)(TreeEntry x))
{
  if (root) {
    Postorder(root->left, Visit);
    Postorder(root->right, Visit);
    Visit(root->entry);
  }
}

 /* Search: search for target starting at node root.
Pre:   The tree to which root points has been created.
Post: The function returns a pointer to a tree node that matches target
or NULL if the target is not in the tree.
 */
TreeNode *Search(TreeNode *root, KeyType target)
{
    if (root)
        if (LT(target, root->entry.key))
            root = Search(root->left, target);
        else if (GT(target, root->entry.key))
            root = Search(root->right, target);
    return root;
}

 /* Insert: insert a new node in the tree.
Pre:   The binary search tree to which root points has been created.
    The parameter newnode points to a node that has been created and
    contains a key in its entry.
Post: The node newnode has been inserted into the tree in such a way
    that the properties of a binary search tree are preserved.
 */
TreeNode *Insert(TreeNode *root, TreeNode *newnode)
{
    if (!root) {
        root = newnode;
        root->left = root->right = NULL;

    } else if (LT(newnode->entry.key, root->entry.key))
        root->left = Insert(root->left, newnode);
    else
        root->right = Insert(root->right, newnode);
    return root;
}

