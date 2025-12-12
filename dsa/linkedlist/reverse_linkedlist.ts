import { ListNode, printLinkedList } from "./lib.ts";


function reverseLinkedList(head: ListNode | null): ListNode | null {
    if (!head || !head.next) {
        return head;
    }
    let prev: ListNode | null = null;
    let curr: ListNode | null = head
    while (curr) {
        let temp: ListNode | null = curr?.next;
        curr.next = prev
        prev = curr;
        curr = temp;
    }
    return prev;
}

function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
    if (!head || left === right) return head;
    //Slice 1st part

    let dummy: ListNode | null = new ListNode(0, head);
    let prev: ListNode | null = dummy;

    //move prev to the node before left
    for (let i = 1; i < left; i++) {
        prev = prev!.next
    }

    //start reversing
    let curr: ListNode | null = prev!.next
    let next: ListNode | null = null;

    for (let i = 0; i < right - left; i++) {
        next = curr!.next;//node to be repositioned
        curr!.next = next!.next;//remove next from its current position
        next!.next = prev!.next;//insert next after prev
        prev!.next = next;//link prev to next

    }
    return dummy.next;
};

function reverseNodeInKGroup(head: ListNode | null, k: number): ListNode | null {
    if (!head || k == 1) return head;
    //Slice 1st part

    let dummy: ListNode | null = new ListNode(0, head);
    let temp: ListNode = new ListNode(0, head);;
    let prev: ListNode | null = dummy;



    while (true) {
        //check if there are k nodes to reverse
        for (let j = 1; j < k; j++) {
            if (!temp.next) {
                console.log("Exit no k node to reverse");
                return dummy.next;
            }
            temp = temp.next;
        }
        //start reversing
        let curr: ListNode | null = prev!.next
        let next: ListNode | null = null;
        //reverse k nodes
        for (let j = 1; j < k; j++) {
            next = curr!.next;//node to be repositioned
            curr!.next = next!.next;//remove next from its current position
            next!.next = prev!.next;//insert next after prev
            prev!.next = next;//link prev to next
        }
    }
    return dummy.next;
};

// head = [1,2,3,4,5], left = 2, right = 4
let node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,)))))
// node = new ListNode(3, new ListNode(5))
console.log("Input: ", printLinkedList(node));

let resultNode = reverseNodeInKGroup(node, 2); // expected output [1,4,3,2,5]
console.log("Output: ", printLinkedList(resultNode));