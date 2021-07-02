import { Bus } from "./Bus";

export class Route{
    id!:Number;
    source:string='';
    destination:string='';
    bus!:Bus;
    date!:Date;
}