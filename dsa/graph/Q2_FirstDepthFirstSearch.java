/**
Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
Given 2 towns find whether you can reach the first town from the second without repeating any edge.
B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.

Problem Constraints
1 <= N <= 100000

Input Format
- First argument is vector A
- Second argument is integer B
- Third argument is integer C

Output Format
- Return 1 if reachable, 0 otherwise.
*/

module.exports = {
	//param A : integer
	//param B : array of array of integers
	//return an integer
	solve: function (A, B, C) {
		const start = C-1;
		const adjList = new Array(A.length).fill(0).map(k => [])
		const visited = new Array(A.length).fill(0);

		for (let i = 1; i < A.length; i++) {
			const from = A[i], to = i + 1;
			adjList[from - 1].push(to - 1)
		}
		function dfs(node, adjList, visited) {
			if (visited[node] == 1) {
				return;
			}
			visited[node] = 1;
			const neighbours = adjList[node];
			neighbours.forEach(n => {
				if (visited[n] != 1) {
					dfs(n, adjList, visited)
				}
			})
		}
		dfs(start, adjList, visited);
		return visited[B - 1];
	}
};
