module.exports = {
	question: "Q2. First Depth First Search",
	//param A : integer
	//param B : array of array of integers
	//return an integer
	solve: function (A, B) {
		const start = 0;
		const adjList = new Array(A).fill(0).map(k => [])
		const visited = new Array(A).fill(0);
		for (let i = 0; i < B.length; i++) {
			const edge = B[i];
			console.log(edge);
			adjList[edge[0] - 1].push(edge[1] - 1)
		}
		function dfs(node, adjList, visited) {
			console.log('node. >> ',node);
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
		return visited[A - 1];
	}
}
// Example Input
// const A = 4;
// const B = [[1, 2], [2, 3], [4, 3]];

// console.log("Q.", question);
// console.log("Input: ", A, B);
// console.log("Output: ");
// console.log(solve(A, B));

