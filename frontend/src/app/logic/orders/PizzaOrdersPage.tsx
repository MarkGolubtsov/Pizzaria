import React from 'react';
import {usePizzaOrders} from 'app/logic/orders/usePizzaOrders';
import {Spin} from 'antd';
import OrderListItem from 'app/logic/orders/OrderListItem';
import 'app/logic/orders/PizzaOrdersPage.css';

export default function PizzaOrdersPage() {

    const {loading, orders, closeOrder} = usePizzaOrders();

    return (
        <div className='pizza-orders-page'>
            {loading ? <Spin/> :
                <div className='pizza-order-list'>
                    {orders.map((item) =>
                        <OrderListItem
                            closeOrder={getCloseOrder(item.id)}
                            key={item.id}
                            order={item}/>)}
                </div>
            }
        </div>
    )

    function getCloseOrder(id: string) {
        return () => {
            closeOrder(id);
        }
    }
}
