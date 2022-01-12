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
                            key={item.id}
                            closeOrder={getCloseOrder(item.id)}
                            order={item}/>)}
                </div>
            }
            {
                !loading && !orders.length &&
                <div className='pizza-order-list'>
                    Orders not found.
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
