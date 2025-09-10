// ["ate", "eat", "tea", "nat", "tan", "bat"]

function numberOfAtomsInChemical(str) {
    let n = str.length - 1;
    let output = {};
    let i = 0;

    while (i < n) {
        let char = str[i];
        i++;

        while (str[i] >= "a") {
            char += str[i];
            i++;
        }

        let numStr = "";
        while (parseInt(str[i], 10) > 0) {
            numStr += str[i];
            i++;
        }
        output[char] = output[char] ? output[char] + 1 : parseInt(numStr, 10) || 1
    }
    return output;
}
let inputs = ["NaCl", "H2SO4", "C12H12O22"]
inputs.forEach(input => {
    let ans = numberOfAtomsInChemical(input);
    console.log("Answer for given input", input, " is ", ans);
})

systemdesignconcept
systemdesignconcepts