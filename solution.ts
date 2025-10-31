function fullJustify(words: string[], maxWidth: number): string[] {
    let line = [];
    let strLen = 0;
    let out = [];

    for (let i = 0; i < words.length; i++) {
        let word = words[i];
        let estCount = strLen + (line.length > 0 ? 1 : 0) + word.length;
        //Consider one line
        if (estCount > maxWidth) {
            // console.log("Close Line at ", i, "line:", line, "s
            // trLen:", strLen, "estCount:", estCount, "word:", word);
            let spaceRequired = maxWidth - strLen + line.length - 1;
            let betweenSpace = line.length == 1 ? 0 : Math.floor(spaceRequired / (line.length - 1));
            let remainingSpace = line.length == 1 ? 0 : spaceRequired % (line.length - 1);
            // console.log("spaceRequired:", spaceRequired, "betweenSpace:", betweenSpace, "remainingSpace:", remainingSpace);
            let btnSpace = new Array(betweenSpace).fill(" ").join("")
            let joinedStr = line.join(btnSpace)
            joinedStr += new Array(remainingSpace).fill(" ").join("")
            out.push(joinedStr)
            console.log("joinedStr:", joinedStr.length, "maxWidth:", maxWidth);

            line = [];
            strLen = 0;
        }
        line.push(word)
        strLen += word.length + (strLen > 0 ? 1 : 0);
    }
    const diff = maxWidth - strLen;
    const joinedStr = line.join(" ") + (diff >= 1 ? new Array(maxWidth - strLen).fill(" ").join("") : "")
    console.log("joinedStr:", joinedStr.length, "maxWidth:", maxWidth);
    out.push(joinedStr)
    console.log("out", out);
    return out;
};
const words = ["This", "is", "an", "example", "of", "text", "justification."]

const maxWidth = 16
console.log(fullJustify(words, maxWidth))