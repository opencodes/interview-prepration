//  * Definition for singly-linked list.
export class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

export class LinkedListUtil {
    // Print a linked list
    printLinkedList(node: ListNode | null): string {
        const values: number[] = [];
        while (node) {
            values.push(node.val);
            node = node.next;
        }
        return values.join(" -> ");
    }
    // Form a linkedlist from array
    createLinkedListFromArray(array: number[]): ListNode | null {
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
    lengthOfLinkedList(head: ListNode | null): number {
        let count = 0;
        while (head != null) {
            head = head.next
            count++;
        }
        return count
    }
    //Reverse a Linked List
    reverseLinkedList(head: ListNode | null): ListNode | null {
        if (!head) {
            return head
        }
        let prev: ListNode | null = null;
        let curr: ListNode = head;
        let next: ListNode | null = head.next

        //Reverse
        while (curr) {
            curr.next = prev
            prev = curr
            if (!next) {
                return curr
            }
            curr = next
            next = next?.next
        }
        return curr
    }
    reverseSegment(head: ListNode | null, from: number, to: number) {
        if (!head || !head.next) {
            return head
        }
        let prev: ListNode | null = new ListNode(0, head)
        let curr: ListNode | null = head;
        let next: ListNode | null = head;
        //reach till before from - 2-1
        for (let i = 1; i < from; i++) {
            prev = prev!.next
            curr = curr!.next
        }
        next = curr
        // move next to post segment
        for (let i = 1; i < to - from + 1; i++) {
            if (next) {
                next = next!.next
            }
        }
        let temp = next!.next;
        next!.next = null
        let reversedSegmentLinkedList = this.reverseLinkedList(curr)
        // r.next = next
        if (prev) {
            prev.next = reversedSegmentLinkedList
        }
        //go to end reverse list
        let r: ListNode | null = prev
        while (r && r.next) {
            r = r.next
        }
        if (r) {
            r.next = temp
        }
        return prev
    }

    reverseInAgroup(head: ListNode | null, k: number) {

    }

    // Search in a Linked List
    // Linked List Insertion
    // Deleting a given key
    // Deleting at given position
    // Delete a Linked List
    // Nth Node from Start
    // Nth Node from End
    // Size of Doubly Linked List
}


