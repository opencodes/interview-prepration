const {  } = require('@datastructures-js/priority-queue');

function toCamelClassCase(str) {
    return str
        .replace(/[^a-zA-Z0-9_]+/g, ' ') // allow underscores, don't replace them
        .replace(/(?:^|\s+)([a-zA-Z0-9])/g, (_, c) => c.toUpperCase())
        .replace(/\s+/g, '')
        .replace(/^[^A-Z_]+/, ''); // allow leading underscores
}

// Q10_DistanceOfNearestCell
const names = [
    "Q17_ Batches",
    "Q18_ Commutable Islands",
    "Q19_ Construction Cost",
    "Q20_ Damaged Roads",
    "Q21_ Knight On Chess Board",
    "Q22_ Edge in MST",
    "Q23_ Dijkstra",
    "Q24_ Floyd Warshall Algorithm",
    "Q25_ Shortest Distance in a Maze",
    "Q26_ Maximum Depth",
    "Q27_ Sheldon and Pair of Cities",
    "Q28_ Largest Distance between nodes of a Tree",
    "Q29_ Smallest sequence with given Primes"
]

const files = names.map(name => {
    return toCamelClassCase(name) + ".java";
});
console.log("touch ", files.join(' '));