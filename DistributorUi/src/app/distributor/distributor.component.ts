import { Component, OnInit } from '@angular/core';
import { FieldService } from 'src/service/field.service';
import { FormGroup, FormBuilder, FormArray } from '@angular/forms';

@Component({
  selector: 'app-distributor',
  templateUrl: './distributor.component.html',
  styleUrls: ['./distributor.component.css']
})
export class DistributorComponent implements OnInit {

  distributorField: any;

  distributorFieldForm: FormGroup = new FormGroup({});

  fakeDistributor: any;

  constructor(
    private fieldService: FieldService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.getFakeDistributor();
    this.initForm();
  }

  initForm() {
    var temp;
    this.fieldService.getDistributorField()
      .subscribe(data => {
        temp = data;
        this.distributorField = temp.CoinJsonHashMapField.strings;

        this.distributorField.forEach(s => {

          this.distributorFieldForm = this.formBuilder.group({
            s: ["toDo"]
          });
        });

      }, err => {
        console.log(err);
      })
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

}

