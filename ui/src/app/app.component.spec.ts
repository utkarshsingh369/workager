import { beforeEach, describe, expect, it } from 'vitest';
import { TestBed } from '@angular/core/testing';
import { provideRouter } from '@angular/router';
import { AppComponent } from './app.component';
import { routes } from './app.routes';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent],
      providers: [provideRouter(routes)]
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have the 'ui' title`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('ui');
  });

  it('should navigate to the selected page and mark its link active', async () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();

    const compiled = fixture.nativeElement as HTMLElement;
    const healthLink = compiled.querySelector<HTMLAnchorElement>('a[routerLink="/health-check"]');
    healthLink?.click();
    await fixture.whenStable();
    fixture.detectChanges();

    expect(compiled.querySelector('app-health-check')).toBeTruthy();
    expect(healthLink?.classList.contains('active')).toBe(true);
    expect(healthLink?.getAttribute('aria-current')).toBe('page');
    expect(compiled.querySelector('.nav-link[routerLink="/"]')?.classList.contains('active')).toBe(false);
  });

  it('should return to Home when the brand link is clicked', async () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    compiled.querySelector<HTMLAnchorElement>('a[routerLink="/contact"]')?.click();
    await fixture.whenStable();
    fixture.detectChanges();

    const contactLink = compiled.querySelector('a[routerLink="/contact"]');
    expect(compiled.querySelector('app-contact')).toBeTruthy();
    expect(contactLink?.classList.contains('active')).toBe(true);

    compiled.querySelector<HTMLAnchorElement>('.navbar-brand')?.click();
    await fixture.whenStable();
    fixture.detectChanges();

    const homeLink = compiled.querySelector('.nav-link[routerLink="/"]');
    expect(compiled.querySelector('app-home')).toBeTruthy();
    expect(homeLink?.classList.contains('active')).toBe(true);
    expect(homeLink?.getAttribute('aria-current')).toBe('page');
    expect(compiled.querySelector('a[routerLink="/contact"]')?.classList.contains('active')).toBe(false);
  });
});
