class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> ans;
        tree(root,"", ans);
        return ans;
    }
    void tree(TreeNode* root, string s, vector<string>& ans) // s is unique to each recursive call and changes when function goes from parent->child or child->parent
    {
        if(root==NULL)
            return;
        if(root->right!=NULL || root->left!=NULL ) //If a node is not a leaf, just add the value to the string and traverse it's child nodes
        {
            s+=to_string(root->val)+"->";
            tree(root->left, s, ans);
            tree(root->right, s, ans);
        }
        else //if a node is a leaf node add its value to the string and now push this string to the vector of Strings
        {
            s+=to_string(root->val);
            ans.push_back(s);
            return;
        }
    }
};