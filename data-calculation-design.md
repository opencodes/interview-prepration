
✅ Daily Data Generation Pre Estimate

| Count              | Size per Record | Total Data Size |
| ------------------ | --------------- | --------------- |
| **1 Million (1M)** | 1 KB            | 1 GB            |
| **1 Million (1M)** | 10 KB           | 10 GB           |
| **1 Million (1M)** | 100 KB          | 100 GB          |
| **1 Million (1M)** | 1 MB            | 1 TB            |
|         -           |     -            |      -           |
| **1 Billion (1B)** | 1 KB            | 1 TB            |
| **1 Billion (1B)** | 10 KB           | 10 TB           |
| **1 Billion (1B)** | 100 KB          | 100 TB          |
| **1 Billion (1B)** | 1 MB            | 1 PB            |

📌 Note:
- 1 KB = 1024 Bytes
- 1 MB = 1024 KB
- 1 GB = 1024 MB
- 1 TB = 1024 GB
- 1 PB = 1024 TB

✅ Problem Statement:

Design Facebook Posts System

- 2 Billion DAU (Daily Active Users)

- Each user posts 1 post per day

- Posts contain text (~1 KB) + image (~100 KB)



✅ Daily Data Generation Estimate
| Metric          | Value                        |
| --------------- | ---------------------------- |
| Posts/day       | 2B users × 1 = 2B posts/day  |
| Text size/post  | 1 KB                         |
| Image size/post | 100 KB                       |
| Total size/post | \~101 KB                     |
| Daily data      | 2B × 101 KB ≈ **202 TB/day** |
| Monthly data    | 202 TB × 30 ≈ **6 PB/month** |



⚠️ Add 30–50% for metadata, index, replication → Total ≈ 9 PB/month


✅ 2. QPS Estimation (API Frequency)

📤 Post Write API:
- 2B posts/day

- Spread over 24 hrs → 2B / 86400 ≈ ~23,000 QPS

- Peak QPS = 5× → ~115,000 QPS

📥 Read API (feed + profile + share):
- Assume each user does 100 read actions/day

- 2B × 100 = 200B reads/day

- QPS = 200B / 86400 ≈ ~2.3 million QPS

- Peak Read QPS could hit 10–15 million+

✅ QPS Estimation Tips

| Users       | 1 Action/User/Day | 10 Actions | 100 Actions |
| ----------- | ----------------- | ---------- | ----------- |
| 1 Million   | 11.5 QPS          | 115 QPS    | 1.15K QPS   |
| 10 Million  | 115 QPS           | 1.15K QPS  | 11.5K QPS   |
| 100 Million | 1.15K QPS         | 11.5K QPS  | 115K QPS    |
| 1 Billion   | 11.5K QPS         | 115K QPS   | 1.15M QPS   |
