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

  public parkingLots: Array<{
    geolocation: {
      x: number;
      y: number;
    }}> = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit() {

    // charging stations
    this.http
      .get("http://localhost:8080/api/chargingStationModels", {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': 'my-auth-token'
        })
      })
      .subscribe((locations: {
          _embedded: {
            chargingStationModels: [
              {
                plugType: string,
                latitude: number,
                longitude: number
              }
            ]
          }
       }) => {

        for (let i = 0; i < locations._embedded.chargingStationModels.length; i++) {
          this.chargingStations.push({
            plugtype: locations._embedded.chargingStationModels[i].plugType,
            geolocation: {
              x: Number(locations._embedded.chargingStationModels[i].longitude.toFixed(4)),
              y: Number(locations._embedded.chargingStationModels[i].latitude.toFixed(4))
            }
          });
        }

      });

    // parking lots
    this.http
      .get("http://localhost:8080/api/parkingLotModels", {
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': 'my-auth-token'
        })
      })
      .subscribe((locations: {
        _embedded: {
          parkingLotModels: [
            {
              plugType: string,
              latitude: number,
              longitude: number
            }
            ]
        }
      }) => {

        for (let i = 0; i < locations._embedded.parkingLotModels.length; i++) {
          this.parkingLots.push({
            geolocation: {
              x: Number(locations._embedded.parkingLotModels[i].longitude.toFixed(4)),
              y: Number(locations._embedded.parkingLotModels[i].latitude.toFixed(4))
            }
          });
        }

      });

    console.log('finished');
  }

}
