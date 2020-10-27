//BFS
typedef pair<int,int> pr;
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        int m=matrix.size(),n=matrix[0].size();
        queue<pr> q;
        for(int i=0;i<m;++i)
            for(int j=0;j<n;++j){
                if(matrix[i][j]==0)
                    q.push(make_pair(i,j));
                else
                    matrix[i][j]=INT_MAX;
            }
        vector<pr> dirs={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.empty()){
            auto cell=q.front();
            q.pop();
            for(auto& [i,j]:dirs){
                int r=i+cell.first;
                int c=j+cell.second;
                if(r<0||r>=m||c<0||c>=n||matrix[r][c]<=1+matrix[cell.first][cell.second])
                    continue;
                q.push(make_pair(r,c));
                matrix[r][c]=matrix[cell.first][cell.second]+1;
            }
        }
        return matrix;
    }
};