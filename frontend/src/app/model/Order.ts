import {PizzaOrdersFull} from 'app/model/PizzaOrdersFull';

export class Order {
    id: string = '';

    comment: string = '';

    contact: string = '';

    pizzaOrders: PizzaOrdersFull[] = []

    date: string = '';

    closed: boolean = false;

    amount: number = 0;
}
