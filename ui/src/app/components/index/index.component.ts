import { Component, OnInit } from '@angular/core';
import {IImage} from "ng-simple-slideshow";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  imageUrls: (string | IImage)[] = [{url: 'assets/images/Sourcing_a_Supplier.jpg'}];
  height: string = '600px';

  centered = false;
  disabled = false;
  unbounded = false;

  radius: number;
  color: string;

  constructor() { }

  ngOnInit() {
  }

}
