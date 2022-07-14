import {Component, OnInit} from '@angular/core';
import {Tour} from '../../model/tour.model';
import {TourService} from '../../service/tour.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector   : 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls  : ['./tour-list.component.css']
})
export class TourListComponent implements OnInit {
  tours: Tour[];
  tourIdToDelete: string;
  constructor(private tourService: TourService, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.tourService.findAllList(0).subscribe(
      data => {
        console.log(data);
        // @ts-ignore
        this.tours = data.content;
      }
    );
  }
  setIdToDelete(tourIdToDelete) {
    this.tourIdToDelete = tourIdToDelete;
  }

  delete() {
    this.tourService.delete(this.tourIdToDelete).subscribe(
      data => {
        this.toastr.success('Xóa thành công', '', {
          timeOut    : 3000,
          progressBar: false
        });
        this.ngOnInit();
      }, err => {
        this.toastr.warning(`Tour này đã được xét duyệt và có người đăng kí`, '', {
          timeOut    : 3000,
          progressBar: false
        });
      });
  }
}
