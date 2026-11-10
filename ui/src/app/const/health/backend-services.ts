import { Service } from '../../model/health/service';

export const BACKEND_SERVICES: Service[] = [
  {
    name: 'Auth Service',
    domain: 'localhost',
    port: 8081,
    path: '/api/v1/auth/health',
    isLocalHost: true
  },
  {
    name: 'User Service',
    domain: 'localhost',
    port: 8082,
    path: '/api/v1/user/health',
    isLocalHost: true
  }
];
