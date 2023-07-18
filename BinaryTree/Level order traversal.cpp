class Solution
{
    public:
    //Function to return the level order traversal of a tree.
    vector<int> res ;
    vector<int> levelOrder(Node* node)
    {
        queue<Node *> q ;
        q.push(node) ;
        while(q.size() > 0){
            for(int i = 0 ; i < q.size() ; i ++){
                Node * curr  = q.front() ;
                q.pop() ;
                res.push_back(curr->data);
                
                if(curr->left != NULL){
                    q.push(curr->left);
                }
                
                if(curr->right != NULL){
                    q.push(curr->right);
                }
            }
        }
        return res ;
    }
};


//https://leetcode.com/problems/binary-tree-level-order-traversal/
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(!root) return ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int s = q.size();
            vector<int> v;
            while(s--){
                TreeNode *f = q.front();
                v.push_back(f->val);
                q.pop();
                if(f->left) q.push(f->left);
                if(f->right) q.push(f->right);
            }
            ans.push_back(v);
        }
        return ans;
    }
};