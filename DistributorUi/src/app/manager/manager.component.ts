import { Component, OnInit, Input } from '@angular/core';
import { DistributorServiceService } from '../../service/distributor-service.service';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { formControlBinding } from '@angular/forms/src/directives/ng_model';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  coins:any;
  drinks:any;
  
  selectedCoin : any;
  selectedDrinkName : any;

  nbCoin = new FormControl('');
  nbDrink = new FormControl('');
  form: FormGroup;   

  distributors:any=null;

  distributorSize:number=0;
  
  constructor(
    private distributorServiceService : DistributorServiceService,
    private fb: FormBuilder
    ) { }

  ngOnInit() {
    this.getCoins();
    this.getDrinks();
  }

  selectChangeCoin (event: any) {
    //update the ui
    this.selectedCoin = event.target.value;
    console.log(this.selectedCoin);
  }

  selectChangeDrink (event: any) {
    //update the ui
    this.selectedDrinkName = event.target.value;
    console.log(this.selectedDrinkName);
  }

  getCoins(){
    var temp;
    this.distributorServiceService.getCoins()
    .subscribe(data=>{
      temp = data;
      this.coins = temp.Coin;
      },err=>{
        console.log(err);
      })
        }

        getDrinks(){
          var temp;
          this.distributorServiceService.getDrinks()
          .subscribe(data=>{
            temp=data;
            this.drinks=temp.Drinks;
          },err=>{
            console.log(err);
          })
        }


        onGetCoin(coin:any){
          console.log("coin : " + coin)
        }

        submitJsonBRequest(){
          console.log("selectedCoin : "  + this.selectedCoin);
          console.log("nbCoin : "  + this.nbCoin.value);
          console.log("selectedDrinkName : " + this.selectedDrinkName);
          console.log("nbDrink : " + this.nbDrink.value);
          var temp;
          this.distributorServiceService.getDistributorDtoIfCoinIfDrink(
            this.selectedCoin,
            this.nbCoin.value,
            this.selectedDrinkName,
            this.nbDrink.value
          ).subscribe(data=>{
            temp = data;
            this.distributors=temp.Distributors;
              this.distributorSize = this.distributors.length;
            },err=>{
              console.log(err);
            })
        }
}
