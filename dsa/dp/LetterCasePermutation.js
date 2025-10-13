function letterCasePermutation(s) {
    const res = [];

    function backtrack(path, index) {
        // base case: reached end of string
        if (index === s.length) {
            res.push(path);
            return;
        }

        const char = s[index];
        console.log('path', path, index, res);

        if (/[a-zA-Z]/.test(char)) {
            // branch with lowercase
            backtrack(path + char.toLowerCase(), index + 1);
            // branch with uppercase
            backtrack(path + char.toUpperCase(), index + 1);
        } else {
            // digit, continue directly
            backtrack(path + char, index + 1);
        }
    }
    backtrack("", 0);
    return res;
}

// Example usage:
console.log(letterCasePermutation("a1b2"));
// Output: [ 'a1b2', 'a1B2', 'A1b2', 'A1B2' ]
