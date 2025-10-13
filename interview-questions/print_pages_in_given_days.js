/** 
🧩 Q1. Check Printing Feasibility

Given an array pages[], where each element represents pages in a document, a printer can print only contiguous documents each day with a daily limit limit.
Determine if all documents can be printed within noOfDays.

Input: pages = [100,200,300,600], noOfDays = 2, limit = 600
Output: Possible

🧮 Q2. Find Minimum Print Capacity

Given an array pages[] and an integer noOfDays, find the minimum daily print capacity required to print all documents (contiguous) within the given days.

Input: pages = [100,200,300,600], noOfDays = 2
Output: 600

*/

function canPrint(pages, noOfDays, limit) {
    let minNoOfDays = 1;
    let printed = 0;

    for (let i = 0; i < pages.length; i++) {
        const page = pages[i];
        if (page > limit) {
            return false;
        }
        if (page + printed > limit) {
            minNoOfDays++;
            printed = 0;
        }
        printed += page;
    }
    return minNoOfDays <= noOfDays;
}

function getMinCapacity(pages, noOfDays) {
    let min = 0;
    let max = 0;
    pages.forEach(p => {
        max += p;
    });

    while (min < max) {
        let mid = Math.floor((min + max) / 2);
        if (canPrint(pages, noOfDays, mid)) {
            // Look for lower side
            max = mid;
            min = min == 0 ? mid : Math.min(min, mid);
        } else {
            // Look for upper side
            min = mid + 1;
        }
    }
    return min;
}

// Execute
const pages = [100, 200, 300, 400, 500];
const noOfDays = 2;
const dailyPrintLimit = 600;
const result = canPrint(pages, noOfDays, dailyPrintLimit)
console.log(`Can we print all the give pages ${pages} with daily page limit ${dailyPrintLimit} in ${noOfDays} Days: ${result}`);

const result2 = getMinCapacity(pages, noOfDays);
console.log(`Now minimum daily print capacity needed to print all pages in given days: ${result2}`)
