import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  public chargingStations: Array<{
    plugtype: string,
    geolocation: {
      x: number;
      y: number; }}> = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

}
