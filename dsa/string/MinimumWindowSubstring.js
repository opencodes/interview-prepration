function minWindow(s, t) {
    let left = 0;
    let targetMap = {}, windowMap = {};
    for (let i = 0; i < t.length; i++) {
        if (targetMap[t[i]]) {
            targetMap[t[i]]++;
        } else {
            targetMap[t[i]] = 1;
            windowMap[t[i]] = 0;
        }
    }

    let have = 0, need = t.length;
    let minWindowLen = [];
    for (let right = 0; right < s.length; right++) {
        const char = s[right];

        if (windowMap[char] <= targetMap[char]) {
            windowMap[char]++;
            have++;
        }
        while (have == need) {
            if (windowMap[s[left]]) {
                windowMap[s[left]]--;
                have--;
            }
            minWindowLen.push(s.slice(left, right + 1));
            left++;
        }
    }
    return minWindowLen;

}

const str = "ADOBECODEBANC";
const target = "ABC";
const output = minWindow(str, target)
console.log("output: ", output);
