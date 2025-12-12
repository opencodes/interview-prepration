import { ListNode, printLinkedList } from "./lib.ts";

// Form a linkedlist from array
function createLinkedListFromArray(array: number[]): ListNode | null {
    if (!array.length) {
        return null
    }
    let node: ListNode = new ListNode(array[0]);
    let curr = node;

    for (let i = 1; i < array.length; i++) {
        curr.next = new ListNode(array[i])
        curr = curr.next
    }
    return node
}
// Length of Linked List
function lengthOfLinkedList() {

}
// Print Linked List
// Search in a Linked List
// Linked List Insertion
// Deleting a given key
// Deleting at given position
// Delete a Linked List
// Nth Node from Start
// Nth Node from End
// Size of Doubly Linked List



let nodeArr = [1, 2, 3, 4, 5, 6]
let linkedListFromNode = createLinkedListFromArray(nodeArr)
console.log(printLinkedList(linkedListFromNode))