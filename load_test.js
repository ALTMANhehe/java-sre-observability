import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 50, // 50 Virtual Users
  duration: '30s', // Run for 30 seconds
};

export default function () {
  http.get('http://localhost:8080/hello');
  sleep(0.1); // Wait 100ms between requests
}
