import { BusBooking } from "./BusBooking";
import { User } from "./User";

export class Customer {
    id!:number;
    userName: string = '';
    password: string = '';
    email: string = '';
    mobileNumber: string = '';
    booking!:BusBooking;
}