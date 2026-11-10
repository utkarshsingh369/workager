import { ComponentFixture, TestBed } from '@angular/core/testing';
import { afterEach, vi } from 'vitest';
import { HealthCheckComponent } from './health-check.component';

describe('HealthCheckComponent', () => {
  let component: HealthCheckComponent;
  let fixture: ComponentFixture<HealthCheckComponent>;

  beforeEach(async () => {
    vi.stubGlobal('fetch', vi.fn().mockResolvedValue({ ok: true }));

    await TestBed.configureTestingModule({
      imports: [HealthCheckComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(HealthCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  afterEach(() => {
    vi.unstubAllGlobals();
  });

  it('should render the Health Check page', () => {
    expect(component).toBeTruthy();
    const element = fixture.nativeElement as HTMLElement;
    expect(element.querySelector('thead')?.textContent).toContain('Name');
    expect(element.querySelector('thead')?.textContent).toContain('URL');
    expect(element.querySelectorAll('tbody tr')).toHaveLength(2);
    expect(element.querySelector('tbody')?.textContent).toContain('Auth Service');
    expect(element.querySelector('tbody')?.textContent).toContain('localhost:8081');
    expect(element.querySelector('tbody')?.textContent).toContain('User Service');
    expect(element.querySelector('tbody')?.textContent).toContain('localhost:8082');
  });
});
