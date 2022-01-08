import {Order} from 'app/model/Order';
import 'app/logic/orders/OrderListItem.css';
import {Button, Card} from 'antd';

type OrderListItemProps = {
    order: Order;

    closeOrder: () => void;
}

export default function OrderListItem({order, closeOrder}: OrderListItemProps) {

    return (
        <Card className='order-list-item' title={`Order for ${order.contact}`} bordered={false} style={{width: 300}}>
            <div className='order-list-item__closes'>
                Status: {order.closed ? 'Closed' : 'Active'}
            </div>
            <div className='order-list-item__closes'>
                Date: {order.date.split('T').reverse().join(' ')}
            </div>
            <div className='order-list-item__closes'>
                Amount: {order.amount}
            </div>
            {
                order.pizzaOrders.map((value) => {
                    return <div className='order-list__pizza-data'>
                        <span>{`Pizza: ${value.pizza.name}, Quantuty: ${value.quantity}`}</span>
                    </div>
                })
            }

            {
                !order.closed &&
                <Button onClick={closeOrder}>
                    Close
                </Button>
            }
        </Card>

    )
}
