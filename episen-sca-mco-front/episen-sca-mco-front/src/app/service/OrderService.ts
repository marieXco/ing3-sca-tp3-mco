import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OrderService{
  constructor(private http: HttpClient) {
  }
  addOrder(order: string ): void {
    console.log(order);
    this.http.post<any>(`http://192.168.99.100:8080/add/order`, order).subscribe(data => {
      console.log("It's OK");
    });
  }
}
