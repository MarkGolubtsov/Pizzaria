import {Pizza} from 'app/model/Pizza';

export class PizzaOrder {

    constructor(pizza: Pizza, quantity: number = 1) {
        this.pizza = pizza;
        this.quantity = quantity;
    }

    pizza: Pizza;

    quantity: number;
}
