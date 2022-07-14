import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {BoundService} from '../../service/bound.service';
import {TourTypesService} from '../../service/tour-types.service';
import {Bound} from '../../model/bound.model';
import {TourType} from '../../model/tour-type.model';
import {Customer} from '../../model/customer.model';
import {TourService} from '../../service/tour.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector   : 'app-tour-create',
  templateUrl: './tour-create.component.html',
  styleUrls  : ['./tour-create.component.css']
})
export class TourCreateComponent implements OnInit {
  successStatus: boolean;
  createForm: FormGroup;
  bounds: Bound[];
  customers: Customer[];
  tourTypes: TourType[];
  submitted = false;
  MESSAGE_CODE = {
    required: 'Vui Lòng Không Để Trống.'
  };

  constructor(private customerService: CustomerService,
              private boundService: BoundService,
              private tourService: TourService,
              private toastr: ToastrService,
              private tourTypesService: TourTypesService) {
  }

  ngOnInit(): void {
    this.customerService.findAllList().subscribe(
      data => this.customers = data,
      err => console.log(err),
      () => this.boundService.findAll().subscribe(
        data => this.bounds = data,
        err => console.log(err),
        () => this.tourTypesService.findAll().subscribe(
          data => this.tourTypes = data,
          err => console.log(err),
          () => {
            this.createForm = new FormGroup({
              creator             : new FormControl(null, [Validators.required]),
              tourType            : new FormControl(null, [Validators.required]),
              bound               : new FormControl(null, [Validators.required]),
              tourName            : new FormControl('', [Validators.required]),
              destination         : new FormControl('', [Validators.required]),
              startDate           : new FormControl('', [Validators.required]),
              finishDate          : new FormControl('', [Validators.required]),
              closedRegisterDate  : new FormControl('', [Validators.required]),
              peopleAllowed       : new FormControl(0, [Validators.required]),
              plans               : new FormControl('', [Validators.required]),
              participant_required: new FormControl('', [Validators.required]),
              cost                : new FormControl(0, [Validators.required]),
            });
          } 
        )
      )
    );
  }

  onSubmit() {
    this.submitted = true;
    if (this.createForm.valid) {
      this.tourService.create(this.createForm.value).subscribe(
        data => {
          this.toastr.success('Thêm mới thành công', '', {
            timeOut    : 3000,
            progressBar: false
          });
        },
        err => {
          this.toastr.warning(`${err.error.peopleAllowed}`, '', {
            timeOut    : 3000,
            progressBar: false
          });
        }
      );
    }
  }
}
