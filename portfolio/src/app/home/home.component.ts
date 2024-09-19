import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  greetingMessage: string = ''; // This will hold the dynamic greeting message

  // This function sets the greeting based on the time
  setGreeting() {
    const currentHour = new Date().getHours(); // Get the current hour (0-23)

    if (currentHour >= 0 && currentHour < 12) {
      this.greetingMessage = "Good Morning";
    } else if (currentHour >= 12 && currentHour <= 15.5) {
      this.greetingMessage = "Good Afternoon";
    } else if (currentHour > 15.5 && currentHour <= 18.5) {
      this.greetingMessage = "Good Evening";
    } else if (currentHour > 18.5 && currentHour < 24) {
      this.greetingMessage = "Good Night";
    }
  }

  
  ngOnInit(): void {
    this.setGreeting(); 
  }
}
