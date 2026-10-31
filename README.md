# Java SRE Observability Lab

A hands-on project demonstrating the core pillars of Site Reliability Engineering (SRE): monitoring, observability, and infrastructure as code.

## Architecture
- **Application:** Java Spring Boot (instrumented with Micrometer)
- **Metrics Collection:** Prometheus (scraping every 5 seconds)
- **Visualization:** Grafana (live dashboards)
- **Deployment:** Docker Compose (Host Networking)

## How It Works
1. The Java application exposes a metrics endpoint at `/actuator/prometheus`.
2. Prometheus scrapes this endpoint to collect JVM memory, thread counts, and CPU usage.
3. Grafana connects to Prometheus to visualize the data in real-time.

## Getting Started
To run this locally:
1. Start the Java app: `./mvnw spring-boot:run`
2. Start the monitoring stack: `docker compose up -d`
3. Open Grafana at `http://localhost:3000` (admin/admin)

## Dashboard
The Grafana dashboard JSON is provided in this repository for easy import.
