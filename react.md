# Advanced React Interview Questions & Answers

## ✅ Core Advanced Questions

1. **What is React Fiber?**
   - React's reconciliation engine that enables **incremental rendering** and task prioritization.

2. **What are Hooks?**
   - Functions like **useState, useEffect** that allow state and lifecycle logic in **functional components**.

3. **Difference between useEffect and useLayoutEffect?**
   - `useEffect`: Runs **after paint**.
   - `useLayoutEffect`: Runs **before paint**, blocking rendering.

4. **What is React Concurrent Mode?**
   - Allows **non-blocking rendering**, enhancing responsiveness and UX.

5. **What is Suspense in React?**
   - Used for **lazy loading components** and handling async data with a fallback UI.

6. **What is useCallback vs useMemo?**
   - `useCallback`: Memoizes **functions**.
   - `useMemo`: Memoizes **computed values**.

7. **What is Context API?**
   - Provides a way to **pass global state/data** without prop drilling.

8. **What is Prop Drilling?**
   - Passing data through **multiple levels of components**.

9. **Explain React.memo.**
   - HOC that **prevents re-rendering** if props haven't changed.

10. **What are Higher Order Components (HOC)?**
    - Functions that take a component and return an **enhanced component**.

11. **Redux vs Context API?**
    - **Redux:** Scalable, middleware support.
    - **Context API:** Simpler, for light state sharing.

12. **What is Refs in React?**
    - Provide **direct access to DOM elements**.

13. **Controlled vs Uncontrolled Components?**
    - Controlled: Managed by **React state**.
    - Uncontrolled: Managed by **DOM & refs**.

14. **Explain Error Boundaries.**
    - Catch JS errors in the component tree using **componentDidCatch**.

15. **What is Key Prop and its importance?**
    - Helps React **identify elements uniquely** in lists.


## ✅ More Advanced Topics

16. **What is Portals in React?**
    - Render children into a **DOM node outside the parent hierarchy**.

17. **What is React.lazy?**
    - Enables **component-level code splitting**.

18. **Virtual DOM vs Real DOM?**
    - Virtual DOM: JS object, faster updates.
    - Real DOM: Browser's DOM, slower to update.

19. **What is Server-Side Rendering (SSR)?**
    - Renders React components on the **server for better SEO**.

20. **What is hydration in React?**
    - Attaching React to **server-rendered HTML**.

21. **useImperativeHandle purpose?**
    - Customize ref values with **forwardRef**.

22. **Class vs Functional Component?**
    - Class: Lifecycle methods.
    - Functional: **Hooks-based**, simpler.

23. **Concept of Keys in React Lists?**
    - Unique identifiers for list elements to optimize rendering.

24. **Strict Mode in React?**
    - Helps identify **potential problems** in an app.

25. **What is batching in React?**
    - **Combining multiple state updates** into a single render.


## ✅ Custom Hooks

26. **What are Custom Hooks?**
    - **Reusable logic** using built-in hooks.

27. **Why use Custom Hooks?**
    - For **code reusability, testability, and cleaner components**.

28. **Creating a Custom Hook Example:**
```js
import { useState, useEffect } from 'react';

function useFetchData(url) {
  const [data, setData] = useState(null);

  useEffect(() => {
    async function fetchData() {
      const response = await fetch(url);
      const result = await response.json();
      setData(result);
    }
    fetchData();
  }, [url]);

  return data;
}
```

29. **Can Custom Hooks call other Hooks?**
    - Yes, including **other custom and built-in hooks**.

30. **Rules for Custom Hooks:**
    - Must start with `use`.
    - Called at the **top level**.

31. **Normal Function vs Custom Hook:**
    - Custom Hooks can **use hooks** internally, normal functions can't.

32. **Sharing state between components using Custom Hooks?**
    - State is **isolated per component**, logic is shared.

33. **Custom Hook vs HOC?**
    - Hooks: Functional components.
    - HOC: Wrapping components.

34. **Use Cases for Custom Hooks:**
    - Data fetching, debouncing, window resize tracking, event listeners.

35. **Can you memoize values in Custom Hooks?**
    - Yes, using **`useMemo`, `useCallback`**.

36. **How to pass arguments to Custom Hooks?**
    - Like regular functions, e.g. `useFetchData(url)`.

37. **Can Custom Hooks return functions?**
    - Yes, for exposing logic to the component.

38. **Side effects in Custom Hooks?**
    - Managed via **`useEffect`**.

39. **Debugging Custom Hooks?**
    - Via logs, dev tools, and modular hooks.

40. **Custom Hook vs Render Props?**
    - Hooks for functional components; Render Props for class-based components.


## ✅ Optimization Questions

41. **React performance optimization methods:**
    - Code splitting, React.memo, virtualization, avoiding prop changes.

42. **React.memo usage?**
    - Prevent re-renders for **pure functional components**.

43. **useMemo vs useCallback?**
    - `useMemo`: **Memoize values**.
    - `useCallback`: **Memoize functions**.

44. **React Profiler:**
    - Measures **rendering performance**.

45. **Causes of unnecessary re-renders:**
    - New object/array references, improper key usage, frequent prop changes.


## ✅ Security Questions

46. **How to prevent XSS in React?**
    - React escapes content by default. Avoid `dangerouslySetInnerHTML`.

47. **What is dangerouslySetInnerHTML?**
    - Injects raw HTML; **can lead to XSS vulnerabilities**.

48. **Securing APIs in React:**
    - Use **JWT/OAuth**, HTTPS, and **backend authorization**.

49. **Preventing CSRF in React apps:**
    - CSRF tokens, same-site cookies, server-side validation.

50. **Managing sensitive data in React:**
    - Never store secrets in frontend code. Use backend and secure env configs.


