class MinStack {
    stack_arr = [];
    min_stack = [];
    size = 0;

    minStack() {
        return this.min_stack;
    }

    push(val) {
        this.size ? this.min_stack.push(Math.min(this.min_stack[this.size - 1], val)) : this.min_stack.push(val);
        this.stack_arr.push(val)
        this.size += 1;
    }

    pop() {
        this.min_stack.pop();
        this.stack_arr.pop();
        this.size -= 1;
    }

    top() {
        console.log(this.stack_arr[this.size - 1])
    }

    getMin() {
        console.log(this.min_stack[this.size - 1])
    }
}
const operations = ["minStack", "push 5", "push 3", "push 7", "getMin ", "pop", "top", "getMin"];
const obj = new MinStack();
operations.forEach(o => {
    const op = o.split(" ");
    switch (op[0]) {
        case "push":
            obj.push(parseInt(op[1], 10));
            break;
        case "pop":
            obj.pop();
            break;
        case "top":
            obj.top();
            break;
        case "getMin":
            obj.getMin();
            break;
        case "minStack":
            obj.minStack();
            break;
        default:
            break;
    }
    console.log("===> stack: ", obj.stack_arr, "minStack: ", obj.minStack());
})



// Create a stack that supports the usual push, pop, and top operations, and also provides a getMin operation that returns the smallest element in the stack. All operations must run in O(1) time.

// Input Format:
// The first line contains an integer Q, the number of queries.
// Each of the next Q lines contains a query in one of the following formats:
// push x – push integer x onto the stack.
// pop – remove the element on the top of the stack.
// top – output the element on the top of the stack.
// getMin – output the minimum element currently in the stack.
// Output Format:
// For each top or getMin query, print the requested integer on a new line. If the stack is empty when pop, top, or getMin is called, print EMPTY for that query.
// Example 1:
// Input:
// 7
// push 5
// push 3
// push 7
// getMin
// pop
// top
// getMin

// Output:
// 3
// 5
// 3