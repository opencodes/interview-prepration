const { Queue } = require("@datastructures-js/queue");

/**
 Q1. Rotten Oranges

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

Problem Constraints
1 <= N, M <= 1000
0 <= A[i][j] <= 2

Input Format
- The first argument given is the integer matrix A.

Output Format
- Return the minimum number of minutes that must elapse until no cell has a fresh orange.
- If this is impossible, return -1 instead.

Example Input
Input 1:
A = [   [2, 1, 1]
		[1, 1, 0]
		[0, 1, 1]   ]
Input 2:
A = [   [2, 1, 1]
		[0, 1, 1]
		[1, 0, 1]   ]

Example Output
Output 1:
 4
Output 2:
 -1
*/

//param A : integer
//param B : array of array of integers
//return an integer
function bfs(adj, visited, queue) {
	if (queue.isEmpty()) {
		return;
	}
	while (!queue.isEmpty()) {
		const [i, j] = queue.pop();
		if (visited[i] == 1) {
			visited[i] = 2;
		}
		const neighbours = adj[i];
		neighbours.forEach(neighbour => {
			const [i, j] = neighbour;
			if (A[i][j] == 1) {
				queue.push([i, j])
			}
		});
		numOfMin++;
	}
}
function solve(A) {
	const m = A.length;
	const n = A[0].length;
	let numOfMin = 0;
	const adjList = new Array(m).fill(0).map(m => [])
	const queue = new Queue();
	//Create adj metrics
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (A[i][j] != 0) {
				adjList[i].push(j)
			}
			if (A[i][j] == 2) {
				queue.push(i)
			}
		}
	}
	const visited = new Array(m).fill(0);
	console.log(queue);
	// bfs(A, adjList, visited, queue);
	return numOfMin;
}

// Example Input
let A = [
	[2, 1, 1],
	[1, 1, 0],
	[0, 1, 1]
]
console.log("Q.", "Rotten Oranges");
console.log("Input: ", A);
console.log("Output: ");
console.log(solve(A));
