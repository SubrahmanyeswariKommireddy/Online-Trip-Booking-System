// import { Injectable } from '@angular/core';
// import { HttpClient, HttpHeaders } from '@angular/common/http';



// @Injectable({
//   providedIn: 'root'
// })
// export class HttpClientService {
    
//   constructor(
//     private httpClient:HttpClient
//   ) { 
//      }

     

//      getEmployees()
//   {
//    /*  let username='javainuse'
//     let password='password'
  
//     const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
//    */  
//     const headers = new HttpHeaders({ Authorization: 'Bearer ' + sessionStorage.getItem('token') });
  
//    return this.httpClient.get<Employee[]>('http://localhost:9595/rest/employees',{headers});
//   }

//   public deleteEmployee(employee: any) {
    
//     return this.httpClient.delete<Employee>("http://localhost:9595/rest/employees" + "/"+employee.empId);
//   }

//   public createEmployee(employee: any) {
//     /* let username='javainuse'
//     let password='password'
  
//     const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
//    */
//        return this.httpClient.post<Employee>("http://localhost:9595/rest/employees",employee);
//   }
// }