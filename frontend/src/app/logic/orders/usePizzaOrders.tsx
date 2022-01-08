import {useEffect, useState} from 'react';
import {OrderService} from 'app/service/OrderService';
import {Order} from 'app/model/Order';

export function usePizzaOrders() {
    const [loading, setLoading] = useState(false);

    const [orders, setOrders] = useState<Order[]>([]);

    useEffect(() => {
        loadOrders()
    }, []);

    function closeOrder(id: string) {
        OrderService.closeOrder(id).then(loadOrders)
    }

    function loadOrders() {
        setLoading(true);
        OrderService.getOrders().then((loadOrders) => {
            setOrders(loadOrders.content);
        }).finally(() => setLoading(false));
    }

    return {
        orders,
        loading,
        closeOrder
    }
}
