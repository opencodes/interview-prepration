
/**
Q. Number of islands
Given a matrix of integers A of size N x M consisting of 0 and 1. 
A group of connected 1's forms an island. 
From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

Return the number of islands.
- NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
Example Input

Input 1:
 A = [ 
	   [0, 1, 0]
	   [0, 0, 1]
	   [1, 0, 0]
	 ]
Input 2:
 A = [   
	   [1, 1, 0, 0, 0]
	   [0, 1, 0, 0, 0]
	   [1, 0, 0, 1, 1]
	   [0, 0, 0, 0, 0]
	   [1, 0, 1, 0, 1]    
	 ]
Example Output
Output 1:
 2
Output 2:
 5
*/

function solve(A) {
	if (!A || !A.length) {
		return 0;
	}
	let numOfIsland = 0;
	function bfs(i, j, A) {
		if (A[i][j] != 1) {
			return;
		}
		A[i][j] = 2;
		const dirs = [
			[-1, -1], [0, -1], [1, -1], 
			[-1, 0], 		   [1, 0], 
			[-1, 1],  [0, 1],  [1, 1]
		];
		const imax = A.length, jmax = A[0].length;
		dirs.forEach(dir => {
			const ni = i + dir[0], nj = j + dir[1];
			if (ni >= 0 && ni < imax && nj >= 0 && nj < jmax) {
				const el = A[ni][nj];
				if (el == 1) {
					bfs(ni, nj, A);
				}
			}
		})
	}
	for (let i = 0; i < A.length; i++) {
		for (let j = 0; j < A[i].length; j++) {
			const node = A[i][j];
			if (node == 1) {
				bfs(i, j, A);
				numOfIsland++;
			}
		}
	}
	return numOfIsland;
}

// Example Input
A = [ 
       [1, 1, 0, 0, 0],
       [0, 1, 0, 0, 0],
       [1, 0, 0, 1, 1],
       [0, 0, 0, 0, 0],
       [1, 0, 1, 0, 1]    
     ]
console.log("Q.", "Q. Number of islands");
console.log("Input: ", A);
console.log("Output: ");
console.log(solve(A));
