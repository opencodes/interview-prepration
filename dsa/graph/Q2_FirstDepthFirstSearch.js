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
