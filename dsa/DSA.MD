### TAKE CARE OF LARGE NUMBER
- Since the answer could be large return answer % 109 + 7.

```java
final int MOD = 1000000007;
long result = 1L * N; // avoid overflow
return (int) ((result % MOD + MOD) % MOD);
```
### Math.ceil vs Pure Integer conversion 

```java
int pile = 10, k = 3;

// Math.ceil
int h1 = (int) Math.ceil((double)pile / k);  // → 4

// Integer trick
int h2 = (pile + k - 1) / k;                 // → 4

```
Both give same result ✅
But second version stays pure integer and faster.


### Why use this formula instead of (low + high) / 2?

You might think we could just write:

int mid = (low + high) / 2;


That works for small numbers —
but for very large arrays, low + high can overflow int.

For example:
```java
low = 1_000_000_000
high = 2_000_000_000
(low + high) = 3_000_000_000  // exceeds int range (2,147,483,647)


So the safer version:

mid = low + (high - low) / 2
```

prevents overflow while giving the same result.

✅ Summary
| Expression               | Result                 | Safe for large ranges? |
| ------------------------ | ---------------------- | ---------------------- |
| `(low + high) / 2`       | works but may overflow | ❌                      |
| `low + (high - low) / 2` | always safe            | ✅                      |
