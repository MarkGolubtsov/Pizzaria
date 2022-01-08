import {PizzaOrder} from 'app/model/PizzaOrder';
import HttpClient from 'app/api/HttpClient';
import {ServerListResponse} from 'app/model/ServerListResponse';
import {Order} from 'app/model/Order';

const ORDERS_URL = '/orders';

export class OrderService {

    static createOrder(pizzaOrders: PizzaOrder[], contact: string) {
        return HttpClient.executePostRequest(ORDERS_URL, {
            pizzaOrders: pizzaOrders.map(it => {
                return {
                    pizza: it.pizza.id,
                    quantity: it.quantity
                }
            }),
            contact: contact
        })
    }

    static getOrders(): Promise<ServerListResponse<Order>> {
        return HttpClient.executeGetRequest(ORDERS_URL)
    }

    static closeOrder(id: string) {
        return HttpClient.executePutRequest(`${ORDERS_URL}/${id}/close`, {})
    }
}
