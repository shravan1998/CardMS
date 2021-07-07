import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.css']
})
export class EditCardComponent implements OnInit {
  cardForm!:FormGroup;
  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
    this.cardForm = this.fb.group({
      CardNo:['',[Validators.required]],
      username:['',[Validators.required]],
      MM:['',[Validators.required,Validators.min(1),Validators.max(12)]],
      YY:['',[Validators.required,Validators.min(2021),Validators.max(2030)]]
    });
  }
  onSubmit(){

  }

}
