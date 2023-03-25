import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { PurchaseService } from 'src/app/services/purchase.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit{
  ELEMENT_DATA: any;
  dataSource:any;
  displayedColumns: string[] = ['currency', 'price', 'amount','email','bank','account','status'];
  defaultLeaderBoard:any;

  constructor(private purchaseService:PurchaseService,public dialog: MatDialog ){ }

  getAllPurchases(){
    this.purchaseService.getPurchases(localStorage.getItem('LoggedUserID'),localStorage.getItem("Authorization")).subscribe({
      next: data => {
        this.ELEMENT_DATA = JSON.parse(data);
        console.log('purchases:');
        console.log(this.ELEMENT_DATA);

        this.dataSource = new MatTableDataSource<any>(this.ELEMENT_DATA);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.tableSort;
          },
    error: error => {
        console.error('There was an error!', error);
    }
  });
  }

  ngOnInit() {
    this.getAllPurchases();
  console.log("started");
}

applyFilter(event: Event) {
  const filterValue = (event.target as HTMLInputElement).value;
  this.dataSource.filter = filterValue.trim().toUpperCase();
}

filterBySubject() {
  let filterFunction = 
      (data: any, filter: string): boolean => {
        if (filter) {
          const subjects = data.symbol;
          for (let i = 0; i < subjects.length; i++) {
            if (subjects[i].indexOf(filter) != -1) {
              return true;
            }
          }
          return false;
        } else {
          return true;
        }
     };
  return filterFunction;
}

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  pageSizeOptions: number[] = [5, 10, 25];

  @ViewChild('tableSort') tableSort = new MatSort();

}
