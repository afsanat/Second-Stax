import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ProvidersService } from 'src/app/services/providers.service';

@Component({
  selector: 'app-traders-table',
  templateUrl: './traders-table.component.html',
  styleUrls: ['./traders-table.component.css']
})
export class TradersTableComponent implements OnInit{
  ELEMENT_DATA: any;
  dataSource:any;
  displayedColumns: string[] = ['fname', 'lname', 'email','actions'];
  defaultLeaderBoard:any;

  constructor(private userService:ProvidersService,public dialog: MatDialog ){ }

  getAllProviders(){
    this.userService.getProviders().subscribe({
      next: data => {
        this.ELEMENT_DATA = JSON.parse(data);
        console.log('providers:');
        console.log(this.ELEMENT_DATA.lastName);

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
    this.getAllProviders();
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