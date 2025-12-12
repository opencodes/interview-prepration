import { ListNode, printLinkedList } from "./dsa/linkedlist/lib";



function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
    if (!head || left === right) return head;
    let dummy: ListNode = new ListNode(0, head);
    let prev: ListNode | null = dummy;
    // Move pointer to left
    for (let i = 1; i < left; i++) {
        prev = prev!.next;
    }
    //prev at 1-2-3-4-5
    console.log("29 : prev :", printLinkedList(prev));

    // Start reversing
    let curr = prev!.next;
    let next: ListNode | null = null;

    console.log("35 : curr :", printLinkedList(curr));
    console.log("36 : Loop");

    // Step 2: Reverse nodes from left to right
    for (let i = 0; i < right - left; i++) {
        console.log("40 : i ", i);

        // 1. Store next node
        next = curr!.next;// next = 3-4-5
        console.log("next :", printLinkedList(next), ", prev :", printLinkedList(prev), ", curr :", printLinkedList(curr));
        // 2. Reverse the link
        curr!.next = next!.next;//  curr = 2-4-5
        console.log("next :", printLinkedList(next), ", prev :", printLinkedList(prev), ", curr :", printLinkedList(curr));


        // 3. Insert the node at the beginning of the reversed part
        next!.next = prev!.next;// next = 3-2-4-5
        console.log("next :", printLinkedList(next), ", prev :", printLinkedList(prev), ", curr :", printLinkedList(curr));

        // 4. Update the previous node to point to the new first node
        prev!.next = next;// 1-3-2-4-5
        console.log("next :", printLinkedList(next), ", prev :", printLinkedList(prev), ", curr :", printLinkedList(curr));


    }
    return dummy.next;
};

// head = [1,2,3,4,5], left = 2, right = 4
const node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
let resultNode = reverseBetween(node, 2, 4);
// printLinkedList(resultNode);