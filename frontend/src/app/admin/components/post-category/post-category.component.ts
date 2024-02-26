import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../../admin-service/admin.service';

@Component({
  selector: 'app-post-category',
  templateUrl: './post-category.component.html',
  styleUrls: ['./post-category.component.scss'],
})
export class PostCategoryComponent {
  catgoryForm: FormGroup = new FormGroup({});

  constructor(private adminService: AdminService, private fb: FormBuilder) {}

  ngOnInit() {
    this.catgoryForm = this.fb.group({
      name: [null, [Validators.required]],
      description: [null, [Validators.required]],
    });
  }

  postCategory() {
    this.adminService.postCategory(this.catgoryForm.value).subscribe({
      next: (res) => {
        console.log({ res });
      },
      error: (err) => {
        console.log({ err });
      },
    });
  }
}
