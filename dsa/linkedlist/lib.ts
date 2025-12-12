//  * Definition for singly-linked list.
export class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

export function printLinkedList(node: ListNode | null): string {
    const values: number[] = [];
    while (node) {
        values.push(node.val);
        node = node.next;
    }
    return values.join(" -> ");
}


