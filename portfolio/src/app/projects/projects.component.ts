import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent {
    projects = [
      { name: 'Project 1', description: 'Description of project 1' },
      { name: 'Project 2', description: 'Description of project 2' },
      { name: 'Project 3', description: 'Description of project 3' }
    ];
}
