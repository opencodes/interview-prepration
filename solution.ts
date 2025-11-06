/**
 Do not return anything, modify board in-place instead.
 */
function gameOfLife(board: number[][]): void {
    let replace = [

    ]
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            let diff = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1][1, 0], [1, 1]]
            let zeros = 0, ones = 0
            for (let k = 0; k < diff.length; k++) {
                const diffK = diff[k]
                if ()
            }
        }
    }
};