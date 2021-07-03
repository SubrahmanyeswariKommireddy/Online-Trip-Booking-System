import { Booking } from "./Booking";


export class Payment{
    transactionId!:Number;
    amount!:Number;
    booking!:Booking;
    
}
enum transactionMode{
    CREDITCARD="creditcard",
	DEBITCARD="debitcard"

}