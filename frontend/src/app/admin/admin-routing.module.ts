import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { adminGuard } from '../guards/admin-guard/admin.guard';
import { PostCategoryComponent } from './components/post-category/post-category.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent, canActivate: [adminGuard] },
  { path: 'category', component: PostCategoryComponent, canActivate: [adminGuard] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {}
