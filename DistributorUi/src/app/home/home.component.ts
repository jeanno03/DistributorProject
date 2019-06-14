import { Component, OnInit } from '@angular/core';
import { DistributorServiceService } from '../../service/distributor-service.service';
import { MyUserServiceService } from '../../service/my-user-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

distributorsDto:any;
distributors:any;
distributor:any;

myUserDto:any;
myUsers:any;
myRoleJsonHashSet:any;

coin:any;
line:any;

  constructor(
    private distributorServiceService:DistributorServiceService,
    private myUserServiceService:MyUserServiceService) { }

  ngOnInit() {
    this.myUsers=null;
    this.distributors=null;
    this.myRoleJsonHashSet=null;
    this.distributor = null;
  }

  generateDistributorDataTest(){
    this.distributorServiceService.generateDataTest()
    .subscribe(data=>{
      /* data; */
      this.myUsers=null;
      this.distributors=null;
      this.myRoleJsonHashSet=null;
      this.distributor = null;
      alert("Done !");    
    }, err => {
      console.log(err);
    })
  }

  getAllDistributors(){
    this.distributorServiceService.getAllDistributorDto()
    .subscribe(data=>{
      this.myUsers=null;
      this.distributors=null;
      this.myRoleJsonHashSet=null;
      this.distributorsDto = data;
      this.distributors= this.distributorsDto.Distributors;
      this.distributor = null;
    }, err => {
      console.log(err);
    })
  }

  getDistributorDetails(distributor:any){
    this.distributor=distributor;
    this.coin = distributor.coinJsonHashMap;
    this.line = distributor.distributorLineDtos;
  }

  generateMyUsers(){
    this.myUserServiceService.generateMyUsers()
    .subscribe(data=>{
    /*data; */
    this.myUsers=null;
    this.distributors=null;
    this.myRoleJsonHashSet=null;
    this.distributor = null;
      alert("Done !");
    },err=>{
      this.myUsers=null;
      this.distributors=null;
      this.myRoleJsonHashSet=null;
      this.distributor = null;
      alert("Done already");
      console.log(err);
    })
  }

  getAllMyUsers(){
    this.myUserServiceService.getAllMyUsers()
    .subscribe(data=>{
      this.myUsers=null;
      this.distributors=null;
      this.myRoleJsonHashSet=null;
      this.distributor = null;
      this.myUserDto = data;
      this.myUsers = this.myUserDto.MyUserDtos;
    },err=>{
      console.log(err);
    })   
  }

  displayMyRole(myUsers:any){
    this.myRoleJsonHashSet=myUsers.myRoleJsonHashSet;
  }
  

}
