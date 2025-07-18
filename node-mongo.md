# 50 Node.js, MongoDB & Backend Architecture Interview Questions with Short Answers

---

## Node.js - Core Concepts & Advanced

1. **Event Loop in Node.js?**

   * Manages concurrency using an event-driven, non-blocking I/O model on a single thread.

2. **process.nextTick vs setImmediate vs setTimeout?**

   * `process.nextTick`: Executes after current operation.
   * `setImmediate`: Executes after I/O events.
   * `setTimeout`: Executes after defined delay.

3. **How do Streams work?**

   * Streams process data chunk by chunk; used for large files.

4. **Clustering in Node.js?**

   * Allows running multiple Node processes to utilize multi-core CPUs.

5. **Memory management in Node.js?**

   * Uses V8's garbage collector with generational collection.

6. **Worker Threads vs Cluster?**

   * Worker threads: multi-threading within a process.
   * Cluster: multiple processes.

7. **Handling uncaught exceptions?**

   * Use `process.on('uncaughtException')` & `process.on('unhandledRejection')`.

8. **Middleware in Express.js?**

   * Functions that handle requests in the request-response cycle.

9. **Securing Node.js API?**

   * Input validation, HTTPS, Helmet, rate limiting, and JWT.

10. **Rate limiting in Node.js?**

    * Using libraries like `express-rate-limit`.

---

## Node.js - Performance & Optimization

11. **Profile Node.js?**

    * Tools: Chrome DevTools, Clinic.js, Node --inspect.

12. **Common memory leaks?**

    * Global variables, closures, event listeners.

13. **Backpressure?**

    * Occurs when writable stream cannot handle data fast enough.

14. **Horizontal scaling?**

    * Use clustering, load balancers, container orchestration.

15. **Async operations methods?**

    * Callbacks, Promises, async/await.

16. **Synchronous code impact?**

    * Blocks event loop, degrades performance.

17. **EventEmitter?**

    * Core module for event-driven programming.

18. **Debug Node.js?**

    * Node Inspector, VS Code debugger, logging.

19. **Logging in distributed systems?**

    * Tools like Winston, Bunyan, centralized via ELK.

20. **Environment configurations?**

    * Use `.env` files with dotenv, Vault for secure storage.

---

## MongoDB - Core & Advanced

21. **Aggregation pipeline?**

    * Data processing pipeline with stages like `$match`, `$group`.

22. **Indexes design?**

    * Use compound, hashed, or text indexes as per query patterns.

23. **Replication?**

    * Replica sets ensure data redundancy.

24. **Sharding?**

    * Distributes data across shards for scalability.

25. **Transactions?**

    * Multi-document transactions supported since MongoDB 4.0.

26. **find vs findOne vs aggregate?**

    * `find`: multiple docs, `findOne`: single doc, `aggregate`: data processing.

27. **CAP theorem for MongoDB?**

    * CP (Consistency and Partition Tolerance).

28. **Schema design best practices?**

    * Use embedding for reads, referencing for writes.

29. **Schema migrations?**

    * Use tools like Mongoose migrations or custom scripts.

30. **Capped collection?**

    * Fixed size, auto-overwrites oldest data.

---

## Backend System Design & Architecture

31. **Rate-limiting system design?**

    * Token bucket, Redis-based counters.

32. **Microservices vs Monolith?**

    * Microservices: scalable, flexible. Monolith: simple but harder to scale.

33. **Notification system design?**

    * Queue + worker architecture with retries.

34. **Event-driven architecture?**

    * System responds to events using pub-sub or message queues.

35. **Eventual consistency?**

    * Use async updates, retries, and idempotency.

36. **CQRS & Event Sourcing?**

    * CQRS: Separate read/write models. Event sourcing: persist state changes as events.

37. **Caching strategies?**

    * In-memory (Redis), CDN, write-through, cache invalidation.

38. **RabbitMQ vs Kafka?**

    * RabbitMQ: low-latency, reliable delivery.
    * Kafka: high throughput, stream processing.

39. **Multi-tenant SaaS backend?**

    * Separate DB per tenant or shared DB with tenant IDs.

40. **Fault tolerance & availability?**

    * Redundancy, failover mechanisms, load balancing.

---

## Security & Best Practices

41. **OWASP Top 10?**

    * SQLi, XSS, CSRF, etc.; prevent via input validation, sanitization.

42. **Secure API endpoints?**

    * Use authentication, authorization, rate limiting.

43. **Stateless auth in REST APIs?**

    * Use JWT, OAuth.

44. **Prevent DDoS?**

    * Rate limiting, CDN, Web Application Firewall (WAF).

45. **Protect data at rest & transit?**

    * Encryption (TLS for transit, AES for rest).

---

## DevOps, Deployment & Monitoring

46. **Containerize Node.js?**

    * Use Docker with a lightweight base image like Alpine.

47. **CI/CD for Node.js + MongoDB?**

    * Tools: GitHub Actions, Jenkins, CircleCI.

48. **Monitoring tools?**

    * Prometheus, Grafana, New Relic, Datadog.

49. **Zero-downtime deployment?**

    * Blue/Green deployment, rolling updates.

50. **Logging & alerting?**

    * ELK Stack, centralized logging with alerts via PagerDuty or Opsgenie.

---
