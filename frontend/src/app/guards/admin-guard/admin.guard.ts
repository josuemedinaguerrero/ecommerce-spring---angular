import { CanActivateFn } from '@angular/router';
import { LocalStorageService } from 'src/app/services/storage-service/local-storage.service';

export const adminGuard: CanActivateFn = (route, state) => {
  if (LocalStorageService.isUserLoggedIn()) {
    return true;
  } else if (!LocalStorageService.hasToken()) {
    LocalStorageService.signOut();
    return false;
  }

  return true;
};
