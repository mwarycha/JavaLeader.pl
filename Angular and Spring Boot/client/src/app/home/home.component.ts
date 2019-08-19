import { OktaAuthService   } from '@okta/okta-angular';
import { Component, OnInit } from '@angular/core';

@Component({
  selector    : 'app-home',
  templateUrl : './home.component.html',
  styleUrls   : ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isAuthenticated: boolean;

  constructor(private oktaAuth: OktaAuthService) {
  }

  async ngOnInit() {
    this.isAuthenticated = await this.oktaAuth.isAuthenticated();
    // Subscribe to authentication state changes
    this.oktaAuth.$authenticationState.subscribe(
      (isAuthenticated: boolean)  => this.isAuthenticated = isAuthenticated
    );
  }
}
