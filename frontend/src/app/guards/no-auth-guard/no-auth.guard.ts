import { CanActivateFn, Router } from '@angular/router';
import { LocalStorageService } from 'src/app/services/storage-service/local-storage.service';

export const noAuthGuard: CanActivateFn = (route, state) => {
  if (LocalStorageService.hasToken() && LocalStorageService.isUserLoggedIn()) {
    return false;
  } else if (LocalStorageService.hasToken() && LocalStorageService.isAdminLoggedIn()) {
    return false;
  }

  return true;
};
