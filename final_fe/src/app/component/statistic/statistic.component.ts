import {Component, OnInit} from '@angular/core';
import {TourService} from '../../service/tour.service';
import {Statistic} from '../../model/statistic.model';

@Component({
  selector   : 'app-statistic',
  templateUrl: './statistic.component.html',
  styleUrls  : ['./statistic.component.css']
})
export class StatisticComponent implements OnInit {
  statistics: Statistic[];

  constructor(private tourService: TourService) {
  }

  ngOnInit(): void {
    this.tourService.getStatistic().subscribe(
      data => {
        this.statistics = data;
      }
    );
  }

}
