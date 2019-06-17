import { Component, OnInit } from '@angular/core';
import { FieldService } from 'src/service/field.service';
import { FormGroup, FormBuilder, FormArray, Validators } from '@angular/forms';

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

  constructor(
    private fieldService: FieldService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    //retrieve field from api
    this.getDistributorField();
    //retrieve data (fake)
    this.getFakeDistributor();
    this.initForm();
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
}

