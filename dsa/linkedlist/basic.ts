import { LinkedListUtil, ListNode } from "./lib.ts"
let util = new LinkedListUtil();

let nodeArr = [1, 2, 3, 4, 5, 6]
console.log("Array to Linked List:", nodeArr)
let linkedListFromNode = util.createLinkedListFromArray(nodeArr)
console.log("Print a linked list", util.printLinkedList(linkedListFromNode))
console.log("Length of a linked list", util.lengthOfLinkedList(linkedListFromNode))
console.log("Reversed Linkedlist: ", util.printLinkedList(util.reverseLinkedList(linkedListFromNode)))