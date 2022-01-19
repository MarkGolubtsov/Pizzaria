import {Order} from 'app/model/Order';
import 'app/logic/orders/OrderListItem.css';
import {Button, Card} from 'antd';

type OrderListItemProps = {
    order: Order;

    closeOrder: () => void;
}

export default function OrderListItem({order, closeOrder}: OrderListItemProps) {

    return (
        <Card className='order-list-item' title={`Заказ для: ${order.contact}`} bordered={false} style={{width: 300}}>
            <div className='order-list-item__closes'>
                Статус: {order.closed ? 'Закрыт' : 'Активен'}
            </div>
            <div className='order-list-item__closes'>
                Дата: {order.date.split('T').reverse().join(' ')}
            </div>
            <div className='order-list-item__closes'>
                Сумма: {order.amount}
            </div>
            {
                order.pizzaOrders.map((value) => {
                    return <div key={value.pizza.id} className='order-list__pizza-data'>
                        <span>{`Пицца: ${value.pizza.name}, Количество: ${value.quantity}`}</span>
                    </div>
                })
            }

            {
                !order.closed &&
                <Button onClick={closeOrder}>
                    Закрыть
                </Button>
            }
        </Card>

    )
}
