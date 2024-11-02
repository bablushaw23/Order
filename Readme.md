This project is done to test generating Trace-Id and Span-Id across microservices.
Intention is to check if distributed log can be traced.
During POC, this MS calls Payment MS API and logs on both side seen to generate common Trace-id but
different span-id which was expected.

Observation drawn:
1. This setup (dependency and config) have to be used across all MS in system to keep consistency.
2. Using trace-id we can track the data flow
