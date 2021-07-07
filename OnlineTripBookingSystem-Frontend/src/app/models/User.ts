export class User {
id!:number;
    userName: string = '';
    password: string = '';
    userType: string = '';
    email: string = '';
    mobileNumber: string = '';


}
enum userType {
    ADMIN = "admin",
    CUSTOMER = "customer"

}



