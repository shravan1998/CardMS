import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CardMSServiceService } from '../card-msservice.service';

@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.css']
})
export class EditCardComponent implements OnInit {
  cardForm!:FormGroup;
  constructor(private fb:FormBuilder,private cardService:CardMSServiceService) { }
  monthName!:String;
  expiryDate!:Date;
  month!:String;
  ngOnInit(): void {
    this.cardForm = this.fb.group({
      CardNo:['',[Validators.required]],
      username:['',[Validators.required]],
      MM:['',[Validators.required,Validators.min(1),Validators.max(12)]],
      YY:['',[Validators.required,Validators.min(2021),Validators.max(2030)]]
    });
  }
  onSubmit(){
    if(this.cardForm.value.MM<=7 && this.cardForm.value.YY==2021){
      alert("Credit Card is expired");
    }else{
      
      switch(parseInt(this.cardForm.value.MM)){
        case 1:
          this.month = "January";
          break;
        case 2:
          this.month ="February";
          break;
        case 3:
          this.month="March";
          break;
        case 4:
          this.month="April";
          break;
        case 5:
          this.month="May";
          break;
        case 6:
          this.month="June";
          break;
        case 7:
          this.month="July";
          break;
        case 8:
          this.month="August";
          break;
        case 9:
          this.month="September";
          break;
        case 10:
          this.month="October";
          break;
        case 11:
          this.month="November";
          break;
        case 12:
          this.month ="December";
          break;
      }
      let Object={
        "cardNumber":this.cardForm.value.CardNo,
        "nameOnCard":this.cardForm.value.username,
        "expiryDate":new Date(this.month+" "+this.cardForm.value.YY)
      }
      this.cardService.addCC(sessionStorage.getItem("userId"),Object).subscribe((response:any)=>{
        console.log(response);
      });
    }
  }

}
