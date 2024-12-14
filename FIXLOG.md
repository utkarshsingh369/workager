# FIXLOG
This file tracks fixes made in the repository along with their respective pull requests (PRs).

---

## 1. [Date: 2024-12-14] Fix #001 - AuthService health check failing (Error 401)
- **Investigation**:
  - 401 unauthorized received for auth-service health.
  - Debugger was not stopping after modelMapper.map() in UserDetailsAuthService.
  - ModelMapper not mapping roles correctly. 
- **Fix**:
  - Changed @ElementCollection FetchType from LAZY to EAGER for role field in User entity to resolve mapping issue with ModelMapper.
- [Fix PR](https://github.com/utkarshsingh369/workager/pull/19)

---