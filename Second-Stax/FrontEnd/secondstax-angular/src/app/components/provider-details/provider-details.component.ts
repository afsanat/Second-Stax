import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { ProviderDetailServiceService } from 'src/app/services/provider-detail-service.service';
import { OrderModalComponent } from '../order-modal/order-modal.component';

@Component({
  selector: 'app-provider-details',
  templateUrl: './provider-details.component.html',
  styleUrls: ['./provider-details.component.css']
})
export class ProviderDetailsComponent implements OnInit{
  providerid:any;
  ELEMENT_DATA: any;
  dataSource:any;
  displayedColumns: string[] = ['fname', 'lname', 'email','actions'];
  defaultLeaderBoard:any;

  constructor(private route:ActivatedRoute,private detailsService:ProviderDetailServiceService,public dialog: MatDialog ){ }

  getProvidersDetails(){
    this.providerid = this.route.snapshot.params['providerid'];

    this.detailsService.getProviderDetails(this.providerid).subscribe({
      next: data => {
        this.ELEMENT_DATA = JSON.parse(data);
        console.log('details:');
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
    this.getProvidersDetails();
  console.log("started");
}

openDialog(productId:any) {
  const dialogRef = this.dialog.open(OrderModalComponent, {
    data: {
      dataId: productId} }); 
  
  dialogRef.afterClosed().subscribe((shouldReload) => {
    console.log(`Dialog result: ${shouldReload}`);
    this.getProvidersDetails();
     //window.location.reload()
  });
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