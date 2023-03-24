import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit{
  ELEMENT_DATA: any;
  dataSource:any;
  displayedColumns: string[] = ['currency', 'price', 'amount','email','bank','account','status','actions'];
  defaultLeaderBoard:any;

  constructor(private sellService:AdminService,public dialog: MatDialog ){ }

  getAllSales(){
    this.sellService.getPurchases("123e4567-e89b-12d3-a456-426614174007").subscribe({
      next: data => {
        this.ELEMENT_DATA = data;
        console.log('sells:');
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

  acceptOrder(){
    this.sellService.approveOrder("fe8b641e-36fd-4919-afef-e997735b29ab").subscribe({
      next: data => {
        this.ELEMENT_DATA = data;
        console.log('approved:');
        console.log(this.ELEMENT_DATA);
          },
    error: error => {
        console.error('There was an error!', error);
    }
  });
  window.location.reload();
  }

  rejectOrder(){
    this.sellService.rejectOrder("fe8b641e-36fd-4919-afef-e997735b29ab").subscribe({
      next: data => {
        this.ELEMENT_DATA = data;
        console.log('rejected:');
        console.log(this.ELEMENT_DATA);
          },
    error: error => {
        console.error('There was an error!', error);
    }
  });
  window.location.reload();
  }

  ngOnInit() {
    this.getAllSales();
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