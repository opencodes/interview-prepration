### TAKE CARE OF LARGE NUMBER
- Since the answer could be large return answer % 109 + 7.

```java
final int MOD = 1000000007;
long result = 1L * N; // avoid overflow
return (int) ((result % MOD + MOD) % MOD);
```