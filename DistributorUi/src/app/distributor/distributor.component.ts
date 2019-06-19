import { Component, OnInit } from '@angular/core';
import { FieldService } from 'src/service/field.service';
import { FormGroup, FormBuilder, FormArray, Validators } from '@angular/forms';
import { DistributorServiceService } from 'src/service/distributor-service.service';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

@Component({
  selector: 'app-distributor',
  templateUrl: './distributor.component.html',
  styleUrls: ['./distributor.component.css']
})
export class DistributorComponent implements OnInit {

  distributorField: any;
  distributorFieldForm: FormGroup = new FormGroup({});
  fakeDistributor: any;
  distributorItems: [any] = [{}];
  distributors:any;
  rows = [];
  constructor(
    private fieldService: FieldService,
    private formBuilder: FormBuilder,
    private distributorServiceService: DistributorServiceService
  ) { }

  ngOnInit() {
    //retrieve field from api
    this.getDistributorField();
    //retrieve data (fake)
    this.getFakeDistributor();
    this.initForm();
    this.fetch((data) => {
      this.rows = data;
    });
  }

  getDistributorField() {
    var temp;
    this.fieldService.getDistributorField()
      .subscribe(data => {
        temp = data;
        this.distributorField = temp.CoinJsonHashMapField.strings;

        this.getDistributorItems();
      }, err => {
        console.log(err);
      })

  }

  initForm() {
    this.distributorFieldForm = this.formBuilder.group({
      distribArray: this.formBuilder.array([])
    });
  }

  onSubmitForm() {
    //ToDo
  }

  getFakeDistributor() {
    this.fakeDistributor = [
      "162.11€",
      "45 pièces",
      "28 pièces",
      "96 pièces",
      "45 pièces",
      "9 pièces",
      "20 pièces",
      "10 pièces",
      "15 pièces",
    ]
  }

  getDistributorItems() {
    //link field and value
    for (var i = 0; i < this.distributorField.length; i++) {
      var distributorItem = { field: '', value: '' };
      distributorItem.field = this.distributorField[i];
      distributorItem.value = this.fakeDistributor[i];
      this.distributorItems.push(distributorItem);
    }
  }

  fetch(cb) {
    const req = new XMLHttpRequest();
    // req.open('GET', `http://localhost:8080/DistributorBack_war/api/distributor/getAllDistributorsDto`);
    req.open('GET', `http://swimlane.github.io/ngx-datatable/assets/data/company.json`);
    req.onload = () => {
      const data = JSON.parse(req.response);
      cb(data);
    }, err => {
      console.log(err);
    };
    req.send();
  }

  

}

