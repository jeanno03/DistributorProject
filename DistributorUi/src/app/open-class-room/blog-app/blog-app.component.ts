import { Component, OnInit } from '@angular/core';
import { resolve } from 'url';

@Component({
  selector: 'app-blog-app',
  templateUrl: './blog-app.component.html',
  styleUrls: ['./blog-app.component.css']
})
export class BlogAppComponent implements OnInit {

  constructor() { }

    constContent : string = 'Derrière un Kyle Lowry exemplaire (26 points, 10 passes, 7 rebonds) et un Fred VanVleet (22 points, dont 12 dans le dernier quart-temps) décisif en fin de match, Toronto remporte le Game 6 et son premier titre NBA (114-110) !';
    dateCreation = new Promise((resolve,reject)=>{
      const date = new Date();
      setTimeout(
        ()=>{
          resolve(date);
        },2000
      );
    });

  posts=[
    {
      title:'Mon premier post',
      content:this.constContent,
      loveIts:0,
      created_at:this.dateCreation
    },
    {
      title:'Mon deuxième post',
      content:this.constContent,
      loveIts:0,
      created_at:this.dateCreation
    },  
    {
      title:'Mon troisième post',
      content:this.constContent,
      loveIts:0,
      created_at:this.dateCreation
    }, 
  ];

  ngOnInit() {
  }

}
