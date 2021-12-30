import {ServerListResponse} from 'app/model/ServerListResponse';
import {Pizza} from 'app/model/Pizza';
import HttpClient from 'app/api/HttpClient';

const PIZZA_URL = '/pizza';

export class PizzaService {
    static getAllPizza(text: string) {
        return HttpClient.executeGetRequest<ServerListResponse<Pizza>>(`${PIZZA_URL}?text=${text}`);
    }
}
