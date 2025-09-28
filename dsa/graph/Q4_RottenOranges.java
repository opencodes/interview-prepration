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

function solve(A) {
	const m = A.length;
	const n = A[0].length;
	const queue = new Queue();
	let freshOranges = 0;
	//Create adj metrics
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (A[i][j] == 2) {
				queue.push([i, j])
			}
			if (A[i][j] == 1) {
				freshOranges++;
			}
		}
	}
	if (freshOranges == 0) {
		return 0;
	}
	let numOfMin = 0;
	let isRotten = false;
	if (queue.isEmpty()) {
		return;
	}
	while (!queue.isEmpty()) {
		const [i, j] = queue.pop();
		//If current orange is fresh, make it rotten
		if (A[i][j] == 1) {
			A[i][j] = 2;
		}
		const dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]];
		dirs.forEach(dir => {
			const ni = i + dir[0];
			const nj = j + dir[1];
			//Check for valid index
			if (ni >= 0 && ni < A.length && nj >= 0 && nj < A[0].length) {
				const n = A[ni][nj];
				//If fresh orange found, make it rotten and add to queue
				if (n == 1) {
					A[ni][nj] = 2;
					isRotten = true;
					queue.push([ni, nj]);
				}
			}
		});
		if (isRotten) {
			isRotten = false;
			numOfMin++;
		}
	}
	//Check if any fresh orange is left
	for (let i = 0; i < A.length; i++) {
		for (let j = 0; j < A[0].length; j++) {
			if (A[i][j] == 1) {
				return -1;
			}
		}
	}
	// console.log("A", A, "q ", queue.toArray());
	return numOfMin;
}

// Example Input
let A = [
	[2, 1, 1],
	[0, 1, 1],
	[1, 0, 1]
]
console.log("Q.", "Rotten Oranges");
console.log("Input: ", A);
console.log("Output: ");
console.log(solve(A));
