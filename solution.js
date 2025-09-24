function transform(op1, op2) {
    if (op1.type === "Insert" && op2.type === "Insert") {
        if (op1.pos > op2.pos || (op1.pos === op2.pos && op1.userId > op2.userId)) {
            // If op1 is after op2, or they are at the same position but op1 has a higher userId, move op1 forward
            op1.pos += op2.text.length;
        }
    }

    else if (op1.type === "Insert" && op2.type === "Delete") {
        if (op1.pos > op2.pos) {
            op1.pos -= op2.len;
        }
    }

    else if (op1.type === "Delete" && op2.type === "Insert") {
        if (op1.pos >= op2.pos) {
            op1.pos += op2.text.length;
        }
    }

    else if (op1.type === "Delete" && op2.type === "Delete") {
        let start1 = op1.pos;
        let end1 = op1.pos + op1.len;
        let start2 = op2.pos;
        let end2 = op2.pos + op2.len;

        // Case 1: overlap
        if (end1 > start2 && end2 > start1) {
            let overlapStart = Math.max(start1, start2);
            let overlapEnd = Math.min(end1, end2);
            let overlapLen = overlapEnd - overlapStart;

            op1.len -= overlapLen;
            if (start2 < start1) {
                op1.pos -= Math.min(op2.len, start1 - start2);
            }
        }
        // Case 2: op2 before op1, no overlap
        else if (op1.pos > op2.pos) {
            op1.pos -= op2.len;
        }
    }

    return op1;
}
function applyInsert(str, op) {
    return str.slice(0, op.pos) + op.text + str.slice(op.pos);
}

function applyDelete(str, op) {
    return str.slice(0, op.pos) + str.slice(op.pos + op.len);
}



let str = "Abc";
let op1 = { type: "Insert", pos: 1, text: "x", userId: 2 };
let op2 = { type: "Insert", pos: 1, text: "y", userId: 1 };
op1 = transform(op1, op2);
str = applyInsert(str, op2);
str = applyInsert(str, op1);
console.log(str); // Ayxbc


// str = "Abc";
// op1 = { type: "Delete", pos: 1, len: 1 };
// op2 = { type: "Insert", pos: 0, text: "x", userId: 1 };
// op1 = transform(op1, op2);
// str = str.slice(0, op1.pos) + str.slice(op1.pos + op1.len);
// console.log(str); // xAc

// str = "Abc";
// op1 = { type: "Delete", pos: 1, len: 2 };
// op2 = { type: "Delete", pos: 0, len: 1 };
// op1 = transform(op1, op2);
// str = str.slice(0, op1.pos) + str.slice(op1.pos + op1.len);
// console.log(str); // c

// str = "Abc";
// op1 = { type: "Delete", pos: 0, len: 2 };
// op2 = { type: "Delete", pos: 1, len: 2 };
// op1 = transform(op1, op2);
// str = str.slice(0, op1.pos) + str.slice(op1.pos + op1.len);
// console.log(str); // (empty string)
