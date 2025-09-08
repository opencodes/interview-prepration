// ["ate", "eat", "tea", "nat", "tan", "bat"]

function groupAnagram(array) {
    if (!array || array.length == 0) {
        return []
    }
    let hash = {};
    let alphabetArr = new Array(26);

    for (let i = 0; i < array.length; i++) {
        const el = array[i];
        alphabetArr = alphabetArr.fill(0);
        for (let j = 0; j < el.length; j++) {
            alphabetArr[el[j].charCodeAt(0) - 'a'.charCodeAt(0)] = 1;
        }
        let joinedStr = alphabetArr.join("");

        if (!hash[joinedStr]) {
            hash[joinedStr] = [];
        }
        hash[joinedStr].push(el);
    }
    console.log(hash);

    return Object.values(hash)
}
let input = ["ate", "eat", "tea", "nat", "tan", "bat"];
let ans = groupAnagram(input);
console.log("Answer for given array", input, " is ", ans);
