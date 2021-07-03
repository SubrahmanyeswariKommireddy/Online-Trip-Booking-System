import { Payment } from "./Payment";

export class Booking{
    bookingId!:Number;
    seatsBooked:string='';
    dateAndTimeOfTravel!: Date;
    payment!:Payment
}