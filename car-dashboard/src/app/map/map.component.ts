import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

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
      y: number;
    }}> = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit() {

    this.http
      .post("http://localhost:8080/api/charging-stations", {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': 'my-auth-token'
        })
      })
      .subscribe((locations: Array<{ plugtype: string, latitude: number, longitude: number }>) => {
        for (let i = 0; i < locations.length; i++) {
          this.chargingStations.push({
            plugtype: locations[i].plugtype,
            geolocation: {
              x: Number(locations[i].longitude.toFixed(4)),
              y: Number(locations[i].latitude.toFixed(4))
            }
          });
        }

      });

    console.log('finished');
  }

}
