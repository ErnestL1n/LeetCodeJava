# [idea is from here](https://leetcode.com/problems/permutations/discuss/18247/My-elegant-recursive-C++-solution-with-inline-explanation?orderBy=most_votes)
## [reference](https://leetcode.wang/leetCode-46-Permutations.html)	
```cpp
// permute num[begin..end]
// invariant: num[0..begin-1] have been fixed/permuted
void permuteRecursive(vector<int> &num, int begin, vector<vector<int> > &result){
	if (begin == num.size()) {
	// one permutation instance
	result.push_back(num);
	return;
	}
	for (int i = begin; i < num.size(); i++) {
	swap(num[begin], num[i]);
	permuteRecursive(num, begin + 1, result);
	// reset
	swap(num[begin], num[i]);
	}
}
```

Basic note: there is only c++ take &(reference)variable as parameter, golang needs copy、[python see this](https://stackoverflow.com/questions/4081561/what-is-the-difference-between-list-and-list-in-python)
