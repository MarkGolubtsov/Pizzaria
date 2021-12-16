import {UserEmail} from 'app/model/UserEmail';

export class Order {
    id: string = '';

    comment: string = '';

    userDTO: UserEmail = new UserEmail();

    data: string = '';

    isClosed: boolean = false;

    amount: number = 0;
}
