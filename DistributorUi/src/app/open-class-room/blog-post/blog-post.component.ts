import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-blog-post',
  templateUrl: './blog-post.component.html',
  styleUrls: ['./blog-post.component.css']
})
export class BlogPostComponent implements OnInit {

  @Input() postTitle : string; 
  @Input() postCreated_at : Date;
  @Input() postContent : string;
  @Input() postLoveIts : number;

  constructor() { }

  ngOnInit() {
  }

  getLove(){
    this.postLoveIts = this.postLoveIts + 1;
  }

  getHate(){
    this.postLoveIts = this.postLoveIts - 1;
  }

  getPostLoveIts(){
    return this.postLoveIts; 
  }

}
