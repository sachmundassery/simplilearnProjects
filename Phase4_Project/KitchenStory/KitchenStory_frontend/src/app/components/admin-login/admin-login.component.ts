import { AdminService } from './../../services/admin.service';
import { Admin } from './../../models/admin';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css'],
})
export class AdminLoginComponent implements OnInit {
  admin: Admin = new Admin();

  adminValidated: boolean;
  constructor(
    private _adminService: AdminService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {}

  validateAdmin(): any {
    this._adminService.validateAdmin(this.admin).subscribe((data) => {
      if (data) {
        this._router.navigateByUrl('/admin/changePassword');
      } else {
        alert('Wrong credentials');
        this._router.navigateByUrl('/admin');
      }
    });
    //
  }
}
