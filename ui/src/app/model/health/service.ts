export interface Service {
  name: string;
  domain: string;
  path: string;
  port: number;
  isLocalHost: true;
  lastChecked?: Date;
  status?: 'UP' | 'DOWN';
}
