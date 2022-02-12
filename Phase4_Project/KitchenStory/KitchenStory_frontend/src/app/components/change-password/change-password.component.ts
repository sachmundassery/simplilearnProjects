import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css'],
})
export class ChangePasswordComponent implements OnInit {
  public newPassword: string;
  public confirmPassword: string;

  private getUrl: string = 'http://localhost:8080/admin/changePassword';

  constructor(
    private _router: Router,
    private _activatedRoute: ActivatedRoute,
    private _adminService: AdminService,
    private _httpClient: HttpClient
  ) {}

  ngOnInit(): void {}

  changePassword(newPassword: string, confirmPassword: string): any {
    console.log(newPassword, '----', confirmPassword);
    this._httpClient.put(this.getUrl, newPassword).subscribe((data) => {
      alert('Successfully updated the password.');
      this._router.navigateByUrl('/editProducts');
    });
  }
}
